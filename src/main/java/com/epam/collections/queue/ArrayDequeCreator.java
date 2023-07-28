package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        forthTwice(firstQueue, deque);
        forthTwice(secondQueue, deque);
        while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
            reverse(deque, firstQueue);
            forthTwice(firstQueue, deque);
            reverse(deque, secondQueue);
            forthTwice(secondQueue, deque);
        }

        return deque;
    }

    private <T> void forthTwice(Queue<T> source, ArrayDeque<T> destination) {
        forth(source, destination);
        forth(source, destination);
    }

    private <T> void forth(Queue<T> source, Queue<T> destination) {
        T polled = source.poll();
        if (polled != null) {
            destination.add(polled);
        }
    }

    private <T> void reverse(Deque<T> source, Queue<T> destination) {
        T polled = source.pollLast();
        if (polled != null) {
            destination.add(polled);
        }
    }
}
