package com.example.kurs2.Service;

import com.example.kurs2.model.Question;
import com.example.kurs2.service.impl.JavaQuestionService;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    JavaQuestionService service = new JavaQuestionService();


    @Test
    void add() {
        Question q1 = new Question("ofk", "kft");
        Question q2 = new Question("bhj", "azs");
        service.add(q1);
        service.add(q2);


        Collection<Question> actual = service.getAll();
        assertEquals(2, actual.size());
        assertTrue(actual.contains(q1));
        assertTrue(actual.contains(q2));

        service.remove(q1);
        assertEquals(1, actual.size());
        assertFalse(actual.contains(q1));
        assertTrue(actual.contains(q2));
    }
}



