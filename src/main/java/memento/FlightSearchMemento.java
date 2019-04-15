package memento;

import ui.model.FlightSearchModel;

public class FlightSearchMemento implements Memento {
    FlightSearchModel model;

    public FlightSearchMemento(FlightSearchModel model) {
        setState(model);
    }

    public FlightSearchModel getSavedState() {
        return model;
    }

    public void setState(FlightSearchModel model) {
        this.model = model;
    }
}
