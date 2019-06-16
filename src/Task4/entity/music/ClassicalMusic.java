package Task4.entity.music;

import static Task4.reader.TrackValidator.*;

public class ClassicalMusic extends Music {
    private String era = "Unknown";
    private String composer = "Unknown";
    private int year = 1900;

    @Override
    public void playMusic() {
        System.out.println("Playing Classical music...");
    }

    public String getEra() {
        return era;
    }

    public void setEra(String era) {
        if (trackEraValidator(era)) {
            this.era = era;
        }
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        if (trackComposerValidator(composer)) {
            this.composer = composer;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (trackYearValidator(String.valueOf(year))) {
            this.year = year;
        }
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
