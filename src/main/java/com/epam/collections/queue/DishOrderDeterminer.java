package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        LinkedList<Integer> dishes = new LinkedList<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            dishes.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (!dishes.isEmpty()) {
            int skip = everyDishNumberToEat - 1;
            for (int i = skip; i > 0; i--) {
                move(dishes, dishes);
            }
            move(dishes, list);
        }

        return list;
    }

    private <T> void move(Queue<T> source, List<T> destination) {
        T polled = source.poll();
        destination.add(polled);
    }
}
