package org.example.homework.textjustification;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/text-justification/
public class TextJustification {
    public void writeText(ArrayList<String> list, int maxWidth) {
    boolean finish = false;
    boolean finishLine = false;
    boolean lastPrint = false;
    int i=0;
    String nextWord;
    int numberOfPlacesInLine;
    while (!finish) {
        List<String> currentLine = new ArrayList<>();
        numberOfPlacesInLine = maxWidth;
        finishLine = false;
        while (!finishLine) {
            // OSTATNI WYRAZ W LISCIE
            if (i==list.size()-1) {
                numberOfPlacesInLine = 0;
                currentLine.add(list.get(i));
                finish = true;
                lastPrint = true;
            }
            nextWord = list.get(i);
            i++;
            if (nextWord.length() <= numberOfPlacesInLine) {
                currentLine.add(nextWord);
                numberOfPlacesInLine=(numberOfPlacesInLine-nextWord.length())-1;
            } else {
                finishLine = true;
                i--;
                if (lastPrint) writeLastLine(currentLine,maxWidth);
                else writeLine(currentLine,maxWidth);
            }
        }
    }
    }

    private void writeLine(List<String> currentLine, int maxWidth) {
        switch (currentLine.size()) {
            case 1:
                System.out.print(currentLine.get(0));
                break;
            case 2:
                int numberOfLetters = 0;
                for (String word : currentLine) {
                    numberOfLetters += word.length();
                }
                System.out.print(currentLine.get(0));
                for (int i=0; i<maxWidth-numberOfLetters; i++) System.out.print(" ");
                System.out.print(currentLine.get(1));
                break;
            default:
                int numberOfLetters2 = 0;
                for (String word : currentLine) {
                    numberOfLetters2 += word.length();
                }
                int freeSpace = maxWidth - numberOfLetters2;
                int singleSpace = freeSpace / (currentLine.size()-1);
                int bonusSpace = freeSpace % (currentLine.size()-1);

                System.out.print(currentLine.get(0));
                for (int i=1; i<currentLine.size(); i++) {
                    for (int j = 0; j < singleSpace; j++) {
                        System.out.print(" ");
                    }
                    if (bonusSpace!=0) {
                        System.out.print(" ");
                        bonusSpace--;
                    }
                    System.out.print(currentLine.get(i));
                }
                break;
        }
        System.out.println();

    }


    private void writeLastLine(List<String> currentLine, int maxWidth) {
        int space = 0;
        int i = 0;
        int numberOfLetters = 0;
        for (String word : currentLine) {
            numberOfLetters += word.length();
        }
        if (numberOfLetters+currentLine.size()>maxWidth) // no 100 sure
        {
            List<String> stringList = new ArrayList<>();
            while (space + currentLine.get(i).length() <= maxWidth) {
                stringList.add(currentLine.get(i));
                space += currentLine.get(i).length() + 1;
                i++;
            }
            writeLine(stringList,maxWidth);
        }

        while (i < currentLine.size()) {
            System.out.print(currentLine.get(i));
            System.out.print(" ");
            i++;
        }
        System.out.println();
    }
}
