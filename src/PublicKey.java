import java.math.BigInteger;

public class PublicKey {
    private BigInteger n,g;
    public PublicKey(BigInteger n, BigInteger g) {
        this.n = n;
        this.g = g;
    }
    public void setN(BigInteger n) {
        this.n = n;
    }
    public BigInteger getN() {
        return n;
    }
    public void setG(BigInteger g) {
        this.g = g;
    }
    public BigInteger getG() {
        return g;
    }
}