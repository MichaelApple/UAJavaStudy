package patterns_tasks;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Miha on 10.08.2017.
 */
public class HumanStates {
    public static void main(String[] args) {
        Human human = new Human();
        human.setState(new OnRiverBank());
        human.doSomething();
        human.setState(new SeeAnimal(), new OnMushroomGlade());
        human.doSomething();
    }
}

interface Activity {
    State updateState();
}
class SeeAnimal implements Activity{
    @Override
    public State updateState() {
        return new Hunter();
    }
}
class OnRiverBank implements Activity{
    @Override
    public State updateState() {
        return new Fisher();
    }
}
class OnMushroomGlade implements Activity{
    @Override
    public State updateState() {
        return new MushroomPicker();
    }
}

//State
interface State {
    void doSomething();
}
class Hunter implements State {
    @Override
    public void doSomething() {
        System.out.println("Sees an animal");
    }
}
class Fisher implements State {
    @Override
    public void doSomething() {
        System.out.println("On the river bank");
    }
}
class MushroomPicker implements State {
    @Override
    public void doSomething() {
        System.out.println("On mushroom glade");
    }
}

class Human {
    private Activity activity;
    private Activity[] activities;
    private Set<State> states = new HashSet<>();

    public void setState(Activity activity) {
        this.activity = activity;
        this.states.add(this.activity.updateState());
    }
    public void setState(Activity ... activity) {
        this.activities = activity;
        for (Activity a : activities)
            states.add(a.updateState());
    }

    public void doSomething() {
        if (states != null) {
            for (State s : states)
                s.doSomething();
        }
    }
}
