package design_patterns.behavioral;

/**
 * Created by Miha on 08.08.2017.
 */
public class MementoGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.set("1 LEVEL", 300000);
        System.out.println(game);

        File file = new File();
        file.setSave(game.save());

        game.set("2 LEVEL", 550000);
        System.out.println(game);

        System.out.println("Loading...");
        game.load(file.getSave());
        System.out.println(game);
    }
}

class Game {
    private String level;
    private int ms;
    public void set(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    public void load(Save save) {
        level = save.getLevel();
        ms = save.getMs();
    }
    public Save save() {
        return new Save(level, ms);
    }

    @Override
    public String toString() {
        return "Game{" +
                "level='" + level + '\'' +
                ", ms=" + ms +
                '}';
    }
}

class Save {
    private final String level;
    private final int ms;

    public Save(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }
    public String getLevel() {
        return level;
    }
    public int getMs() {
        return ms;
    }
}

class File {
    Save save;
    public Save getSave() {
        return save;
    }
    public void setSave(Save save) {
        this.save = save;
    }
}
