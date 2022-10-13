package org.example.homework.candy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/candy/
public class Candy {
    public Integer calculateCandies(ArrayList<Integer> list)
    {
        List<Integer> candiesList = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            candiesList.add(1);
        }

        int howManyCandies = 0;
        boolean finish = false;

        while (!finish)
        {
            finish=true;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i) > list.get(i+1)) {
                    if (candiesList.get(i) <= candiesList.get(i+1)) {
                        candiesList.set(i,1+candiesList.get(i));
                        finish=false;
                        howManyCandies++;
                    }
                } else if (list.get(i) < list.get(i+1)) {
                    if (candiesList.get(i) >= candiesList.get(i+1)) {
                        candiesList.set(i+1,1+candiesList.get(i+1));
                        finish=false;
                        howManyCandies++;
                    }
                }
            }
        }
        return howManyCandies+list.size();
    }
}
