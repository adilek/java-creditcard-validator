package az.adil.finance;

/**
 *
 * @author Adil Aliyev
 */
public class Card {

    public enum CardType {

        AMERICAN_EXPRESS,
        MASTERCARD,
        VISA,
        UNKNOWN,
        INVALID

    }

    private long cardNumber;
    private CardType cardType;

    public Card() {
    }

    public Card(long cardNumber) {
        this();
        this.cardNumber = cardNumber;
        this.cardType = this.getCardType();
    }

    public Card(String cardNumber) {
        this();
        try {
            this.cardNumber = Long.parseLong(cardNumber);
            this.cardType = this.getCardType();
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format.");
        }
    }

    public boolean isValid() {
        return LuhnValidator.getInstance().validate(cardNumber);
    }

    public final CardType getCardType() {
        if (isValid()) {
            if (isVisa(cardNumber)) {
                return CardType.VISA;
            } else if (isMasterCard(cardNumber)) {
                return CardType.MASTERCARD;
            } else if (isAmericanExpress(cardNumber)) {
                return CardType.AMERICAN_EXPRESS;
            } else {
                return CardType.UNKNOWN;
            }
        } else {
            return CardType.INVALID;
        }

    }

    protected boolean isVisa(long cardNumber) {
        String s = Long.toString(cardNumber);
        return ((s.length() == 13 || s.length() == 16) && s.charAt(0) == '4');
    }

    protected boolean isMasterCard(long cardNumber) {
        String s = Long.toString(cardNumber);
        return (s.length() == 16 && s.charAt(0) == '5' && (s.charAt(1) >= '0' && s.charAt(1) <= '5'));
    }

    protected boolean isAmericanExpress(long cardNumber) {
        String s = Long.toString(cardNumber);
        return (s.length() == 15 && s.charAt(0) == '3' && (s.charAt(1) == '4' || s.charAt(1) == '7'));
    }

    public long getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return "Card{" + "cardNumber=" + cardNumber + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.cardNumber ^ (this.cardNumber >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        return this.cardNumber == other.cardNumber;
    }

}
