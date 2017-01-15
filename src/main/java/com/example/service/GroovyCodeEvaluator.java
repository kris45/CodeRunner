package com.example.service;

import groovy.lang.GroovyShell;
import org.springframework.stereotype.Component;

@Component
public class GroovyCodeEvaluator implements AbstractEvaluator {

    private static final GroovyShell SHELL = new GroovyShell();

    @Override
    public String evaluate(String code) {
        try {
            Object evaluate = SHELL.evaluate(code);
            return String.valueOf(evaluate);
        } catch (Exception e) {
            return String.format("Error evaluating script : [%s]", e.getMessage());
        }
    }
}
