package Task4.actions;

import Task4.entity.Disk;
import Task4.entity.music.Music;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class Printer {

    private static Logger log = LogManager.getLogger(Printer.class);

    /**
     * prints all track on disk
     */
    public static void printDisk(Disk disk) {
        System.out.println(disk.getName() + "/" + disk.getDescription() + "/" + disk.getDate());
    }


    public static void printTrackList(List<Music> trackList) {
        for (Music music : trackList) {
            System.out.println(music);

        }
    }

    /**
     * method prints track
     */
    public static void printTrack(Music music) {
        if (music != null) {
            System.out.println(music.getName() + " " + music + "duration=" + music.getDuration());
        } else {
            log.warn("Incorrect toy name.");
            System.out.println("Трек не найден");
        }
    }
}
