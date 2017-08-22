package HumanService.model;

import HumanService.dao.HumanDataFromDAO;
import HumanService.entity.HumanToWorkHire;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Miha on 18.08.2017.
 */
public class DriverHire implements HumanToWorkHire {
    private String name;
    private String workStatus;
    private String companyName = "Solomiya";

    ArrayList<DriverCategories> actualDriverCategory = new ArrayList<>();
    {
        actualDriverCategory.add(DriverCategories.D);
        actualDriverCategory.add(DriverCategories.B);
    }

    private List<DriverCategories> categories = new ArrayList<>();

    @Override
    public void setNameAndStatus(String name, String status) {
        this.name = name;
        this.workStatus = status;
    }

    @Override
    public String getStatus() {
        return Optional.empty().toString();
    }

    public boolean checkDriver(String name) {
        HumanDataFromDAO humanDataFromDAO = new HumanDataFromDAO();
        return !(workStatus.isEmpty() && humanDataFromDAO.findByName(name).containsAll(actualDriverCategory));
    }
}
