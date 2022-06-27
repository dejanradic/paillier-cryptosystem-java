import java.math.BigInteger;

public class PrivateKey {
    private BigInteger lambda;
    public PrivateKey(BigInteger lmbd) {
        this.lambda = lmbd;
    }
    public void setLambda(BigInteger lmbd) {
        this.lambda = lmbd;
    }
    public BigInteger getLambda() {
        return lambda;
    }
}