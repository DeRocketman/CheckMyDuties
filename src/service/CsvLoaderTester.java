package service;

import java.io.FileNotFoundException;

public class CsvLoaderTester {
    public static void main(String[] args) throws FileNotFoundException {
        CsvLoader csvLoader = new CsvLoader("C:\\Users\\DirkS\\IdeaProjects\\CheckMyDuties\\src\\data\\2021_NN_Regeldienste_Sa.csv");
        csvLoader.readFile();
    }
}
