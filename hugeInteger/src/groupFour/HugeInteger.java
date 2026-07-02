package groupFour;

public class HugeInteger {

    private final int[] numbers;
    private static final int MAX_NUMBER_OF_DIGITS = 40;

    public HugeInteger(String numberStr) {
        this.numbers = parse(numberStr);
    }

    private HugeInteger(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] parse(String numberStr) {
        int[] parsed = new int[MAX_NUMBER_OF_DIGITS];
        int length = numberStr.length();

        if (length > MAX_NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException("Number exceeds maximum limit of 40 digits.");
        }

        for (int index = 0; index < length; index++) {
            char digit = numberStr.charAt(length - 1 - index);
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException("String must contain only digits.");
            }
            parsed[MAX_NUMBER_OF_DIGITS - 1 - index] = Character.getNumericValue(digit);
        }
        return parsed;
    }

    public HugeInteger add(HugeInteger other) {
        int[] result = new int[MAX_NUMBER_OF_DIGITS];
        int carry = 0;

        for (int index = MAX_NUMBER_OF_DIGITS - 1; index >= 0; index--) {
            int sum = this.numbers[index] + other.numbers[index] + carry;
            result[index] = sum % 10;
            carry = sum / 10;
        }

        if (carry > 0) {
            throw new ArithmeticException("Overflow: Sum exceeds 40 digits.");
        }

        return new HugeInteger(result);
    }

    public HugeInteger subtract(HugeInteger other) {
        if (this.isLessThan(other)) {
            throw new ArithmeticException("Negative result not supported by this implementation.");
        }

        int[] result = new int[MAX_NUMBER_OF_DIGITS];
        int borrow = 0;

        for (int index = MAX_NUMBER_OF_DIGITS - 1; index >= 0; index--) {
            int diff = this.numbers[index] - other.numbers[index] - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result[index] = diff;
        }

        return new HugeInteger(result);
    }

    public boolean isEqualTo(HugeInteger other) {
        for (int index = 0; index < MAX_NUMBER_OF_DIGITS; index++) {
            if (this.numbers[index] != other.numbers[index]) {
                return false;
            }
        }
        return true;
    }

    public boolean isNotEqualTo(HugeInteger other) {

        return !this.isEqualTo(other);
    }

    public boolean isGreaterThan(HugeInteger other) {
        for (int index = 0; index < MAX_NUMBER_OF_DIGITS; index++) {
            if (this.numbers[index] > other.numbers[index]) return true;
            if (this.numbers[index] < other.numbers[index]) return false;
        }
        return false;
    }


    public boolean isLessThan(HugeInteger other) {
        for (int index = 0; index < MAX_NUMBER_OF_DIGITS; index++) {
            if (this.numbers[index] < other.numbers[index]) return true;
            if (this.numbers[index] > other.numbers[index]) return false;
        }
        return false;
    }

    public boolean isGreaterThanOrEqualsTo(HugeInteger other) {
        return this.isGreaterThan(other) || this.isEqualTo(other);
    }

    public boolean isLessThanOrEqualsTo(HugeInteger other) {

        return this.isLessThan(other) || this.isEqualTo(other);
    }

    public String toString(int [] numbers){

        String result ="[";

        for(int count =0; count < numbers.length; count++){
            result +=String.valueOf(numbers[count]);
            if (count < numbers.length-1){
                result +=", ";
            }
        }

        result +="]";
        return result;
    }
}
