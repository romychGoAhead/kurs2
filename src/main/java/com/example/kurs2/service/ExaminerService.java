package com.example.kurs2.service;

import com.example.kurs2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

}
