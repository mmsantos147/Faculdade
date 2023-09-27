import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("#add > When both numbers are positives > Return a positive Number")
    void addwhenbothNumbersArePositivesReturnApositiveNumber(){
        int result = calculator.add(3,4);

        Assertions.assertEquals(7, result);
    }

    @Test
    @DisplayName("#add > When both numbers are negatives > Return a negative number")
    void addwhenbothNumbersAreNegativesReturnAnegativeNumber(){
        int result = calculator.add(-3,-4);

        Assertions.assertEquals(-7, result);
    }

    @Test
    @DisplayName("#add > when a number is positive and another is negative > Return a positive number")
    void addwhenANumberisPositiveAndAnotherisNegativeReturnAPositiveNumber(){
        int result = calculator.add(-3,4);

        Assertions.assertEquals(1, result);
    }

    @Test
    @DisplayName("#add > when a number is positive and another is negative > return a negative number")
    void addwhenANumberisPositiveAndAnotherisNegativeReturnANegativeNumber(){
        int result = calculator.add(3,-4);

        Assertions.assertEquals(-1, result);
    }

    @Test
    @DisplayName("#add > when a number is zero > return number")
    void addwhenANumberisZeroReturnNumber(){
        int result = calculator.add(5,0);
        int result2 = calculator.add(0,5);
        int result3 = calculator.add(-5,0);
        int result4 = calculator.add(0,-5);

        Assertions.assertAll(
                () -> Assertions.assertEquals(5, result),
                () -> Assertions.assertEquals(5, result2),
                () -> Assertions.assertEquals(-5, result3),
                () -> Assertions.assertEquals(-5, result4)
        );

    }
    @Test
    @DisplayName("#add > when both numbers are zero > return zero")
    void addwhenbothNumbersareZeroReturnZero() {
        int result = calculator.add(0, 0);
        Assertions.assertEquals(0,result);
    }

    @Test
    @DisplayName("#sub > when the higher number is positive and is on the left > return positive")
    void subHigherNumberIsPositiveAndIsOnTheLeft() {
        int result = calculator.sub(5, 3);
        int result2 = calculator.sub(5, -3);
        Assertions.assertAll(
                ()->Assertions.assertEquals(2,result),
                ()->Assertions.assertEquals(8,result2)
        );
    }

    @Test
    @DisplayName("#sub > when the higher number is positive and is on the right > return Negative")
    void subHigherNumberIsPositiveAndIsOnTheRight() {
        int result = calculator.sub(3, 5);
        int result2 = calculator.sub(-3, 5);
        Assertions.assertAll(
                () -> Assertions.assertEquals(-2,result),
                () -> Assertions.assertEquals(-8,result2)
        );
    }

    @Test
    @DisplayName("#sub > when the higher number is negative and is on the left > return negative")
    void subHigherNumberIsNegativeAndIsOnTheLeft() {
        int result = calculator.sub(-5, 3);
        int result2 = calculator.sub(-5, -3);
        Assertions.assertAll(
                ()->Assertions.assertEquals(-8,result),
                ()->Assertions.assertEquals(-2,result2)
        );
    }

    @Test
    @DisplayName("#sub > when the higher number is negative and is on the right > return Positive")
    void subHigherNumberIsNegativeAndIsOnTheRight() {
        int result = calculator.sub(3, -5);
        int result2 = calculator.sub(-3, -5);
        Assertions.assertAll(
                () -> Assertions.assertEquals(8,result),
                () -> Assertions.assertEquals(2,result2)
        );
    }

    @Test
    @DisplayName("#sub > when both numbers are negative > return negative")
    void subBothNegativeNumbers() {
        int result = calculator.sub(-5, -3);
        Assertions.assertEquals(-2,result);
    }

    @Test
    @DisplayName("#sub > when one numbers is zero > return number")
    void subWhenOneNumberIsZeroReturnNumber() {
        int result = calculator.sub(5, 0);
        int result2 = calculator.sub(0, 5);
        int result3 = calculator.sub(-5,0);
        int result4 = calculator.sub(0, -5);
        Assertions.assertAll(
                ()->Assertions.assertEquals(5, result),
                ()->Assertions.assertEquals(-5, result2),
                ()->Assertions.assertEquals(-5, result3),
                ()->Assertions.assertEquals(5, result4)
        );
    }

    @Test
    @DisplayName("#sub > when both numbers are zero > return zero")
    void subWhenBothNumbersAreZeroReturnZero() {
        int result = calculator.sub(0, 0);
        Assertions.assertEquals(0,result);
    }

    @Test
    @DisplayName("#mult > When one number is zero > return zero")
    void multZero() {
        int result = calculator.mult(5,0);
        int result2 = calculator.mult(0,5);
        int result3 = calculator.mult(-5,0);
        int result4 = calculator.mult(0,-5);
        int result5 = calculator.mult(0,0);

        Assertions.assertAll(
                () -> Assertions.assertEquals(0, result),
                () -> Assertions.assertEquals(0, result2),
                () -> Assertions.assertEquals(0, result3),
                () -> Assertions.assertEquals(0, result4),
                () -> Assertions.assertEquals(0, result5)
        );
    }

    @Test
    @DisplayName("#mult > When one number is negative > return negative")
    void multOneNumberNegative() {
        int result = calculator.mult(5,-1);
        int result2 = calculator.mult(-5,1);

        Assertions.assertAll(
                () -> Assertions.assertEquals(-5, result),
                () -> Assertions.assertEquals(-5, result2)
        );
    }

    @Test
    @DisplayName("#mult > When both numbers are positive > return positive")
    void multBothPositive() {
        int result = calculator.mult(5,1);
        Assertions.assertEquals(5, result);
    }

    @Test
    @DisplayName("#mult > When both numbers are negative > return positive")
    void multBothNegative() {
        int result = calculator.mult(-5,-1);
        Assertions.assertEquals(5, result);
    }

    @Test
    @DisplayName("#divide > When the divider is zero > Throw an exception")
    void dividerZero() {
        Assertions.assertThrows(ArithmeticException.class,
                ()->calculator.divide(5, 0)
        );
    }

    @Test
    @DisplayName("#divide > When both numbers are positive > return positive number")
    void divideBothPositive() {
        float result = calculator.divide(5, 1);
        float result2 =  calculator.divide(3,2);
        Assertions.assertAll(
                ()->Assertions.assertEquals(5,result),
                ()->Assertions.assertEquals(1.5,result2)
        );

    }

    @Test
    @DisplayName("#divide > When the dividend is a negative number > return negative number")
    void dividendNegative() {
        float result = calculator.divide(-5, 1);
        float result2 =  calculator.divide(-3,2);
        Assertions.assertAll(
                ()->Assertions.assertEquals(-5,result),
                ()->Assertions.assertEquals(-1.5,result2)
        );

    }

    @Test
    @DisplayName("#divide > When the divider is a negative number > return negative number")
    void dividerNegative() {
        float result = calculator.divide(5, -1);
        float result2 =  calculator.divide(3,-2);
        Assertions.assertAll(
                ()->Assertions.assertEquals(-5,result),
                ()->Assertions.assertEquals(-1.5,result2)
        );            
    }

    @Test
    @DisplayName("#divide > When both numbers are negative > return positive number")
    void divideBothNegative() {
        float result = calculator.divide(-5, -1);
        float result2 =  calculator.divide(-3,-2);
        Assertions.assertAll(
                ()->Assertions.assertEquals(5,result),
                ()->Assertions.assertEquals(1.5,result2)
        );
    }
    }
