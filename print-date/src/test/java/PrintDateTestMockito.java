import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PrintDateTestMockito {

    @Mock
    DateGenerator dateGenerator;

    @Mock
    Printer printer;

    @InjectMocks
    PrintDate testSubject;

    @Test
    public void printCurrentDate(){

        //Given
        Date expectedDate = new Date();
        when(dateGenerator.generateDate()).thenReturn(expectedDate);

        //when
        testSubject.printCurrentDate();

        //Then
        verify(printer).print(expectedDate);
    }
}
