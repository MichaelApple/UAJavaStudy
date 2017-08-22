package HumanService.dao;

import HumanService.model.DriverCategories;

import java.util.*;

/**
 * Created by Miha on 18.08.2017.
 */
public class HumanDataFromDAO {
    private Map<String, List<DriverCategories>> db;

    public HumanDataFromDAO() {
        this.db = new HashMap<>();
    }

    public void addDriver(String name, List<DriverCategories> categories) {
        db.put(name, categories);
    }

    public List<DriverCategories> findByName(String name) {
        return db.containsKey(name) ? db.get(name) : new ArrayList<>();
    }

}
