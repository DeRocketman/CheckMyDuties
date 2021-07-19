package service;

import domain.DutyPlan;
import domain.Duty;
import domain.DutyDescription;

import java.io.FileNotFoundException;

public class CsvLoaderTester {
    public static void main(String[] args) throws FileNotFoundException {
        CsvLoader csvLoader = new CsvLoader("C:\\Users\\DirkS\\IdeaProjects\\CheckMyDuties\\src\\data\\2021_NN_Regeldienste_Sa.csv");
        //CsvLoader csvLoader = new CsvLoader("/var/home/rocketman/IdeaProjects/CheckMyDuties/src/data/2021_NN_Regeldienste_Sa.csv");
        CsvLoader csvLoader1 = new CsvLoader("C:\\Users\\DirkS\\IdeaProjects\\CheckMyDuties\\src\\data\\2021_NN_Regeldienste_Sa.csv");
        Comparer comparer = new Comparer(csvLoader.buildDutyPlan(), csvLoader1.buildDutyPlan());
        comparer.compareStartorEnd();
    }
}
