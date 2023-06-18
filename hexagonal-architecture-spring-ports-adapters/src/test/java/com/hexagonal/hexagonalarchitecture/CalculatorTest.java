package com.hexagonal.hexagonalarchitecture;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void ItShouldAddNumbers() {
        int number1 = 20;
        int number2 = 10;
        int result = calculator.add(number1,number2);
        assertThat(result).isEqualTo(30);
    }

    public class Calculator {
        public int add(int number1, int number2){
            return number1 + number2;
        }
    }
}
