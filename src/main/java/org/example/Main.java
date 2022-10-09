package org.example;

import org.example.homework.textjustification.TextJustification;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
        textJustification.writeText(new ArrayList<>(Arrays.asList("This","is","an","example","of","text","justification")),16);
        System.out.println("****************************");
        textJustification.writeText(new ArrayList<>(Arrays.asList("What","must","be","acknowledgment","shall","be")),16);
        System.out.println("****************************");
        textJustification.writeText(new ArrayList<>(Arrays.asList("Science","is","what","we","understand","well","enough","to",
                "explain","to","a","computer.","Art","is","everything","else","we","do")),20);
    }
}
