/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class CardTest {

    public CardTest() {
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
     * Test of getCardType method, of class Card.
     */
    @Test
    public void testGetCardType() {
        System.out.println("getCardType");
        Card instance;

        instance = new Card(5555555555554444L);
        assertEquals(Card.CardType.MASTERCARD, instance.getCardType());

        instance = new Card(371449635398431L);
        assertEquals(Card.CardType.AMERICAN_EXPRESS, instance.getCardType());

        instance = new Card(378282246310005L);
        assertEquals(Card.CardType.AMERICAN_EXPRESS, instance.getCardType());

        instance = new Card(5105105105105100L);
        assertEquals(Card.CardType.MASTERCARD, instance.getCardType());
        
        instance = new Card(4111111111111111L);
        assertEquals(Card.CardType.VISA, instance.getCardType());
        
        instance = new Card(4222222222222L);
        assertEquals(Card.CardType.VISA, instance.getCardType());
        
        instance = new Card(6011111111111117L);        
        assertEquals(Card.CardType.UNKNOWN, instance.getCardType());
        
        instance = new Card(4563960123001999L);
        assertEquals(Card.CardType.INVALID, instance.getCardType());
        
        instance = new Card(0L);
        assertEquals(Card.CardType.INVALID, instance.getCardType());
        
        instance = new Card(1L);
        assertEquals(Card.CardType.INVALID, instance.getCardType());

    }

    /**
     * Test of isVisa method, of class Card.
     */
    @Test
    public void testIsVisa() {
        System.out.println("isVisa");

        Card instance = new Card();

        assertTrue(instance.isVisa(4111111111111111L));
        assertTrue(instance.isVisa(4012888888881881L));
        assertFalse(instance.isVisa(378282246310005L));
        assertFalse(instance.isVisa(5610591081018250L));

    }

    /**
     * Test of isMasterCard method, of class Card.
     */
    @Test
    public void testIsMasterCard() {
        System.out.println("isMasterCard");

        Card instance = new Card();

        assertTrue(instance.isMasterCard(5555555555554444L));
        assertTrue(instance.isMasterCard(5105105105105100L));
        assertFalse(instance.isMasterCard(4012888888881881L));
        assertFalse(instance.isMasterCard(4222222222222L));

    }

    /**
     * Test of isAmericanExpress method, of class Card.
     */
    @Test
    public void testIsAmericanExpress() {
        System.out.println("isAmericanExpress");

        Card instance = new Card();

        assertTrue(instance.isAmericanExpress(371449635398431L));
        assertTrue(instance.isAmericanExpress(378734493671000L));
        assertFalse(instance.isAmericanExpress(6011111111111117L));
        assertFalse(instance.isAmericanExpress(6011000990139424L));

    }

}
