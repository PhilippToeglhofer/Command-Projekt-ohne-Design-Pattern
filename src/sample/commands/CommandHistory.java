package sample.commands;

import java.util.Stack;

public class CommandHistory {
    private Stack<Commands> history = new Stack<>();

    public void push(Commands c) {
        history.push(c);
    }

    public Commands pop() {
        return history.pop();
    }

    public boolean isEmpty() { return history.isEmpty(); }
}