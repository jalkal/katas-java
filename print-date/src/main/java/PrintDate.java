import java.util.Date;

public class PrintDate {


	private final DateGenerator dateGenerator;
	private final Printer printer;

	public PrintDate(DateGenerator dateGenerator, Printer printer) {

		this.dateGenerator = dateGenerator;
		this.printer = printer;
	}

	public void printCurrentDate() {

		Date date = dateGenerator.generateDate();
		printer.print(date);
	}
}



