import java.util.Date;

public interface DateGenerator {

    default Date generateDate(){
        return new Date();
    }
}
