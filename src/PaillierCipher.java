import java.math.BigInteger;
import java.util.Random;

public class PaillierCipher {

    public static BigInteger encrypt(PublicKey pub, BigInteger message) {
        if (message.compareTo(BigInteger.ZERO) < 0)
            throw new IllegalStateException(String.format("Message %s should be bigger or equal than zero.", message));

        BigInteger n = pub.getN();
        if (message.compareTo(n) >= 0)
            throw new IllegalStateException(String.format("Message %s should be lower than %s.", message, n));

        Random rand = new Random();
        BigInteger g = pub.getG();

        // TODO: Fix numBits to read from single location
        BigInteger r = new BigInteger(512, rand);

        BigInteger n_sqr = n.multiply(n);
        BigInteger a = g.modPow(message, n_sqr);
        BigInteger b = r.modPow(n, n_sqr);
        BigInteger c = a.multiply(b).mod(n_sqr);
        return c;
    }

    public static BigInteger decrypt(KeyPair kp, BigInteger c){
        //0<c<n*n check
        BigInteger n = kp.getPublicKey().getN();
        BigInteger n_sqr = n.multiply(n);

        if (c.compareTo(BigInteger.ZERO) <= 0)
            throw new IllegalStateException(String.format("Cipher %s should be bigger than zero.", c));

        if (c.compareTo(n_sqr) >= 0)
            throw new IllegalStateException(String.format("Cipher %s should be lower than (n^2) %s.", c, n_sqr));

        BigInteger g = kp.getPublicKey().getG();
        BigInteger lambda = kp.getPrivateKey().getLambda();
        BigInteger mi = Util.orderDivisionCheck(n, g, lambda);

        BigInteger k = c.modPow(lambda, n_sqr);
        BigInteger f = Util.func(k, n).multiply(mi);
        BigInteger m = f.mod(n);
        return m;
    }

    public static BigInteger addition(BigInteger a, BigInteger b, PublicKey pubKey) {
        BigInteger n = pubKey.getN();
        BigInteger n_sqr = n.multiply(n);
        return a.multiply(b).mod(n_sqr);
    }

    public static BigInteger multiplication(BigInteger a, int b, PublicKey pubKey) {
        BigInteger n = pubKey.getN();
        BigInteger n_sqr = n.multiply(n);
        return a.pow(b).mod(n_sqr);
    }

}