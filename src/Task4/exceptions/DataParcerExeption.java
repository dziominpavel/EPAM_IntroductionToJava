package Task4.exceptions;

public class DataParcerExeption extends Exception {

    public DataParcerExeption() {
    }

    public DataParcerExeption(String message) {
        super(message);
    }

    public DataParcerExeption(String message, Throwable cause) {
        super(message, cause);
    }

}
