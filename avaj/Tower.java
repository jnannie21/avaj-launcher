package avaj;

import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Tower {
    private CopyOnWriteArrayList<Flyable> observers = new CopyOnWriteArrayList<>();
//    private ArrayList<Flyable> unregistered = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
        Logger.getLogger().log("Tower says: " + flyable.getInfo() + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        Logger.getLogger().log("Tower says: " + flyable.getInfo() + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        for (Flyable observer : observers) {
            observer.updateConditions();
        }
    }
}
