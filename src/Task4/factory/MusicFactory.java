package Task4.factory;

import Task4.bean.*;

public class MusicFactory {
    public Music createMusic(MusicType musicType) {
        if (musicType == null) {
            return null;
        }
        if (musicType == MusicType.Classical) {
            return new ClassicalMusic();
        } else if (musicType == MusicType.Modern) {
            return new ModernMusic();
        } else if (musicType == MusicType.National) {
            return new NationalMusic();
        } else if (musicType == MusicType.Religious) {
            return new ReligiousMusic();
        }
        return null;
    }
}
