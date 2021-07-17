package aggregate;

import domain.Duty;

import java.util.ArrayList;

public class DutyPlan {
    private String periodeFrom;
    private String periodeTill;
    private String notice;
    private String dayCode;
    private ArrayList <Duty> duties;

    public DutyPlan(String periodeFrom, String periodeTill, String dayCode, String notice) {
        this.periodeFrom = periodeFrom;
        this.periodeTill = periodeTill;
        this.dayCode = dayCode;
        this.notice = notice;

        this.duties = new ArrayList<>();
    }

    public String getPeriodeFrom() {
        return periodeFrom;
    }

    public void setPeriodeFrom(String periodeFrom) {
        this.periodeFrom = periodeFrom;
    }

    public String getPeriodeTill() {
        return periodeTill;
    }

    public void setPeriodeTill(String periodeTill) {
        this.periodeTill = periodeTill;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDayCode() {
        return dayCode;
    }

    public void setDayCode(String dayCode) {
        this.dayCode = dayCode;
    }

    public ArrayList<Duty> getDuties() {
        return duties;
    }

    public void addDuties(Duty duty) {
        this.duties.add(duty);
    }
}
