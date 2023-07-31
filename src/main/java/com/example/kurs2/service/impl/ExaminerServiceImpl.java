package com.example.kurs2.service.impl;

import com.example.kurs2.Exception.NonEnoughQuestionException;
import com.example.kurs2.model.Question;
import com.example.kurs2.service.ExaminerService;
import com.example.kurs2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service

public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }

    @Override

    public Collection<Question> getQuestions(int amount) {
        if (amount > service.getAll().size()) {
            throw new NonEnoughQuestionException();
        }
        return Stream.generate(service::getRandomQuestion)
                .distinct()
                .limit(amount)
                .collect(Collectors.toList());


    }
}

