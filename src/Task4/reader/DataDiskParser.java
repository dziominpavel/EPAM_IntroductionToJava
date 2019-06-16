package Task4.reader;


import Task4.exceptions.DataParcerExeption;

import static Task4.properties.DiskProperties.SEPARATOR;

public class DataDiskParser {

    public static String[] diskInfo(String stringDiskData) {
        try {
            if (stringDiskData != null) {
                String[] diskInfo = stringDiskData.split(SEPARATOR);
                if (diskInfo.length != 3) {
                    System.out.println("Не корректное число параметров");
                    throw new DataParcerExeption("tempMessage");
                }
                return diskInfo;
            } else {
                System.out.println("Не найдена информация о диске");
                throw new DataParcerExeption("tempMessage");
            }
        } catch (DataParcerExeption e) {
            System.out.println("Ошибка чтения информации о диске из файла");
        }
        return null;
    }


}
