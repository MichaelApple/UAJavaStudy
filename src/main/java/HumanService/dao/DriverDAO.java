package HumanService.dao;

import HumanService.model.DriverCategories;

import java.util.List;

import static HumanService.model.DriverCategories.A;
import static HumanService.model.DriverCategories.B;
import static HumanService.model.DriverCategories.C;

/**
 * Created by Miha on 18.08.2017.
 */
public enum DriverDAO {
    SOLOMIYA(A, B, C),
    YABLON(B);


        private DriverCategories[] categories;

    DriverDAO(DriverCategories ... categories) {
        this.categories = categories;
    }

    public DriverCategories[] getCategories() {
        return categories;
    }

    public void setCategories(DriverCategories[] categories) {
        this.categories = categories;
    }


}
