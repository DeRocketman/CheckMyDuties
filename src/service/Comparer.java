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
        int counter = 0;
        ArrayList<DutyPlan> solutionList = new ArrayList<>();
        for (int i = 0; i < this.newDuties.size(); i++) {
            for (int j = 0; j < this.regularDuties.size(); j++) {
                for (int k = 0; k < this.newDuties.get(i).getDuties().size(); k++) {
                    for (int l = 0; l < this.newDuties.get(j).getDuties().size(); l++) {
                        for (int m = 0; m < this.regularDuties.get(k).getDuties().size(); m++) {
                            System.out.println("Counter: " + counter);
                            counter++;
                        }
                    }
                }
            }
        }
        return solutionList;
    }
}
