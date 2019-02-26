/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordGeneratorTest {

    private PasswordGenerator p;

    @Before
    public void setUp(){
        p = new PasswordGenerator();
    }


    @Test public void shouldReturnSecretPassword() {
        String secretPassword = p.checkSecretPassword(3, 1, 1);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        assertThat(bCryptPasswordEncoder.matches(secretPassword,
                    "$2a$10$N43LdqU9b1ZMuZM2KiBnIeaXiPqxYcTEVoMFabb9ZV2jfG82jupD6"))
                    .isTrue();
    }

    @Test
    public void shouldReturnRandomLetter(){
        assertThat(p.RandomIndexGenerator(p.getAlphaCharArray())).isNotEqualTo(p.RandomIndexGenerator(p.getAlphaCharArray()));
    }

    @Test
    public void shouldReturnRandomNumber(){
        assertThat(p.RandomIndexGenerator(p.getNumberCharArray())).isNotEqualTo(p.RandomIndexGenerator(p.getNumberCharArray()));
    }

    @Test
    public void shouldReturnRandomSpecialCharacter(){
        assertThat(p.RandomIndexGenerator(p.getSpecialCharArray())).isNotEqualTo(p.RandomIndexGenerator(p.getSpecialCharArray()));
    }

    @Test
    public void shouldReturnPasswordWithLengthOf10(){
            assertThat(p.generatePassword(10, 2, 2).length()).isEqualTo(10);
    }

    @Test
    public void shouldReturnPasswordContaining2Numbers(){
        String password = p.generatePassword(10, 2, 0);

        char[] passwordArray = password.toCharArray();
        int numberCount = 0;

        for (int i = 0; i < passwordArray.length; i++){

            if (passwordArray[i] >= '0' && passwordArray[i] <= '9'){
                numberCount++;
            }
        }

        assertThat(numberCount).isEqualTo(2); // update to work with any number number count
    }

    @Test
    public void shouldReturnPasswordContaining2NumbersAnd2SpecialCharacters() {
        String password = p.generatePassword(10, 2, 2);
        char[] specialCharacters = p.getSpecialCharArray();

        char[] passwordArray = password.toCharArray();
        int numberCount = 0;
        int specialCharCount = 0;

        for (char passwordCharacter : passwordArray) {

            if (passwordCharacter >= '0' & passwordCharacter <= '9') {
                numberCount++;
            }

            for (char specialCharacter : specialCharacters) {

                if (passwordCharacter == specialCharacter) {
                    specialCharCount++;
                }
            }
        }
        assertThat(numberCount).isEqualTo(2);
        assertThat(specialCharCount).isEqualTo(2);
    }
}