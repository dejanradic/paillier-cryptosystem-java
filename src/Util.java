import java.math.BigInteger;

public class Util {

    // return (x-1)/n
    public static BigInteger func(BigInteger x, BigInteger n) {
        return x.subtract(BigInteger.ONE).divide(n);
    }

    public static BigInteger orderDivisionCheck(BigInteger n, BigInteger g, BigInteger lambda) {
        try {
            BigInteger k = g.modPow(lambda, n.multiply(n));
            BigInteger t = func(k, n);
            BigInteger mi = t.modInverse(n);
            return mi;
        } catch (ArithmeticException ex) {
            return null;
        }
    }

}