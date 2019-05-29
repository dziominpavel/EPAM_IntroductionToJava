package Task4;

import Task4.bean.*;
import Task4.factory.MusicFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        ArrayList<Music> trackList = trackListCreator();
        Disk disk = burnDisk(trackList);
        System.out.println("Записан диск:");
        printDisk(disk);
        System.out.println("\nДлинна Всех треков равна: " + calcDiskDuration(disk));

        System.out.println("\nОтсортированный по стилю диск:");
        printDisk(sortTracks(disk));

        printTrack(findSpecifiedTrack(trackList, 10, 20));

    }


    private static ArrayList<Music> trackListCreator() {
        ArrayList<Music> trackList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            Music music = new MusicFactory().createMusic(MusicType.values()[new Random()
                    .nextInt(MusicType.values().length)]);
            music.setName("Track" + i);
            music.setDuration(new Random().nextInt(100));
            if (music instanceof ClassicalMusic) {
                music.setMusicType(MusicType.Classical);
                ((ClassicalMusic) music).setComposer("Shopen");
                ((ClassicalMusic) music).setEra("Progressevizm");
                ((ClassicalMusic) music).setYear(1712);
            } else if (music instanceof ModernMusic) {
                music.setMusicType(MusicType.Modern);
                ((ModernMusic) music).setComposer("Igor Krutoy");
                ((ModernMusic) music).setStyle(Style.Pop);
                ((ModernMusic) music).setSinger("Kirkorov");
            } else if (music instanceof NationalMusic) {
                music.setMusicType(MusicType.National);
                ((NationalMusic) music).setSinger("Babkina");
                ((NationalMusic) music).setCountry(Country.Russia);
            } else if (music instanceof ReligiousMusic) {
                music.setMusicType(MusicType.Religious);
                ((ReligiousMusic) music).setReligion("Christianstvo");
                ((ReligiousMusic) music).setLanguage("Russian");
            }
            trackList.add(music);
        }
        return trackList;

    }

    /**
     * prints all track on disk
     */
    private static void printDisk(Disk disk) {
        for (Music music : disk.getMusicList()) {
            System.out.println(music.getName() + " " + music + "duration=" + music.getDuration());
        }
    }

    private static Disk burnDisk(ArrayList<Music> trackList) {
        return new Disk("Disk1", "Sborka", "29.05.2019", trackList);
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
    private static Disk sortTracks(Disk disk) {
        disk.getMusicList().sort(Comparator.comparing(Music::getMusicType));
        return disk;
    }

    /**
     * method find track with specified range of duration
     */
    private static Music findSpecifiedTrack(ArrayList<Music> trackList, long lowDuration, long highDuration) {
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