package Task4.reader;


public class DataDiskParser {
    public static String[] diskInfo(String stringDiskData) {
        try {
            if (stringDiskData != null) {
                String[] diskInfo = new String[3];
                diskInfo[0] = stringDiskData.split("/")[0];
                diskInfo[1] = stringDiskData.split("/")[1];
                diskInfo[2] = stringDiskData.split("/")[2];
                return diskInfo;
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения информации о диске из файла");
        }
        return null;
    }
}
