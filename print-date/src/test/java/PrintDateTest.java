import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class PrintDateTest {

	@Test
	public void printDate() throws Exception {

		//Given
		Date expectedDate = new Date();
		DateGenerator dateGenerator = new DateGeneratorStub(expectedDate);
		Printer printer = new PrinterMock();
		PrintDate printDate = new PrintDate(dateGenerator, printer);

		//When
		printDate.printCurrentDate();

		//then
		Assert.assertEquals(expectedDate, ((PrinterMock)printer).getPrintedDate());
	}
}


