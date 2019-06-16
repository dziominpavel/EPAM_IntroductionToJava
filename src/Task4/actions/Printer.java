package Task4.actions;

import Task4.entity.Disk;
import Task4.entity.music.Music;

import java.util.List;

public class Printer {

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
            System.out.println("Трек не найден");
        }
    }
}
