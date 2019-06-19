package Task4.actions;

import Task4.entity.Disk;
import Task4.entity.music.Music;

import java.util.Comparator;
import java.util.List;

public class DiskActions {

    /**
     * method calc sum of durations all tracks on the disk
     */
    public static long calcDiskDuration(Disk disk) {
        long duration = 0;
        for (Music music : disk.getMusicList()) {
            duration += music.getDuration();
        }
        return duration;
    }

    /**
     * method sorts track on disk by musicType
     */
    public static void sortTracks(Disk disk) {
        disk.getMusicList().sort(Comparator.comparing(Music::getMusicType).thenComparing(Music::getDuration));
    }

    /**
     * method finds track with specified range of duration
     */
    public static Music findSpecifiedTrack(List<Music> trackList,
                                           long lowDuration, long highDuration) {
        for (Music music : trackList) {
            if (music.getDuration() > lowDuration && music.getDuration() < highDuration) {
                return music;
            }
        }
        return null;
    }
}
