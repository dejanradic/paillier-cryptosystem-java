import java.math.BigInteger;

public class KeyPair {
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public KeyPair(BigInteger lambda, BigInteger n, BigInteger g){
        this.privateKey = new PrivateKey(lambda);
        this.publicKey = new PublicKey(n, g);
    }

    public KeyPair(PrivateKey priv, PublicKey pub){
        this.privateKey = priv;
        this.publicKey = pub;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public String toString() {
        BigInteger n = this.publicKey.getN();
        BigInteger g = this.publicKey.getG();
        BigInteger lambda = this.privateKey.getLambda();
        return "n="+n+", g="+g+", lambda="+lambda;
    }

}