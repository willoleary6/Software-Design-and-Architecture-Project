package memento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.controller.RegisterFrameController;

public class CareTakerTest {
    private CareTaker careTaker;

    @BeforeEach
    void setUp() {
        careTaker = new CareTaker();
    }

    @Test
    void returnsNullIfStackIsEmpty() {
        Memento m = careTaker.getLastMemento();
        assert(m == null);
    }

    @Test
    void returnsMostRecentMementoFromStack() {
        Memento m = new Memento() {};
        careTaker.add(m);
        Memento m1 = careTaker.getLastMemento();

        assert(m == m1);
    }
}
