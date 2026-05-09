package com.narxoz.rpg.memento;

import com.narxoz.rpg.combatant.HeroMemento;
import java.util.Stack;

public class Caretaker {
    private final Stack<HeroMemento> history = new Stack<>(); 
    public void save(HeroMemento memento) {
        if (memento != null) {
            history.push(memento);
            System.out.println("  [Хранитель] Сохранен снимок героя #" + history.size());
        }
    }
    public HeroMemento undo() {
        if (history.isEmpty()) {
            System.out.println("  [Хранитель] Нет снимков для отката!");
            return null;
        }
        HeroMemento memento = history.pop();
        System.out.println("  [Хранитель] Восстановлен снимок, осталось " + history.size());
        return memento;
    }
    public HeroMemento peek() {
        if (history.isEmpty()) return null;
        return history.peek();
    }
    public int size() {
        return history.size();
    }
}