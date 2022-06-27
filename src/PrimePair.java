import java.math.BigInteger;

public class PrimePair {
    private BigInteger p,q;

    public PrimePair(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
    }

    public BigInteger getProduct() {
        return p.multiply(q);
    }

    public BigInteger getP() {
        return this.p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

}
