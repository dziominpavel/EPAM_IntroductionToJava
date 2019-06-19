package Task4.entity.music;

import Task4.entity.enums.Style;

import static Task4.reader.TrackValidator.*;

public class ModernMusic extends Music {
    private Style style = Style.Unknown;
    private String singer = "Unknown";
    private String composer = "Unknown";

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        if (trackStyleValidator(String.valueOf(style))) {
            this.style = style;
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

    private String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        if (trackComposerValidator(composer)) {
            this.composer = composer;
        }
    }

    @Override
    public void playMusic() {
        System.out.println("Playing Modern music...");
    }

    @Override
    public String toString() {
        return "ModernMusic{" +
                "style=" + style +
                ", singer='" + singer + '\'' +
                ", composer='" + composer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModernMusic that = (ModernMusic) o;

        if (getStyle() != that.getStyle()) return false;
        if (!getSinger().equals(that.getSinger())) return false;
        return getComposer().equals(that.getComposer());
    }

    @Override
    public int hashCode() {
        int result = getStyle().hashCode();
        result = 31 * result + getSinger().hashCode();
        result = 31 * result + getComposer().hashCode();
        return result;
    }
}
