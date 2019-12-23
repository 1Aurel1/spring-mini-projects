package com.example.demotest.classesForJunit;

public class Calculator {

    CalculatorService service;

    public Calculator(CalculatorService service) {
        this.service = service;
    }

    public int calculate(int i, int j){
        return (service.add(i,j) * i);
    }

}