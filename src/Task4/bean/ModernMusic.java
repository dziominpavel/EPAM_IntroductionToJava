package Task4.bean;

public class ModernMusic extends Music {
    private Style style;
    private String singer;
    private String composer;

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
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
}
