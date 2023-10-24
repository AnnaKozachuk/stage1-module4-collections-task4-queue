package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> deck = new ArrayDeque<>();
        for (int i = 0; i < 2; i++) {
            deck.add(Objects.requireNonNull(firstQueue.poll()));
        }
        for (int i = 0; i < 2; i++) {
            deck.add(Objects.requireNonNull(secondQueue.poll()));
        }

        while (!firstQueue.isEmpty() && !secondQueue.isEmpty())
        {
            firstQueue.add(deck.pollLast());
            for (int i = 0; i < 2; i++) {
                deck.addLast(Objects.requireNonNull(firstQueue.poll()));
            }
            secondQueue.add(deck.pollLast());
            for (int i = 0; i < 2; i++) {
                deck.addLast(Objects.requireNonNull(secondQueue.poll()));
            }
        }

        return deck;
    }
}
