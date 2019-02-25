import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the password generator! \n" + "\n" +
                "How many characters should your password be?");

        int passwordLength = scanner.nextInt();

        System.out.println("\n" + "How many numbers would you like to include in your password?");

        int numberCount = scanner.nextInt();

        System.out.println("\n" + "How many special characters would you like to include in your password?");

        int specCharCount = scanner.nextInt();

        System.out.println("\n" + "Thanks, here's your password:" + "\n");

        System.out.println(passwordGenerator.generatePassword(passwordLength, numberCount, specCharCount));

    }
}
