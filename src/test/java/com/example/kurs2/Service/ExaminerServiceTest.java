package com.example.kurs2.Service;

import com.example.kurs2.model.Question;
import com.example.kurs2.service.QuestionService;
import com.example.kurs2.service.impl.ExaminerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;
    private List<Question> questions = List.of(

            new Question("qwe", "elk"),
            new Question("gfd", "etg"),
            new Question("kmn", "cvt")
    );

    @Test
    void getQuestions() {

        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion())
                .thenReturn(questions.get(2))
                .thenReturn(questions.get(0))
                .thenReturn(questions.get(0))
                .thenReturn(questions.get(1));

        Collection<Question> actual = examinerService.getQuestions(3);
        assertEquals(3, actual.size());
        assertTrue(questions.containsAll(actual));
    }

}
