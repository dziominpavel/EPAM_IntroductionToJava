package Task4.entity.music;

import Task4.entity.enums.Country;

import static Task4.reader.TrackValidator.trackCountryValidator;
import static Task4.reader.TrackValidator.trackSingerValidator;

public class NationalMusic extends Music {
    private Country country = Country.Unknown;
    private String singer = "Unknown";


    private Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        if (trackCountryValidator(String.valueOf(country))) {
            this.country = country;
        }
    }

    private String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        if (trackSingerValidator(singer)) {
            this.singer = singer;
        }
    }

    @Override
    public void playMusic() {
        System.out.println("Playing National music...");
    }

    @Override
    public String toString() {
        return "NationalMusic{" +
                "country=" + country +
                ", singer='" + singer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NationalMusic that = (NationalMusic) o;

        if (getCountry() != that.getCountry()) return false;
        return getSinger().equals(that.getSinger());
    }

    @Override
    public int hashCode() {
        int result = getCountry().hashCode();
        result = 31 * result + getSinger().hashCode();
        return result;
    }
}
