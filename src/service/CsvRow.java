package service;

public class CsvRow {
   private String plan;
   private String periodeFrom;
   private String periodTill;
   private String duty;
   private String start;
   private String end;
   private String breakTime;
   private String payedTime;
   private String duration;
   private String from;
   private String to;
   private String kindElement;
   private String trainNumber;
   private String vehicle;
   private String circulation;
   private String km;
   private String periode;
   private String dayCode;
   private String department;
   private String checkPoint;
   private String lineNumber;
   private String dutyNotice;
   private String planNotice;
   private String descriptionNotice;

    public CsvRow(String plan, String periodeFrom, String periodTill, String duty, String start, String end, String breakTime, String payedTime, String duration, String from, String to, String kindElement, String trainNumber, String vehicle, String circulation, String km, String periode, String dayCode, String department, String checkPoint, String lineNumber, String dutyNotice, String planNotice, String descriptionNotice) {
        this.plan = plan;
        this.periodeFrom = periodeFrom;
        this.periodTill = periodTill;
        this.duty = duty;
        this.start = start;
        this.end = end;
        this.breakTime = breakTime;
        this.payedTime = payedTime;
        this.duration = duration;
        this.from = from;
        this.to = to;
        this.kindElement = kindElement;
        this.trainNumber = trainNumber;
        this.vehicle = vehicle;
        this.circulation = circulation;
        this.km = km;
        this.periode = periode;
        this.dayCode = dayCode;
        this.department = department;
        this.checkPoint = checkPoint;
        this.lineNumber = lineNumber;
        this.dutyNotice = dutyNotice;
        this.planNotice = planNotice;
        this.descriptionNotice = descriptionNotice;
    }

    public String getPlan() {
        return plan;
    }

    public String getPeriodeFrom() {
        return periodeFrom;
    }

    public String getPeriodTill() {
        return periodTill;
    }

    public String getDuty() {
        return duty;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getBreakTime() {
        return breakTime;
    }

    public String getPayedTime() {
        return payedTime;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getKindElement() {
        return kindElement;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getCirculation() {
        return circulation;
    }

    public String getKm() {
        return km;
    }

    public String getPeriode() {
        return periode;
    }

    public String getDayCode() {
        return dayCode;
    }

    public String getDepartment() {
        return department;
    }

    public String getCheckPoint() {
        return checkPoint;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public String getDutyNotice() {
        return dutyNotice;
    }

    public String getPlanNotice() {
        return planNotice;
    }

    public String getDescriptionNotice() {
        return descriptionNotice;
    }

    @Override
    public String toString() {
        return "CsvRow{" +
                "plan='" + plan + '\'' +
                ", periodeFrom='" + periodeFrom + '\'' +
                ", periodTill='" + periodTill + '\'' +
                ", duty='" + duty + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", breakTime='" + breakTime + '\'' +
                ", payedTime='" + payedTime + '\'' +
                ", duration='" + duration + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", kindElement='" + kindElement + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", circulation='" + circulation + '\'' +
                ", km='" + km + '\'' +
                ", periode='" + periode + '\'' +
                ", dayCode='" + dayCode + '\'' +
                ", department='" + department + '\'' +
                ", checkPoint='" + checkPoint + '\'' +
                ", lineNumber='" + lineNumber + '\'' +
                ", dutyNotice='" + dutyNotice + '\'' +
                ", planNotice='" + planNotice + '\'' +
                ", descriptionNotice='" + descriptionNotice + '\'' +
                '}';
    }
}
