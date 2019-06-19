package Task4.actions;

import Task4.entity.Disk;
import Task4.entity.enums.Country;
import Task4.entity.enums.MusicType;
import Task4.entity.enums.Style;
import Task4.entity.music.*;
import Task4.factory.MusicFactory;

public class Creator {


    public static Music musicCreator(String[] trackInfo) {

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
     * method create new Disk with specified tracklist
     *
     * @return new disk
     */
    public static Disk diskCreator(String[] diskInfo) {

        String name = diskInfo[0];
        String description = diskInfo[1];
        String date = diskInfo[2];

        return new Disk(name, description, date);


    }
}
