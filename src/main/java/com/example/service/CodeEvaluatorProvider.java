package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CodeEvaluatorProvider {

    @Autowired
    private GroovyCodeEvaluator groovyCodeEvaluator;

    private Map<String, AbstractEvaluator> evaluatorsMap;

    public AbstractEvaluator getByLanguage(String language) {
        AbstractEvaluator abstractEvaluator = evaluatorsMap.get(language);

        if (abstractEvaluator == null) {
            throw new IllegalArgumentException(String.format("No evaluator found for language [%s]", language));
        }

        return abstractEvaluator;
    }

    @PostConstruct
    public void postConstruct() {
        Map<String, AbstractEvaluator> map = new LinkedHashMap<>();
        map.put("groovy", groovyCodeEvaluator);

        evaluatorsMap = Collections.unmodifiableMap(map);
    }

}
