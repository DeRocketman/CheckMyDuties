package service;

import aggregate.DutyPlan;
import domain.Duty;
import domain.DutyDescription;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class CsvLoader {
   String filePath;
   String delimiter = ";";

    public CsvLoader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<CsvRow> readFile() {
        ArrayList<CsvRow> csvRows = new ArrayList<>();
        String currentLine;
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.filePath));
            while ((currentLine = br.readLine()) != null) {
                String[] line = currentLine.split(delimiter);
                if (!line[0].equals("PLAN") && !line[1].equals("PERIODE VON")) {
                    csvRows.add(new CsvRow(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7],line[8],
                            line[9],line[10],line[11],line[12],line[13], line[14], line[15], line[16], line[17],
                            line[18], line[19], line[20], line[21], line[22], line[23]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvRows;
    }

    public void compareAll(Predicate<CsvRow> comparer) {
        for (CsvRow row: readFile()) {
            if (comparer.test(row)) {
                System.out.println(row.toString());
            }
        }
    }

    public DutyPlan buildDutyPlan() {
        int firstPlanIndex = 0;
        int lastPlanIndex = 1;
        int firstDutyIndex = 0;
        int lastDutyIndex = 1;

        DutyPlan dutyPlan = new DutyPlan(readFile().get(firstPlanIndex).getPeriodeFrom(),
                readFile().get(firstPlanIndex).getPeriodTill(), readFile().get(firstPlanIndex).getDayCode(),
                readFile().get(firstPlanIndex).getPlanNotice());

        for (int i = 0; i < readFile().size(); i++) {
            if (readFile().get(firstPlanIndex).getPlan().equals(readFile().get(lastPlanIndex).getPlan())) {
                if (!readFile().get(firstDutyIndex).getDuty().equals(readFile().get(lastDutyIndex).getDuty()) || readFile().size() - lastDutyIndex == 1) {
                    if (lastDutyIndex-readFile().size()==-1) {
                        System.out.println("-----------------------------------------LETZTE RUNDE----------");
                    }
                    Duty duty = new Duty(readFile().get(firstDutyIndex).getDuty(),
                            readFile().get(firstDutyIndex).getStart(), readFile().get(lastDutyIndex-1).getEnd(),
                            readFile().get(firstDutyIndex).getPayedTime(), "00:00", "00:00",
                            readFile().get(firstDutyIndex).getPeriode(), readFile().get(firstDutyIndex).getDepartment(),
                            readFile().get(firstDutyIndex).getDutyNotice());
                    for (CsvRow row: readFile().subList(firstDutyIndex, lastDutyIndex-1)) {
                        DutyDescription description = new DutyDescription(row.getStart(), row.getEnd(),
                                row.getDuration(), row.getFrom(), row.getTo(), row.getKindElement(),
                                row.getTrainNumber(), row.getVehicle(), row.getCirculation(), row.getKm(),
                                row.getLineNumber(), row.getDescriptionNotice());
                        duty.addDescriptions(description);
                    }

                    dutyPlan.addDuties(duty);
                    firstDutyIndex = lastDutyIndex;
                } else {
                    lastDutyIndex++;
                    lastPlanIndex++;
                    if (lastDutyIndex == readFile().size()) {
                        System.out.println("HUHUUUUUUUUUUUUUUUUUUUUUUU");
                    }
                }
                if (lastDutyIndex == readFile().size()) {
                    System.out.println("Ende erreicht: " + lastPlanIndex + "/" + readFile().size());
                    break;
                }
            }
        }
        return dutyPlan;
    }
}