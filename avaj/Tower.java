package avaj;

import java.util.ArrayList;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
        Logger.getLogger().log("Tower says: Flyable registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        Logger.getLogger().log("Tower says: Flyable unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        for (Flyable observer : observers) {
            observer.updateConditions();
        }
    }
}
