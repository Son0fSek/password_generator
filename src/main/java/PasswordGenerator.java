import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
class PasswordGenerator extends CharacterGenerator {

    String generatePassword(int passwordLength, int numbers, int specialChars) {

        StringBuilder passwordStringBuilder = new StringBuilder();
        List<Character> passwordArray = new ArrayList<>();

        int charactersRemaining = passwordLength - (numbers + specialChars);

        for (int i = 0; i < numbers; i++) {
            passwordArray.add(RandomIndexGenerator(getNumberCharArray()));
        }

        for (int i = 0; i < specialChars; i++) {
            passwordArray.add(RandomIndexGenerator(getSpecialCharArray()));
        }

        for (int i = 0; i < charactersRemaining; i++) {
            passwordArray.add(RandomIndexGenerator(getAlphaCharArray()));
        }

        Collections.shuffle(passwordArray);

        for (char i : passwordArray) {
            passwordStringBuilder.append(i);
        }

        return passwordStringBuilder.toString();
    }

    String checkSecretPassword(int passwordLength, int numbers, int specialChars) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean isMatch = false;
        String crackedPassword = "";

        do {
            String secretPassword = generatePassword(passwordLength, numbers, specialChars);
            System.out.println(secretPassword);

            if (bCryptPasswordEncoder.matches(secretPassword,
                    "$2a$10$N43LdqU9b1ZMuZM2KiBnIeaXiPqxYcTEVoMFabb9ZV2jfG82jupD6")) {
                isMatch = true;
                crackedPassword = secretPassword;
            }
        } while (!isMatch);

        System.out.println("The secret password is: " + crackedPassword + ". BOO-YAH!");
        return crackedPassword;
    }
}