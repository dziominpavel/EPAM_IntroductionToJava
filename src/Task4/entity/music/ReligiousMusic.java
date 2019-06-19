package Task4.entity.music;

import static Task4.reader.TrackValidator.trackReligionValidator;

public class ReligiousMusic extends Music {
    private String religion;
    private String language;


    private String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        if (trackReligionValidator(religion)) {
            this.religion = religion;
        }
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        if (trackReligionValidator(language)) {
            this.language = language;
        }
    }

    @Override
    public void playMusic() {
        System.out.println("Playing Religious music...");
    }

    @Override
    public String toString() {
        return "ReligiousMusic{" +
                "religion='" + religion + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReligiousMusic that = (ReligiousMusic) o;

        if (!getReligion().equals(that.getReligion())) return false;
        return getLanguage().equals(that.getLanguage());
    }

    @Override
    public int hashCode() {
        int result = getReligion().hashCode();
        result = 31 * result + getLanguage().hashCode();
        return result;
    }
}
