package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeEvaluationService {

    @Autowired
    private CodeEvaluatorProvider codeEvaluatorProvider;

    public String evaluate(String code, String language) {
        AbstractEvaluator evaluator = codeEvaluatorProvider.getByLanguage(language);

        return evaluator.evaluate(code);
    }

}
