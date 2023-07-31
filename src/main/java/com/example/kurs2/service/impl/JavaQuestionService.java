package com.example.kurs2.service.impl;

import com.example.kurs2.Exception.QuestionNotFoundException;
import com.example.kurs2.Exception.QveationAlredyExistsException;
import com.example.kurs2.Exception.StorageIsEmptyException;
import com.example.kurs2.model.Question;
import com.example.kurs2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions = new HashSet<>();
    private static final Random RANDOM = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.add(question)) {
            return question;
        }
        throw new QveationAlredyExistsException();
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new StorageIsEmptyException();
        }
        int index = RANDOM.nextInt(questions.size());
        return questions.stream()
                .skip(index) // пропустить рандомное количество элементов
                .findFirst()// берем их оставшихся перввый элемент
                .orElseThrow(QuestionNotFoundException::new);

    }
}


