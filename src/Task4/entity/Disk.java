package Task4.entity;

import Task4.entity.music.Music;

import java.util.List;

import static Task4.reader.DiskValidator.*;

public class Disk {
    private String name = "defaultDiskName";
    private String description = "defaultDiskDescription";
    private String date = "01.01.01";
    private List<Music> musicList;

    public Disk() {
    }

    public Disk(String name, String description, String date) {
        setName(name);
        setDescription(description);
        setDate(date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (diskNameValidator(name)) {
            this.name = name;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (diskDescriptionValidator(description)) {
            this.description = description;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (diskDateValidator(date)) {
            this.date = date;
        }
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        if (musicList != null) {
            this.musicList = musicList;
        }

    }
}
