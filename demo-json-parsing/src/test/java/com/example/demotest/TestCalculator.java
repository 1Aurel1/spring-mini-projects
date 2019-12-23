package com.example.demotest;


import com.example.demotest.classesForJunit.Calculator;
import com.example.demotest.classesForJunit.CalculatorService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestCalculator {

    private Calculator c = null;
    private CalculatorService service = mock(CalculatorService.class);

    @Before
    public void setUp(){
        c = new Calculator(service);
    }

    @Test
    public void testCalculate(){
        when(service.add(2,3)).thenReturn(5);
        assertEquals(10, c.calculate(2, 3));
        verify(service).add(2,3);
    }

}
