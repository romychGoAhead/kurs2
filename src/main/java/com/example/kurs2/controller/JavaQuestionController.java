package com.example.kurs2.controller;

import com.example.kurs2.model.Question;
import com.example.kurs2.service.QuestionService;
import com.example.kurs2.service.impl.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java/")
public class JavaQuestionController {
    private final QuestionService service;

    public JavaQuestionController(JavaQuestionService service) {
        this.service = service;

    }

    @GetMapping("/add")
    public Question add(@RequestParam(name = "question") String question,
                        @RequestParam(name = "answer") String answer) {

        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam(name = "question") String question,
                           @RequestParam(name = "answer") String answer) {

        return service.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getAll() {
        return service.getAll();
    }

}






