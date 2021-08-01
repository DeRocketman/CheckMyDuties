package service;

import domain.Duty;
import domain.DutyDescription;
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

        String [] breakTimeRegular;
        String [] breakTimeNew;
        int breakCounterRegular;
        int breakCounterNew;

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
                           breakTimeRegular = new String[6];
                           breakTimeNew = new String[6];
                           breakCounterRegular = 0;
                           breakCounterNew = 0;
                           for (DutyDescription description: regularDuty.getDuties().get(l).getDescriptions()) {
                               if (description.getKindElement().equals("Pause")) {
                                   breakTimeRegular[breakCounterRegular] = description.getStartTime();
                                   breakCounterRegular++;
                                   breakTimeRegular[breakCounterRegular] = description.getEndTime();
                                   breakCounterRegular++;
                               }
                           }
                           for (DutyDescription description: newDuty.getDuties().get(k).getDescriptions()) {
                                if (description.getKindElement().equals("Pause")) {
                                    breakTimeNew[breakCounterNew] = description.getStartTime();
                                    breakCounterNew++;
                                    breakTimeNew[breakCounterNew] = description.getEndTime();
                                    breakCounterNew++;
                                }
                           }
                           for (int x = 0; x <= breakCounterNew; x++) {
                               if(breakTimeNew[x] != null && !breakTimeNew[x].equals(breakTimeRegular[x])) {
                                   newDuty.getDuties().get(k).setSolutionBreakTime("Pausenlage geändert");
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
                System.out.println(duty.toString());
            }
        }
    }
}
