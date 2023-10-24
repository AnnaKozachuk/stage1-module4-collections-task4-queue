package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= numberOfDishes; i++) {
            queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int dish = queue.poll();
            count++;
            if (count % everyDishNumberToEat == 0) {
                result.add(dish);
            } else {
                queue.offer(dish);
            }
        }
        return result;
    }
}
