package service;

import domain.DutyPlan;
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


    public ArrayList<DutyPlan> buildDutyPlan() {
        ArrayList<DutyPlan> dutyPlans = new ArrayList<>();
        int planStart = 0;
        int planEnd = 1;
        int dutyStart = 0;
        int dutyEnd = 1;
        int countPlans = 0;


        DutyPlan dp = new DutyPlan(readFile().get(planStart).getPlan(),
                readFile().get(planStart).getPeriodeFrom(), readFile().get(planStart).getPeriodTill(),
                readFile().get(planStart).getDayCode(), readFile().get(planStart).getPlanNotice());
        dutyPlans.add(dp);
        for (int i=0, j=1; j< readFile().size(); i++, j++) {
            String cp = readFile().get(i).getPlan();
            String np = readFile().get(j).getPlan();
            String cd = readFile().get(i).getDuty();
            String nd = readFile().get(j).getDuty();
            if (!cd.equals(nd) || readFile().size() - j == 1 || !cp.equals(np)) {
                if (!cp.equals(np)) {
                    DutyPlan dpNew = new DutyPlan(readFile().get(planStart).getPlan(),
                            readFile().get(planStart).getPeriodeFrom(), readFile().get(planStart).getPeriodTill(),
                            readFile().get(planStart).getDayCode(), readFile().get(planStart).getPlanNotice());
                    countPlans++;
                    dutyPlans.add(dpNew);
                    planStart = planEnd;
                }

                Duty duty = new Duty(readFile().get(dutyStart).getDuty(),
                        readFile().get(dutyStart).getStart(), readFile().get(dutyEnd).getEnd(),
                        readFile().get(dutyStart).getPayedTime(), "00:00", "00:00",
                        readFile().get(dutyStart).getPeriode(), readFile().get(dutyStart).getDepartment(),
                        readFile().get(dutyStart).getDutyNotice());
                if (readFile().size() - j == 1) {
                    dutyEnd++;
                }
                for (CsvRow row: readFile().subList(dutyStart, dutyEnd)) {
                    DutyDescription description = new DutyDescription(row.getStart(), row.getEnd(),
                            row.getDuration(), row.getFrom(), row.getTo(), row.getKindElement(),
                            row.getTrainNumber(), row.getVehicle(), row.getCirculation(), row.getKm(),
                            row.getLineNumber(), row.getDescriptionNotice());
                    duty.addDescriptions(description);
                }
                dutyPlans.get(countPlans).addDuties(duty);
                dutyStart = dutyEnd;
            }
            planEnd++;
            dutyEnd++;
        }
        return dutyPlans;
    }
}