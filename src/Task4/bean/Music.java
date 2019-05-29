package Task4.bean;

public abstract class Music {
    private String name;
    private long duration;
    private MusicType musicType;

    Music() {
    }

    public void playMusic() {
        System.out.println("Playing music...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public MusicType getMusicType() {
        return musicType;
    }

    public void setMusicType(MusicType musicType) {
        this.musicType = musicType;
    }
}
