package service;

import aggregate.DutyPlan;
import domain.Duty;
import domain.DutyDescription;

import java.io.FileNotFoundException;

public class CsvLoaderTester {
    public static void main(String[] args) throws FileNotFoundException {
        //CsvLoader csvLoader = new CsvLoader("C:\\Users\\DirkS\\IdeaProjects\\CheckMyDuties\\src\\data\\2021_NN_Regeldienste_Sa.csv");
        CsvLoader csvLoader = new CsvLoader("/var/home/rocketman/IdeaProjects/CheckMyDuties/src/data/2021_NN_Regeldienste_Sa.csv");
        for (Duty duty: csvLoader.buildDutyPlan().getDuties()) {
            System.out.println(duty.toString());
            for (DutyDescription description: duty.getDescriptions()
                 ) {
                System.out.println(description.toString());
            }
        }

    }
}
