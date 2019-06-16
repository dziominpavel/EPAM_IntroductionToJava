package Task4.entity.music;

import static Task4.reader.TrackValidator.trackReligionValidator;

public class ReligiousMusic extends Music {
    private String religion;
    private String language;


    public String getReligion() {
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
}
