package service;

import domain.DutyPlan;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
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

    public ArrayList<String[]> compareStartorEnd() throws ParseException {
        //todo: String mit ergebnis zusammen bauen (44 und 47)
        //todo: String mit Pausenlage erweitern d.h. Methode dazu bauen!

        int counterOuter = 0;
        int counter = 0;
        ArrayList<String[]> solutionList = new ArrayList<>();
        for (DutyPlan newDuty : this.newDuties) {
            for (DutyPlan regularDuty : this.regularDuties) {
                for (int k = 0; k < newDuty.getDuties().size(); k++) {
                    for (int l = 0; l < regularDuty.getDuties().size(); l++) {
                       if (newDuty.getDuties().get(k).getDutyNumber().equals(regularDuty.getDuties().get(l).getDutyNumber())) {
                           String solutionStart = "";
                           String solutionDS = "";
                           String solutionDE = "";
                           String solutionBreak= "";
                           if (!newDuty.getDuties().get(k).getStart().equals(regularDuty.getDuties().get(l).getStart())){
                               solutionDS = TimeCalculator.calculateDifference(regularDuty.getDuties().get(l).getStart(), newDuty.getDuties().get(k).getStart()) + " Dienstbeginn";
                           }
                           if (!newDuty.getDuties().get(k).getEnd().equals(regularDuty.getDuties().get(l).getEnd())){
                               solutionDE = TimeCalculator.calculateDifference(regularDuty.getDuties().get(l).getEnd(), newDuty.getDuties().get(k).getEnd()) + " Dienstende";
                           }
                           solutionStart = "Dienst: " + newDuty.getDuties().get(k).getDutyNumber() + " Dienstbeginn: " + newDuty.getDuties().get(k).getStart();
                           String [] solution = new String[3];
                           solution[0] = solutionStart;
                           solution[1] = solutionDS;
                           solution[2] = solutionDE;

                           System.out.println(solutionStart + " ("+ solutionDS + ")" + " Dienstende: " + newDuty.getDuties().get(k).getEnd() + " (" + solutionDE + ")");
                           solutionList.add(solution);
                       }
                    }
                }
            }
        }
        return solutionList;
    }
}
