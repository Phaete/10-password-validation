package com.phaete;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // checkLength()
    @Test
    void checkLength_shouldBeTrue_onLength8() {
        assertTrue(Main.checkLength("12345678"));
    }

    @Test
    void checkLength_shouldBeFalse_onLength4() {
        assertFalse(Main.checkLength("1234"));
    }


    // containsDigits()
    @Test
    void containsDigits_shouldBeTrue_onInputWithDigits() {
        assertTrue(Main.containsDigits("qwertz78"));
    }

    @Test
    void containsDigits_shouldBeFalse_onInputWithoutDigits() {
        assertFalse(Main.containsDigits("qwertzuio"));
    }

    @Test
    void containsDigits_shouldBeTrue_onInputWithOnlyDigits() {
        assertTrue(Main.containsDigits("12345678"));
    }


    // containsLowerCase()
    @Test
    void containsLowerCase_shouldBeTrue_onInputWithLowerCase() {
        assertTrue(Main.containsLowerCase("qwertz78"));
    }

    @Test
    void containsLowerCase_shouldBeFalse_onInputWithoutLowerCase() {
        assertFalse(Main.containsLowerCase("QWEQWEQWE"));
    }

    @Test
    void containsLowerCase_shouldBeTrue_onInputWithMixedCase() {
        assertTrue(Main.containsLowerCase("QwErTzUiO"));
    }

    @Test
    void containsLowerCase_shouldBeFalse_onInputWithoutLetters() {
        assertFalse(Main.containsLowerCase("12345678"));
    }


    // containsUpperCase()
    @Test
    void containsUpperCase_shouldBeTrue_onInputWithUpperCase() {
        assertTrue(Main.containsUpperCase("QWERTZUIO"));
    }

    @Test
    void containsUpperCase_shouldBeFalse_onInputWithoutUpperCase() {
        assertFalse(Main.containsUpperCase("qwertyuio"));
    }

    @Test
    void containsUpperCase_shouldBeTrue_onInputWithMixedCase() {
        assertTrue(Main.containsUpperCase("QwErTzUiO"));
    }

    @Test
    void containsUpperCase_shouldBeFalse_onInputWithoutLetters() {
        assertFalse(Main.containsUpperCase("12345678"));
    }


    // isCommonPassword()
    @Test
    void isCommonPassword_shouldBeTrue_onCommonPassword() {
        assertTrue(Main.isCommonPassword("Password!"));
    }

    @Test
    void isCommonPassword_shouldBeFalse_onUniquePassword() {
        assertFalse(Main.isCommonPassword("ThisIsTheFullstackJavaCourseFromNeueFischeAndThisPasswordIsExtraLong"));
    }

    @Test
    void containsSpecialCharacters_shouldReturnTrue_onInputWithSpecialCharacters() {
        assertTrue(Main.containsSpecialCharacters("password?"));
    }

    @Test
    void containsSpecialCharacters_shouldReturnFalse_onInputWithoutSpecialCharacters() {
        assertFalse(Main.containsSpecialCharacters("p1a2s3s4w5o6r7d8"));
    }

    @RepeatedTest(200)
    void generateSecurePassword_shouldPassTests_onRandomPassword() {
        String password = Main.generateSecurePassword();
        assertTrue(Main.checkLength(password));
        assertTrue(Main.containsDigits(password));
        assertTrue(Main.containsLowerCase(password));
        assertTrue(Main.containsUpperCase(password));
        assertFalse(Main.isCommonPassword(password));
        assertTrue(Main.containsSpecialCharacters(password));
    }

}