package Task4.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static List<String> dataReader(File file) throws Exception {

        List<String> stringList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String dataLine;

            while ((dataLine = bufferedReader.readLine()) != null) {
                stringList.add(dataLine);
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения информации из файла");
        }
        return stringList;
    }
}


