package Task4.entity.music;

import Task4.entity.Country;

public class NationalMusic extends Music {
    private Country country;
    private String singer;


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
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
}
