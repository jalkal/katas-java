import java.util.Date;

public class PrinterMock implements Printer {

    private Date date;

    @Override
    public void print(Date date) {
        this.date = date;
    }

    public Date getPrintedDate() {
        return this.date;
    }
}
