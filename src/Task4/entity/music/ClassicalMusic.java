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

    private String getEra() {
        return era;
    }

    public void setEra(String era) {
        if (trackEraValidator(era)) {
            this.era = era;
        }
    }

    private String getComposer() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassicalMusic that = (ClassicalMusic) o;

        if (getYear() != that.getYear()) return false;
        if (!getEra().equals(that.getEra())) return false;
        return getComposer().equals(that.getComposer());
    }

    @Override
    public int hashCode() {
        int result = getEra().hashCode();
        result = 31 * result + getComposer().hashCode();
        result = 31 * result + getYear();
        return result;
    }
}
