package Task4.bean;

import java.util.Date;

public class ClassicalMusic extends Music {
    private String era;
    private String composer;
    private int year;

    @Override
    public void playMusic() {
        System.out.println("Playing Classical music...");
    }

    public String getEra() {
        return era;
    }

    public void setEra(String era) {
        this.era = era;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ClassicalMusic{" +
                "era='" + era + '\'' +
                ", composer='" + composer + '\'' +
                ", year=" + year +
                '}';
    }
}
