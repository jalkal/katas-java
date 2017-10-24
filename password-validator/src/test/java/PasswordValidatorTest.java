import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PasswordValidatorTest {

    PasswordValidator testSubject;

    @Before
    public void setUp() {
        testSubject = new PasswordValidator();
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Test
    public void validate_passwordIsCorrect_dontThrowException() throws Exception {
        //Given
        String aValidPassword = "Hello_10_";

        //When
        testSubject.validate(aValidPassword);

        //Then Doesn't fail
    }

    @Test
    public void validate_lengthIsLowerThanEight_exceptionThrown() throws Exception {
        //Given
        String passwordToValidate = "Hello_10";

        //When-Then
        assertException(passwordToValidate);
    }

    @Test
    public void validate_doesNotContainCapitalLetter_exceptionThrown() throws Exception {
        //Given
        String passwordToValidate = "hello_10_";

        //When-Then
        assertException(passwordToValidate);
    }

    @Test
    public void validate_doesNotContainLowerCase_exceptionThrown() throws Exception {
        //Given
        String passwordToValidate = "HELLO_10_";

        //When-Then
        assertException(passwordToValidate);
    }

    @Test
    public void validate_doesNotContainNumber_exceptionThrown() throws Exception {
        //Given
        String passwordToValidate = "Hello_lo_";

        //When-Then
        assertException(passwordToValidate);
    }

    @Test
    public void validate_doesNotContainUnderscore_exceptionThrown() throws Exception {
        //Given
        String passwordToValidate = "Hello-10-";

        //When-Then
        assertException(passwordToValidate);
    }

    private void assertException(String passwordToValidate) throws Exception {

        expectedException.expect(Exception.class);
        testSubject.validate(passwordToValidate);
    }
}
