package arraylistimpl;

import java.util.Iterator;

/**
 * Created by Miha on 04.08.2017.
 */
public abstract class MyAbstractList<E> implements MyList<E> {

    protected int size = 0; // The size of the list

    /**
     * Create a default list
     */
    protected MyAbstractList() {
    }

    /**
     * Create a list from an array of objects
     */
    protected MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    @Override
    public void add(E e) {
        add(size, e);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean addAll(MyList<E> otherList) {
        int lastSize = size;
        otherList.forEach(this::add);
        return lastSize != size;
    }
}
