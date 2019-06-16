package Task4.factory;

import Task4.entity.enums.MusicType;
import Task4.entity.music.*;

public class MusicFactory {
    public Music createMusic(MusicType musicType) throws IllegalArgumentException {
        if (musicType == null) {
            throw new IllegalArgumentException();
        }

        switch (musicType) {
            case Classical:
                return new ClassicalMusic();
            case Modern:
                return new ModernMusic();
            case National:
                return new NationalMusic();
            case Religious:
                return new ReligiousMusic();
            default:
                throw new IllegalArgumentException();
        }
    }
}
