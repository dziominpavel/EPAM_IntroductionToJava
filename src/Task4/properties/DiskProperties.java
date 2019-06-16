package Task4.properties;

import java.io.File;

public interface DiskProperties {

    //    public static final int TRACK_LIST_SIZE = 20;     // count of tracks on disk
    //    public static final long MAX_MUSIC_LENGTH = 100;  // max music size
    long MIN_RANGE_SEARCHERS = 20; // min range for music search
    long MAX_RANGE_SEARCHERS = 120; // max range for music search
    String SEPARATOR = "/";
    File diskFilePathName = new File("src\\Task4\\data\\disk_data.txt");
    File tracksFilePathName = new File("src\\Task4\\data\\track_list_data.txt");
}
