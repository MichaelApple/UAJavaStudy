package task5.model.entity.bouquet;

import task5.model.entity.accessories.Basket;
import task5.model.entity.accessories.Tape;
import task5.model.entity.accessories.Wrapper;
import task5.model.entity.plants.Flower;

import java.util.List;

/**
 * Created by Miha on 26.07.2017.
 */
public class Bouquet {

    public enum Price {
        CHEAP, BUDGETARY, COSTLY, VIP
    }

    public enum Size {
        SMALL, MEDIUM, BIG, EXTRA_BIG
    }

    public enum Freshness {
        FRESH, NORMAL, NOT_FRESH, DEAD
    }

    public enum Purpose {
        A11, HOLIDAY_BOUQUET, FUNERAL_BOUQUET, WEDDING_BOUQUET
    }

    public enum Stalk {
        NO_STALK, SHORT, MEDIUM, LONG
    }

    private List<Flower> flowerList;
    private Basket basket;
    private Tape tape;
    private Wrapper wrapper;

    public Bouquet(List<Flower> flowerList, Basket basket, Tape tape, Wrapper wrapper) {
        this.flowerList = flowerList;
        this.basket = basket;
        this.tape = tape;
        this.wrapper = wrapper;
    }

    public List<Flower> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(List<Flower> flowerList) {
        this.flowerList = flowerList;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Tape getTape() {
        return tape;
    }

    public void setTape(Tape tape) {
        this.tape = tape;
    }

    public Wrapper getWrapper() {
        return wrapper;
    }

    public void setWrapper(Wrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "flowerList=" + flowerList +
                ", basket=" + basket +
                ", tape=" + tape +
                ", wrapper=" + wrapper +
                '}';
    }
}
