package com.healthycoderapp;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    // mały wzrost, duża waga, powinien przejść na dietę - TRUE
    @Test
    void should_ReturnTrue_When_DietRecommended() {

        // given
        double weight = 90.0;
        double height = 1.60;

        // when
        boolean result = BMICalculator.isDietRecommended(weight, height);

        // then
        assertTrue(result);
    }


    // wysoki wzrost, mała waga, nie powinien przejść na dietę - FALSE
    @Test
    void should_ReturnFalse_When_DietNotRecommended() {

        // given
        double weight = 50.0;
        double height = 1.80;

        // when
        boolean result = BMICalculator.isDietRecommended(weight, height);

        // then
        assertFalse(result);
    }


    // exeption (dzielenie przez zero)
    @Test
    void should_ThrowArithmeticException_When_HeightZero() {

        // given
        double weight = 65;
        double height = 0.0;

        // when
        // wyrażenie lambda
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        // then
        assertThrows(ArithmeticException.class, executable);

    }

}