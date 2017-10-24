public class PasswordValidator {


    public void validate(String passwordToValidate) throws Exception {

        if (notContainsCapitalLetter(passwordToValidate)
                || notContainsLowerCase(passwordToValidate)
                || notContainsNumber(passwordToValidate)
                || notContainsUnderscore(passwordToValidate)
                || lengthLowerOrEqualsThanEight(passwordToValidate)){

            throw new Exception();
        }
    }

    private boolean lengthLowerOrEqualsThanEight(String passwordToValidate) {
        return passwordToValidate.length() <= 8;
    }

    private boolean notContainsUnderscore(String passwordToValidate) {
        return !passwordToValidate.matches(".*_.*");
    }

    private boolean notContainsNumber(String passwordToValidate) {
        return !passwordToValidate.matches(".*[0-9].*");
    }

    private boolean notContainsLowerCase(String passwordToValidate) {
        return !passwordToValidate.matches(".*[a-z].*");
    }

    private boolean notContainsCapitalLetter(String passwordToValidate) {
        return !passwordToValidate.matches(".*[A-Z].*");
    }
}