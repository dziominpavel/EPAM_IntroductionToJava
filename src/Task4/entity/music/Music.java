package Task4.entity.music;

import Task4.entity.enums.MusicType;

import static Task4.entity.enums.MusicType.Modern;
import static Task4.reader.TrackValidator.*;

public abstract class Music {
    private String name = "Unknown";
    private long duration = 0;
    private MusicType musicType = Modern;

    Music() {
    }

    public Music(String name, long duration, MusicType musicType) {
        setName(name);
        setDuration(duration);
        setMusicType(musicType);
    }

    public void playMusic() {
        System.out.println("Playing music...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (trackNameValidator(name)) {
            this.name = name;
        }
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        if (trackDurationValidator(String.valueOf(duration))) {
            this.duration = duration;
        }
    }

    public MusicType getMusicType() {
        return musicType;
    }

    public void setMusicType(MusicType musicType) {
        if (trackTypeValidator(String.valueOf(musicType))) {
            this.musicType = musicType;
        }
    }
}
