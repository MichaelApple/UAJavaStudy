package design_patterns.behavioral;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miha on 05.08.2017.
 */
public class ObserverApp {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();
        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());
        station.setMeasurements(35, 762);
        station.setMeasurements(18, 750);
    }
}

interface Observed {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class MeteoStation implements Observed{
    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int t, int p) {
        temperature = t;
        pressure = p;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers){
            observer.handleEvent(temperature, pressure);
        }
    }
}

interface Observer {
    void handleEvent(int temp, int presser);
}

class ConsoleObserver implements Observer {
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("Weather changed: Temperature is " + temp + " and pressure is " + presser + ".");
    }
}

class FileObserver implements Observer {

    @Override
    public void handleEvent(int temp, int presser) {
        File f;
        try {
            f = File.createTempFile("TempPressure", "_txt");
            PrintWriter printWriter = new PrintWriter(f);
            printWriter.print("Weather changed: Temperature is " + temp + " and pressure is " + presser + ".");
            printWriter.println();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
