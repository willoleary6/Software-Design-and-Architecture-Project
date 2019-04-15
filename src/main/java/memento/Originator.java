package memento;

public interface Originator {
    void restore(Memento m);
    Memento createMemento();
}
