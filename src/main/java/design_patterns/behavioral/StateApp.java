package design_patterns.behavioral;

/**
 * Created by Miha on 08.08.2017.
 */
public class StateApp {
    public static void main(String[] args) {
        Station radio24 = new Radio24();
        Radio radio = new Radio();
        radio.setStation(radio24);

        for (int i = 0; i < 10; i++) {
            radio.play();
            radio.nextStation();
        }

        Human human = new Human();
        human.setState(new Work());
        for (int i = 0; i < 10; i++) {
            human.doSomething();
        }
    }
}
//Context
class Human {
    private Activity state;

    public void setState(Activity state) {
        this.state = state;
    }

    public void doSomething() {
        state.doSomething(this);
    }
}

interface Activity {
    void doSomething(Human context);
}
class Work implements Activity {

    @Override
    public void doSomething(Human context) {
        System.out.println("DO WORK!!");
        context.setState(new WeekEnd());
    }
}
class WeekEnd implements Activity {
    private int count;
    @Override
    public void doSomething(Human context) {
        if (count < 3){
            System.out.println("Rest...");
            count++;
        } else context.setState(new Work());
    }
}

//State
interface Station {
    void play();
}

class Radio24 implements Station {
    @Override
    public void play() {
        System.out.println("Radio 24");
    }
}

class RadioWestPolus implements Station {
    @Override
    public void play() {
        System.out.println("West Polus");
    }
}

class Radio {
    Station station;

    public void setStation(Station station) {
        this.station = station;
    }

    void nextStation() {
        if (station instanceof Radio24) {
            setStation(new RadioWestPolus());
        } else setStation(new Radio24());
    }

    void play() {
        station.play();
    }
}