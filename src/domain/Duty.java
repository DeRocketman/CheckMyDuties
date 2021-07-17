package domain;

import java.util.ArrayList;

/**
 * The Dutyclass create Duty Objects
 */
public class Duty {
    private String dutyNumber;
    private String start;
    private String end;
    private String payedTime;
    private String breakTime;
    private String duration;
    private String periode;
    private String notice;
    private String department;

    ArrayList <DutyDescription> descriptions;

    public Duty(String dutyNumber, String start, String end, String payedTime, String breakTime, String duration,
                String periode, String department, String notice) {
        this.dutyNumber = dutyNumber;
        this.start = start;
        this.end = end;
        this.payedTime = payedTime;
        this.breakTime = breakTime;
        this.duration = duration;
        this.periode = periode;
        this.department = department;
        this.notice = notice;

        this.descriptions = new ArrayList<>();
    }

    public String getDutyNumber() {
        return dutyNumber;
    }

    public void setDutyNumber(String dutyNumber) {
        this.dutyNumber = dutyNumber;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getPayedTime() {
        return payedTime;
    }

    public void setPayedTime(String payedTime) {
        this.payedTime = payedTime;
    }

    public String getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(String breakTime) {
        this.breakTime = breakTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public ArrayList<DutyDescription> getDescriptions() {
        return descriptions;
    }

    public void addDescriptions(DutyDescription description) {
        this.descriptions.add(description);
    }

    @Override
    public String toString() {
        return "Duty{" +
                "dutyNumber='" + dutyNumber + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", payedTime='" + payedTime + '\'' +
                ", breakTime='" + breakTime + '\'' +
                ", duration='" + duration + '\'' +
                ", periode='" + periode + '\'' +
                ", notice='" + notice + '\'' +
                ", department='" + department + '\'' +
                ", descriptions=" + descriptions +
                '}';
    }
}
