import exceptions.WrongLoginException;

public class Main {
    public static void main(String[] args) {
        String login = "hdryjdy";
        String password = "ацуац";
        String confirmPassword = "ацуац";
        receivingUserData(login,password,confirmPassword);
    }

    public static boolean receivingUserData(String login,String password,String confirmPassword){
        boolean loginSymbol = login.matches("^[a-z0-9_]+$");
        boolean passwordSymbol = password.matches("^[a-zA-Z0-9_]+$");
        boolean passwordComparison = confirmPassword.equals(password);
        if ((!loginSymbol) || (login.length() > 20)) {
            try {
                throw new WrongLoginException("Ошибка ввода");
            } catch (WrongLoginException e) {
                System.out.println("Error");
            } finally {
                return false;
            }
        } else if ((!passwordSymbol) || (password.length() >= 20)) {
            try {

                throw new WrongLoginException("Ошибка ввода");
            } catch (WrongLoginException e) {
                System.out.println("Error");
            } finally {
                return false;
            }
        } else if (!passwordComparison) {
            try {
                throw new WrongLoginException("Ошибка ввода");
            } catch (WrongLoginException e) {
                System.out.println("Error");
            } finally {
                return false;
            }
        } else System.out.println("Пользователь зарегистрирован");
        return true;
    }
}