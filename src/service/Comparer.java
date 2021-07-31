package service;

import domain.Duty;
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

    public void compareStartEnd() throws ParseException {

        //todo: String mit Pausenlage erweitern d.h. Methode dazu bauen!

        int counterOuter = 0;
        int counter = 0;
        for (DutyPlan newDuty : this.newDuties) {
            for (DutyPlan regularDuty : this.regularDuties) {
                for (int k = 0; k < newDuty.getDuties().size(); k++) {
                    for (int l = 0; l < regularDuty.getDuties().size(); l++) {
                       if (newDuty.getDuties().get(k).getDutyNumber().equals(regularDuty.getDuties().get(l).getDutyNumber())) {
                           if (!newDuty.getDuties().get(k).getStart().equals(regularDuty.getDuties().get(l).getStart())){
                               newDuty.getDuties().get(k).setSolutionDutyStart(TimeCalculator.calculateDifference(regularDuty.getDuties().get(l).getStart(), newDuty.getDuties().get(k).getStart()) + " Dienstbeginn");
                               if (newDuty.getDuties().get(k).getSolutionDutyStart().equals("00:00 früher Dienstbeginn")) {
                                   newDuty.getDuties().get(k).setSolutionDutyStart("");
                               }
                           }
                           if (!newDuty.getDuties().get(k).getEnd().equals(regularDuty.getDuties().get(l).getEnd())){
                               newDuty.getDuties().get(k).setSolutionDutyEnd(TimeCalculator.calculateDifference(regularDuty.getDuties().get(l).getEnd(), newDuty.getDuties().get(k).getEnd()) + " Dienstende");
                               if (newDuty.getDuties().get(k).getSolutionDutyEnd().equals("00:00 früher Dienstende")) {
                                   newDuty.getDuties().get(k).setSolutionDutyEnd("");
                               }
                           }
                           for (int m = 0; m < newDuty.getDuties().get(k).getDescriptions().size(); m++) {
                               for (int n = 0; n < regularDuty.getDuties().get(l).getDescriptions().size(); n++) {
                                   if (newDuty.getDuties().get(k).getDescriptions().get(m).getKindElement().equals("Pause")
                                           && regularDuty.getDuties().get(l).getDescriptions().get(n).getKindElement().equals("Pause")) {
                                       if (newDuty.getDuties().get(k).getDescriptions().get(m).getStartTime().equals(regularDuty.getDuties().get(l).getDescriptions().get(n).getStartTime())
                                               && newDuty.getDuties().get(k).getDescriptions().get(m).getEndTime().equals(regularDuty.getDuties().get(l).getDescriptions().get(n).getEndTime())) {
                                           System.out.println(newDuty.getDuties().get(k).getDescriptions().get(m).getStartTime() + " Alt: " + regularDuty.getDuties().get(l).getDescriptions().get(n).getStartTime());
                                           System.out.println("Pausenlage gleich");
                                          break;
                                       } else {
                                           System.out.println(newDuty.getDuties().get(k).getDescriptions().get(m).getStartTime() + " Alt: " + regularDuty.getDuties().get(l).getDescriptions().get(n).getStartTime());
                                           System.out.println("Pausenlage geändert");
                                           newDuty.getDuties().get(k).setSolutionBreakTime("Pausenlage geändert");
                                           break;
                                       }
                                   }
                               }
                           }
                       }
                    }
                }
            }
        }
        for (DutyPlan newDuty: this.newDuties) {
            for (Duty duty: newDuty.getDuties()
            ) {
                //System.out.println(duty.toString());
            }
        }
    }
}
