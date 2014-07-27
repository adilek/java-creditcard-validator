
import az.adil.finance.Card;



/**
 *
 * @author Adil Aliyev
 * 
 */
public class Main {

    public static void main(String[] args) {        
        Card c = new Card(378282246310005L);
        
        System.out.println(c.isValid());
        System.out.println(c.getCardType());
        
    }

}
