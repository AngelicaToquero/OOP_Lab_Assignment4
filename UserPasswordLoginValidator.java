import java.util.Scanner;
public class UserPasswordLoginValidator {
    public static void main(String[] args) {
        int loginAttempts = 0;
        int maximumTries = 3;
        String enteredPassword = "";
        Scanner input = new Scanner(System.in);

        while (loginAttempts < maximumTries) {
            System.out.print("Enter password: ");
            enteredPassword = input.nextLine();

            try {
                String validPassword = "password";
                if (enteredPassword.equals(validPassword)) {
                    System.out.println("Login successful!");
                    return;
                } else {
                    loginAttempts++; // Increment the count of login attempts for each try
                    int remainingAttempts = maximumTries - loginAttempts; // Calculate the remaining attempts (max =3 attempts)
                    if (remainingAttempts == 0) {
                        throw new MaxLoginAttemptsException("Maximum number of attempts reached. Try again later.");
                    } else {
                        throw new InvalidPasswordException("You have entered invalid password. Please try again.\n" +remainingAttempts + " attempts remaining.\n");
                    }
                }
            } catch (MaxLoginAttemptsException e) {
                System.out.println(e.getMessage());
                return;
            } catch (InvalidPasswordException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}