package Task4;

import Task4.entity.Country;
import Task4.entity.Disk;
import Task4.entity.MusicType;
import Task4.entity.Style;
import Task4.entity.music.*;
import Task4.factory.MusicFactory;
import Task4.reader.DataDiskParser;
import Task4.reader.DataReader;
import Task4.reader.DataTackParcer;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static Task4.properties.DiskProperties.MAX_RANGE_SEARCHERS;
import static Task4.properties.DiskProperties.MIN_RANGE_SEARCHERS;


public class Main {


    public static void main(String[] args) throws Exception {
        File diskDataFile = new File("src\\Task4\\data\\disk_data.txt");
        File tracksDataFile = new File("src\\Task4\\data\\track_list_data.txt");

        Disk disk = diskCreator(DataDiskParser.diskInfo(DataReader.dataReader(diskDataFile).get(0)));


        List<Music> trackList = new ArrayList<>();
        int numberRows = DataReader.dataReader(tracksDataFile).size();
        for (int i = 0; i < numberRows; i++) {
            Music music = musicCreator(Objects.requireNonNull(DataTackParcer.trackInfo(DataReader.dataReader(tracksDataFile).get(i))));
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


    private static Music musicCreator(String[] trackInfo) {

        try {
            Music music = new MusicFactory().createMusic(MusicType.valueOf(trackInfo[2]));
            music.setName(trackInfo[0]);
            music.setDuration(Long.valueOf(trackInfo[1]));
            music.setMusicType(MusicType.valueOf(trackInfo[2]));
            if (music instanceof ModernMusic) {
                ((ModernMusic) music).setComposer(trackInfo[3]);
                ((ModernMusic) music).setStyle(Style.valueOf(trackInfo[4]));
                ((ModernMusic) music).setSinger(trackInfo[5]);
            } else if (music instanceof ClassicalMusic) {
                ((ClassicalMusic) music).setComposer(trackInfo[3]);
                ((ClassicalMusic) music).setEra(trackInfo[4]);
                ((ClassicalMusic) music).setYear(Integer.parseInt(trackInfo[5]));
            } else if (music instanceof NationalMusic) {
                ((NationalMusic) music).setSinger(trackInfo[3]);
                ((NationalMusic) music).setCountry(Country.valueOf(trackInfo[4]));
            } else if (music instanceof ReligiousMusic) {
                ((ReligiousMusic) music).setReligion(trackInfo[3]);
                ((ReligiousMusic) music).setLanguage(trackInfo[4]);
            }
            return music;

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания трека");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * prints all track on disk
     */
    private static void printDisk(Disk disk) {
        System.out.println(disk.getName() + "/" + disk.getDescription() + "/" + disk.getDate());
    }


    private static void printTrackList(List<Music> trackList) {
        for (Music music : trackList) {
            System.out.println(music);

        }
    }

    /**
     * method create new Disk with specified tracklist
     *
     * @return new disk
     */
    private static Disk diskCreator(String[] diskInfo) throws Exception {
        if (diskInfo == null || diskInfo.length != 3) {
            throw new Exception("Ошибка создания диска");
        }

        String name = diskInfo[0];
        String description = diskInfo[1];
        String date = diskInfo[2];

        return new Disk(name, description, date);
    }

    /**
     * method calc sum of durations all tracks on the disk
     */
    private static long calcDiskDuration(Disk disk) {
        long duration = 0;
        for (Music music : disk.getMusicList()) {
            duration += music.getDuration();
        }
        return duration;
    }

    /**
     * methods sorts track on disk by musicType
     */
    private static void sortTracks(Disk disk2) {
        disk2.getMusicList().sort(Comparator.comparing(Music::getMusicType));
    }

    /**
     * method find track with specified range of duration
     */
    private static Music findSpecifiedTrack(List<Music> trackList,
                                            long lowDuration, long highDuration) {
        for (Music music : trackList) {
            if (music.getDuration() > lowDuration && music.getDuration() < highDuration) {
                return music;
            }
        }
        return null;
    }

    /**
     * method prints track
     */
    private static void printTrack(Music music) {
        if (music != null) {
            System.out.println("\nНайденный трек:");
            System.out.println(music.getName() + " " + music + "duration=" + music.getDuration());
        } else {
            System.out.println("Трек не найден");
        }
    }


}