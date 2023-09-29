package ru.otus.task;

import ru.otus.task.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> list = new ArrayList<>();

    public void add(T elem) {
        list.add(elem);
    }

    public double weight() {
        return list.stream().mapToDouble(Fruit::getWeight).sum();
    }

    public void moveToAnotherBox(Box<? super T> box) {
        box.list.addAll(list);
        list.clear();
    }

    public boolean compare(Box<? extends Fruit> anotherBox) {
        if (anotherBox == null) return false;
        return Math.abs(weight() - anotherBox.weight()) < 0.000001;
    }

}
