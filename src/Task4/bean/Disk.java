package Task4.bean;

import java.util.Date;
import java.util.List;

public class Disk {
    private String name;
    private String description;
    private String date;
    private List<Music> musicList;

    public Disk() {
    }

    public Disk(String name, String description, String date, List<Music> musicList) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.musicList = musicList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }
}
