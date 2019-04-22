package memento;

import java.util.Stack;

public class CareTaker {
    private Stack<Memento> mementoStack = new Stack<>();

    public void add(Memento m) {
        mementoStack.push(m);
    }

    public Memento getLastMemento() {
        if(mementoStack.isEmpty())
            return null;

        return mementoStack.pop();
    }
}