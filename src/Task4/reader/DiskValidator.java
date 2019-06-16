package Task4.reader;

public class DiskValidator {

    public static boolean diskNameValidator(String diskName) {
        if (diskName != null && diskName.length() != 0) {
            return true;
        } else {
            System.out.println("Не удалось распознать имя диска");
            return false;
        }
    }

    public static boolean diskDescriptionValidator(String diskDescription) {
        if (diskDescription != null && diskDescription.length() != 0) {
            return true;
        } else {
            System.out.println("Не удалось распознать описание диска");
            return false;
        }
    }

    public static boolean diskDateValidator(String diskDate) {
        if (diskDate != null && diskDate.length() != 0) {
            return true;
        } else {
            System.out.println("Не удалось распознать дату создания диска");
            return false;
        }
    }
}
