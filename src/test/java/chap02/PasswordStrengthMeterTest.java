package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr){
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    //TC1
    @Test
    void meetsAllCriteria_Then_Strong(){
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }


    //TC2
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("Ab12!c", PasswordStrength.NORMAL);
    }

    //TC3
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal(){
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    //TC4
    @Test
    void nullInput_Then_Invalid(){
        assertStrength(null, PasswordStrength.INVALID);
    }

    //TC4
    @Test
    void emptyInput_Then_Invalid(){
        assertStrength("", PasswordStrength.INVALID);
    }

    //TC5
    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    //TC6
    @Test
    void meetsOnlyLengthCriteria_Then_Weak(){
        assertStrength("abdefghi", PasswordStrength.WEAK);
    }

    //TC7
    @Test
    void meetsOnlyNumCriteria_Then_Weak(){
        assertStrength("12345", PasswordStrength.WEAK);
    }

    //TC8
    @Test
    void meetsOnlyUpperCriteria_Then_Weak(){
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    //TC9
    @Test
    void meetsNoCriteria_Then_Weak(){
        assertStrength("abc", PasswordStrength.WEAK);
    }
}
