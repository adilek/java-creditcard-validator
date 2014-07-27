package az.adil.finance;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adil Aliyev
 */
public class LuhnValidatorTest {

    public LuhnValidatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class LuhnValidator.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        LuhnValidator instance = LuhnValidator.getInstance();
        assertTrue(instance instanceof LuhnValidator);
    }

    /**
     * Test of validate method, of class LuhnValidator.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");

        LuhnValidator instance = new LuhnValidator();

        assertFalse(instance.validate(0L));
        assertFalse(instance.validate(1L));
        assertFalse(instance.validate(2L));
        assertTrue(instance.validate(378282246310005L));
        assertTrue(instance.validate(371449635398431L));
        assertTrue(instance.validate(378734493671000L));
        assertTrue(instance.validate(5610591081018250L));
        assertTrue(instance.validate(30569309025904L));
        assertTrue(instance.validate(38520000023237L));
        assertTrue(instance.validate(6011111111111117L));
        assertTrue(instance.validate(6011000990139424L));
        assertTrue(instance.validate(3530111333300000L));
        assertTrue(instance.validate(3566002020360505L));
        assertTrue(instance.validate(5555555555554444L));
        assertTrue(instance.validate(5105105105105100L));
        assertTrue(instance.validate(4111111111111111L));
        assertTrue(instance.validate(4012888888881881L));
        assertTrue(instance.validate(4222222222222L));
        assertTrue(instance.validate(5019717010103742L));
        assertTrue(instance.validate(6331101999990016L));
        assertFalse(instance.validate(76009244561L));
        assertFalse(instance.validate(4222222222222222L));
        assertFalse(instance.validate(1234567812345678L));
        assertFalse(instance.validate(49927398717L));
    }

    /**
     * Test of sumOfDigits method, of class LuhnValidator.
     */
    @Test
    public void testSumOfDigits() {
        System.out.println("sumOfDigits");
        LuhnValidator instance = new LuhnValidator();
        assertEquals(0, instance.sumOfDigits(0));
        assertEquals(1, instance.sumOfDigits(1));
        assertEquals(2, instance.sumOfDigits(2));
        assertEquals(3, instance.sumOfDigits(3));
        assertEquals(4, instance.sumOfDigits(4));
        assertEquals(5, instance.sumOfDigits(5));
        assertEquals(6, instance.sumOfDigits(6));
        assertEquals(7, instance.sumOfDigits(7));
        assertEquals(8, instance.sumOfDigits(8));
        assertEquals(9, instance.sumOfDigits(9));
        assertEquals(1, instance.sumOfDigits(10));
        assertEquals(1, instance.sumOfDigits(-10));
        assertEquals(2, instance.sumOfDigits(-11));
        assertEquals(5, instance.sumOfDigits(-1121));
        assertEquals(2, instance.sumOfDigits(11));
        assertEquals(10, instance.sumOfDigits(1111111111));
        assertEquals(81, instance.sumOfDigits(999999999));

    }

}
