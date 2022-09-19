import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "P1wrg_rR";
        String password = "P1ewttttttttttttttttttttttttttrwe_1";
        String confirmPassword = "P1ewtttttttttttttttttttttttttrwe_1";
        System.out.println(userDataVerification(login,password,confirmPassword));
    }

    public static boolean userDataVerification(String login,String password,String confirmPassword){
        boolean userLoginVerification;
        boolean loginLengthCheck;
        boolean userPasswordVerification;
        boolean passwordLengthCheck;
        boolean comparePasswordAndConfirmPassword;
        try {
            userLoginVerification = userLoginVerification(login);
            loginLengthCheck = loginLengthCheck(login);
            userPasswordVerification = userPasswordVerification(password);
            passwordLengthCheck = passwordLengthCheck(password);
            comparePasswordAndConfirmPassword = comparePasswordAndConfirmPassword(password,confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return userLoginVerification
                && loginLengthCheck
                && userPasswordVerification
                && passwordLengthCheck
                && comparePasswordAndConfirmPassword;
    }

    public static boolean userLoginVerification(String login) throws NullPointerException{
        if (login == null){
            throw new NullPointerException();
        }
        if (login.matches("\\w+")){
            return true;
        }
        System.out.println("invalid characters in login");
        return false;
    }

    public static boolean loginLengthCheck(String login) throws WrongLoginException{
        if(login.length() > 20){
            throw new WrongLoginException("login length is more than 20 characters");
        }
        return true;
    }

    public static boolean userPasswordVerification(String password) throws NullPointerException{
        if (password == null){
            throw new NullPointerException();
        }
        if (password.matches("\\w+")){
            return true;
        }
        System.out.println("invalid characters in password");
        return false;
    }

    public static boolean passwordLengthCheck(String password){
        return password.length() <= 19;
    }

    public static boolean comparePasswordAndConfirmPassword(String password,String confirmPassword) throws WrongPasswordException{
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("passwords are not the same");
        }
        return true;
    }
}