package patterns_tasks;

/**
 * Created by Miha on 10.08.2017.
 */
public class ComputerDesign {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copy();
    }
}
class Computer {
    Power power = new Power();
    DVDRom dvdRom = new DVDRom();
    Hdd hdd = new Hdd();
    void copy(){
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
    }
}

class Power {
    void on() {
        System.out.println("Power on");
    }
    void off() {
        System.out.println("Power off");
    }
}

class DVDRom {
    private boolean data = false;
    public boolean hasData() {
        return data;
    }

    public void load() {
        data = true;
    }
    public void unload() {
        data = false;
    }
}

class Hdd {
    void copyFromDVD(DVDRom dvdRom) {
        if (dvdRom.hasData())
            System.out.println("Copy from dvd");
        else System.out.println("Input dvd");
    }
}