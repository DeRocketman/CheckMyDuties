package domain;

public class DutyDescription {
    private String startTime;
    private String endTime;
    private String duration;
    private String fromGeo;
    private String toGeo;
    private String kindElement;
    private String trainNumber;
    private String vehicle;
    private String circulationNumber;
    private String km;
    private String trainLine;
    private String Notice;

    public DutyDescription(String startTime, String endTime, String duration, String fromGeo, String toGeo,
                           String kindElement, String trainNumber, String vehicle, String circulationNumber,
                           String km, String trainLine, String notice) {

        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.fromGeo = fromGeo;
        this.toGeo = toGeo;
        this.kindElement = kindElement;
        this.trainNumber = trainNumber;
        this.vehicle = vehicle;
        this.circulationNumber = circulationNumber;
        this.km = km;
        this.trainLine = trainLine;
        Notice = notice;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFromGeo() {
        return fromGeo;
    }

    public void setFromGeo(String fromGeo) {
        this.fromGeo = fromGeo;
    }

    public String getToGeo() {
        return toGeo;
    }

    public void setToGeo(String toGeo) {
        this.toGeo = toGeo;
    }

    public String getKindElement() {
        return kindElement;
    }

    public void setKindElement(String kindElement) {
        this.kindElement = kindElement;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getCirculationNumber() {
        return circulationNumber;
    }

    public void setCirculationNumber(String circulationNumber) {
        this.circulationNumber = circulationNumber;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getTrainLine() {
        return trainLine;
    }

    public void setTrainLine(String trainLine) {
        this.trainLine = trainLine;
    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String notice) {
        Notice = notice;
    }

    @Override
    public String toString() {
        return "DutyDescription{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", duration='" + duration + '\'' +
                ", fromGeo='" + fromGeo + '\'' +
                ", toGeo='" + toGeo + '\'' +
                ", kindElement='" + kindElement + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", circulationNumber='" + circulationNumber + '\'' +
                ", km='" + km + '\'' +
                ", trainLine='" + trainLine + '\'' +
                ", Notice='" + Notice + '\'' +
                '}';
    }
}
