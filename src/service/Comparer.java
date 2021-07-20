package service;

import domain.DutyPlan;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Comparer {
    private ArrayList<DutyPlan> regularDuties;
    private ArrayList<DutyPlan> newDuties;

    public Comparer(ArrayList<DutyPlan> regularDuties, ArrayList<DutyPlan> newDuties) {
        this.regularDuties = regularDuties;
        this.newDuties = newDuties;
    }

    public ArrayList<DutyPlan> compareAll(Predicate<DutyPlan> comparer) {
        ArrayList<DutyPlan> solutionList = new ArrayList<>();
        for (DutyPlan planer: regularDuties) {
            if (comparer.test(planer)) {
                System.out.println(planer.toString());
            }
        }
        return solutionList;
    }

    public ArrayList<String> compareStartorEnd() throws ParseException {
        //todo: String mit ergebnis zusammen bauen (44 und 47)
        //todo: String mit Pausenlage erweitern d.h. Methode dazu bauen!
        int counterOuter = 0;
        int counter = 0;
        ArrayList<String> solutionList = new ArrayList<>();
        for (DutyPlan newDuty : this.newDuties) {
            for (DutyPlan regularDuty : this.regularDuties) {
                for (int k = 0; k < newDuty.getDuties().size(); k++) {
                    for (int l = 0; l < regularDuty.getDuties().size(); l++) {
                       if (newDuty.getDuties().get(k).getDutyNumber().equals(regularDuty.getDuties().get(l).getDutyNumber())) {
                           System.out.println("Duty: " + newDuty.getDuties().get(k).getDutyNumber());
                           System.out.println("Dauer Neu: " + newDuty.getDuties().get(k).getDuration() + " Dauer Regel: " + regularDuty.getDuties().get(l).getDuration());
                           System.out.println("Beginn Neu: " + newDuty.getDuties().get(k).getStart() + " Beginn Regel: " + regularDuty.getDuties().get(l).getStart());
                           System.out.println("Ende Neu: " + newDuty.getDuties().get(k).getEnd() + " Ende Regel: " + regularDuty.getDuties().get(l).getEnd());
                           System.out.println("Pause Neu: " + newDuty.getDuties().get(k).getBreakTime() + " Pause Regel: " + regularDuty.getDuties().get(l).getBreakTime());
                           if (!newDuty.getDuties().get(k).getStart().equals(regularDuty.getDuties().get(l).getStart())){
                               String solution ="Dienst: "+ newDuty.getDuties().get(k).getDutyNumber()+ " DB: " + newDuty.getDuties().get(k).getStart() + TimeCalculator.calculateDuration(regularDuty.getDuties().get(l).getStart(), newDuty.getDuties().get(k).getStart()) + " Dienstbeginn";
                           }
                           if (!newDuty.getDuties().get(k).getEnd().equals(regularDuty.getDuties().get(l).getEnd())){
                               String solution = TimeCalculator.calculateDuration(regularDuty.getDuties().get(l).getEnd(), newDuty.getDuties().get(k).getEnd()) + " Dienstende";
                           }
                       }
                    }
                }
            }
        }
        return solutionList;
    }
}
