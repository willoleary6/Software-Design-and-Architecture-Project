package memento;

public interface CareTaker {
    void add(Memento m);
    Memento getLastMemento();
}