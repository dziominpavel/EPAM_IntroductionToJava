package Task4.reader;

import Task4.entity.enums.Country;
import Task4.entity.enums.MusicType;
import Task4.entity.enums.Style;

public class TrackValidator {


    public static boolean trackNameValidator(String trackName) {
        if (trackName.length() != 0) {
            return true;
        } else {
            System.out.println("Не удалось распознать имя трека");
            return false;
        }
    }

    public static boolean trackDurationValidator(String trackDuration) {
        try {
            if (Long.parseLong(trackDuration) != 0) {
                return true;
            } else {
                System.out.println("Не удалось распознать длинну трека");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Не удалось распознать длинну трека");
            return false;
        }

    }

    public static boolean trackTypeValidator(String trackType) {
        for (MusicType type : MusicType.values()) {
            try {
                if (MusicType.valueOf(trackType) == type) {
                    return true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Не удалось распознать тип трека");
                return false;
            }
        }
        System.out.println("Не удалось распознать тип трека");
        return false;
    }

    public static boolean trackEraValidator(String trackEra) {
        if (trackEra.length() != 0) {
            return true;
        } else {
            System.out.println("Не удалось распознать эру трека");
            return false;
        }
    }

    public static boolean trackComposerValidator(String trackComposer) {
        if (trackComposer.length() != 0) {
            return true;
        } else {
            System.out.println("Не удалось распознать композитора трека");
            return false;
        }
    }

    public static boolean trackYearValidator(String trackYear) {
        try {
            if (Integer.parseInt(trackYear) != 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Не удалось распознать год трека");
            return false;
        }
        return false;
    }

    public static boolean trackStyleValidator(String trackstyle) {
        for (Style style : Style.values()) {
            try {
                if (Style.valueOf(trackstyle) == style) {
                    return true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Не удалось распознать стиль трека");
                return false;
            }
        }
        System.out.println("Не удалось распознать стиль трека");
        return false;
    }

    public static boolean trackSingerValidator(String trackSinger) {
        if (trackSinger.length() != 0) {
            return true;
        } else {
            System.out.println("Не удалось распознать певца трека");
            return false;
        }
    }

    public static boolean trackCountryValidator(String trackCountry) {
        for (Country country : Country.values()) {
            try {
                if (Country.valueOf(trackCountry) == country) {
                    return true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Не удалось распознать страну трека");
                return false;
            }
        }
        System.out.println("Не удалось распознать страну трека");
        return false;
    }


    public static boolean trackReligionValidator(String trackReligion) {
        if (trackReligion.length() != 0) {
            return true;
        } else {
            System.out.println("Не удалось распознать религию трека");
            return false;
        }
    }

    public static boolean trackLanguageValidator(String trackLanguage) {
        if (trackLanguage.length() != 0) {
            return true;
        } else {
            System.out.println("Не удалось распознать язык трека");
            return false;
        }
    }
}