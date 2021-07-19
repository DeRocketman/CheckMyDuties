package service;

import domain.DutyPlan;

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

    public ArrayList<DutyPlan> compareStartorEnd(){
        int counterOuter = 0;
        int counter = 0;
        ArrayList<DutyPlan> solutionList = new ArrayList<>();
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

                       }
                    }
                }
            }
        }
        return solutionList;
    }
}
