package aggregate;

import domain.DutyPlan;
import service.CsvLoader;

import java.text.ParseException;
import java.util.ArrayList;

public class RegularDuties {
    private String filePath;
    private String planCollectionName = "Regeldienste";
    private ArrayList<DutyPlan> regularDutyPlans;

    public RegularDuties(String filePath) throws ParseException {
        this.filePath = filePath;
        CsvLoader loader = new CsvLoader(this.filePath);
        this.regularDutyPlans = loader.buildDutyPlan();
    }

    public String getFilePath() {
        return filePath;
    }

    public String getPlanCollectionName() {
        return planCollectionName;
    }

    public ArrayList<DutyPlan> getRegularDutyPlans() {
        return regularDutyPlans;
    }
}
