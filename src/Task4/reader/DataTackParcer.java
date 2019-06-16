package Task4.reader;


import static Task4.properties.DiskProperties.SEPARATOR;

public class DataTackParcer {
    public static String[] trackInfo(String stringTrackData) {
        try {
            if (stringTrackData != null) {
                String[] trackInfo = new String[6];
                System.arraycopy(stringTrackData.split(SEPARATOR), 0, trackInfo, 0, 6);
                return trackInfo;
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения информации о треке из файла");
        }
        return null;
    }
}
