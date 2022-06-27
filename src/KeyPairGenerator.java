import java.math.BigInteger;
import java.util.Random;

public class KeyPairGenerator {

    private int bitLength = 512;

    public KeyPairGenerator() {

    }

    public KeyPairGenerator(int bitLength) {
        this.bitLength = bitLength;
    }

    // lcm(a,b)=a*b/gcd(a,b);
    private BigInteger lcm(BigInteger a, BigInteger b) {
        BigInteger gcd = a.gcd(b);
        return a.multiply(b).divide(gcd);

    }

    private PrimePair generatePrimePair() {
        Random r = new Random();
        BigInteger p, q, testValue;

        do {
           p = BigInteger.probablePrime(bitLength, r);
           q = BigInteger.probablePrime(bitLength, r);
           BigInteger n = p.multiply(q);
           BigInteger g = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
           testValue = n.gcd(g);
        } while (testValue == BigInteger.ONE);
        
        return new PrimePair(p, q);
    }

    public KeyPair generate() {

        Random r = new Random();
        PrimePair pair = generatePrimePair();
        BigInteger p = pair.getP(),
                   q = pair.getQ(),
                   n = pair.getProduct(),
                   g, lambda, mi = null;
        do {
            lambda = lcm(p.subtract(BigInteger.ONE), q.subtract(BigInteger.ONE)); //private key
            g = new BigInteger(bitLength, r);
            mi = Util.orderDivisionCheck(n, g, lambda);
        } while (mi == null);

        return new KeyPair(lambda, n, g);

    }
}