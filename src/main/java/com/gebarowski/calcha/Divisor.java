package com.gebarowski.calcha;

/**
 * Created by Michał Gębarowski on 06/04/2018
 */
public class Divisor {

    private Divisor() {
    }

    public static int findGreatestCommonDivisor(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return findGreatestCommonDivisor(number2, number1 % number2);
    }
}