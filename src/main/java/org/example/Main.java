package org.example;

import org.example.homework.candy.Candy;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Candy candy = new Candy();
        System.out.println(candy.calculateCandies(new ArrayList<>(Arrays.asList(1,0,2))));
        System.out.println(candy.calculateCandies(new ArrayList<>(Arrays.asList(1,2,2))));
    }
}
