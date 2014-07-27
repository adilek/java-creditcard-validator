package az.adil.finance;

/**
 *
 * @author Adil Aliyev
 */
public class LuhnValidator {

    private static LuhnValidator instance = null;

    protected LuhnValidator() {

    }

    public static LuhnValidator getInstance() {
        if (instance == null) {
            instance = new LuhnValidator();
        }
        return instance;
    }

    public boolean validate(long cardNumber) {
        if (cardNumber > 0) {
            byte digit;
            int checksum = 0;
            boolean odd = true;

            while (cardNumber > 0) {
                digit = (byte) (cardNumber % 10);
                cardNumber = cardNumber / 10;

                checksum += odd ? digit : sumOfDigits(digit * 2);

                odd = !odd;
            }

            return (checksum % 10 == 0);
        } else {
            return false;
        }
    }

    protected int sumOfDigits(int number) {
        int sum = 0;
        number = Math.abs(number);
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

}
