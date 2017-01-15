package com.example.controller;

import com.example.service.CodeEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeEvaluatorController {

    @Autowired
    private CodeEvaluationService evaluationService;

    @RequestMapping(path = "code/evaluate", method = RequestMethod.POST)
    public String evaluate(@RequestParam(name = "code") String code, @RequestParam(name = "language", defaultValue = "groovy") String language) {
        return evaluationService.evaluate(code, language);
    }

}
