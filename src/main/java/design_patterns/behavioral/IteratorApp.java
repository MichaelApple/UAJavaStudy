package design_patterns.behavioral;

/**
 * Created by Miha on 05.08.2017.
 */
public class IteratorApp {
    public static void main(String[] args) {
        ConcreteAggregate c = new ConcreteAggregate();

        Iterator iterator = c.getIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Aggregate {
    Iterator getIterator();
}

class ConcreteAggregate implements Aggregate{
    String[] tasks = {"Miha", "Solomiya"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < tasks.length;
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}
