import java.util.Date;

public interface Printer {

    default void print(Date date) {
        System.out.println(date);
    }
}
