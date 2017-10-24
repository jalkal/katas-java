import java.util.Date;

public class DateGeneratorStub implements DateGenerator {

    private Date expectedDate;

    public DateGeneratorStub(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    @Override
    public Date generateDate() {
        return expectedDate;
    }
}
