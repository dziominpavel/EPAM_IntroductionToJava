package Task4;

import Task4.entity.Disk;
import Task4.entity.music.Music;
import Task4.reader.DataDiskParser;
import Task4.reader.DataReader;
import Task4.reader.DataTackParcer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static Task4.actions.Creator.diskCreator;
import static Task4.actions.Creator.musicCreator;
import static Task4.actions.DiskActions.*;
import static Task4.actions.Printer.*;
import static Task4.properties.DiskProperties.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Logger log = LogManager.getLogger(Main.class);

        String diskInfo = DataReader.dataReader(diskFilePathName).get(0);
        Disk disk = diskCreator(Objects.requireNonNull(DataDiskParser.diskInfo(diskInfo)));

        List<Music> trackList = new ArrayList<>();
        int numberRows = DataReader.dataReader(tracksFilePathName).size();
        for (int i = 0; i < numberRows; i++) {
            Music music = musicCreator(Objects.requireNonNull(DataTackParcer.trackInfo(DataReader.dataReader(tracksFilePathName).get(i))));
            trackList.add(music);
        }

        disk.setMusicList(trackList);

        System.out.println("Записан диск:");
        printDisk(disk);
        System.out.println("Записано " + numberRows + " треков:");
        printTrackList(trackList);
        System.out.println("\nДлинна Всех треков равна: " + calcDiskDuration(disk));
        System.out.println("\nОтсортированный по типу музыки диск:");
        sortTracks(disk);
        printTrackList(disk.getMusicList());
        System.out.println("\nТрек с длиной в промежутке от " + MIN_RANGE_SEARCHERS + " до " + MAX_RANGE_SEARCHERS + ":");
        printTrack(findSpecifiedTrack(disk.getMusicList(), MIN_RANGE_SEARCHERS, MAX_RANGE_SEARCHERS));

    }


}