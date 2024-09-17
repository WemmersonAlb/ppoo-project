package Observer;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    List<Observer> observadores = new ArrayList<>();

    default void addObserver(Observer observer) {
        observadores.add(observer);
    }

    default void removeObserver(Observer observer) {
        observadores.remove(observer);
    }

    default void notifyObservers() {
        for (Observer o : observadores) {
            o.update();
        }
    }
}
