package de.rocketman.service;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class CsvLoaderTester {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        //CsvLoader csvLoader = new CsvLoader("C:\\Users\\DirkS\\IdeaProjects\\CheckMyDuties\\src\\data\\2021_NN_Regeldienste_Sa.csv");
        //CsvLoader csvLoader1 = new CsvLoader("C:\\Users\\DirkS\\IdeaProjects\\CheckMyDuties\\src\\data\\2021_NN_Regeldienste_Sa.csv");
        CsvLoader csvLoader = new CsvLoader("/home/rocketman/IdeaProjects/CheckMyDuties/src/de/rocketman/data/2021_NN_Regeldienste_Sa.csv");
        //CsvLoader csvLoader1 = new CsvLoader("/var/home/rocketman/IdeaProjects/CheckMyDuties/src/data/2021_NN_Regeldienste_Sa.csv");
        CsvLoader csvLoader1 = new CsvLoader("/home/rocketman/IdeaProjects/CheckMyDuties/src/de/rocketman/data/BaustelleXYZ.csv");
        Comparer comparer = new Comparer(csvLoader.buildDutyPlan(), csvLoader1.buildDutyPlan());
        comparer.compareStartEnd();

    }
}
