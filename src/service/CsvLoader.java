package service;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.CsvRow;


public class CsvLoader {
   String filePath;
   String delimiter = ";";

    public CsvLoader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<CsvRow> readFile() {
        ArrayList<CsvRow> csvRows = new ArrayList<>();
        String currentLine;
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.filePath));
            while ((currentLine = br.readLine()) != null) {
                String[] line = currentLine.split(delimiter);
                if (!line[0].equals("PLAN") && !line[1].equals("PERIODE VON")) {
                    csvRows.add(new CsvRow(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7],line[8],
                            line[9],line[10],line[11],line[12],line[13], line[14], line[15], line[16], line[17],
                            line[18], line[19], line[20], line[21], line[22], line[23]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(csvRows.size());
        return csvRows;
    }




}