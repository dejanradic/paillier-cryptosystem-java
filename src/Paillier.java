import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;

public class Paillier {

    public static void main(String []args) {
        System.out.println("Paillier");

        KeyPair kp = new KeyPairGenerator().generate();
        System.out.println(kp);

        BigInteger m = new BigInteger("123");
        System.out.println("\nmsg="+m);
        BigInteger crypt = PaillierCipher.encrypt(kp.getPublicKey(), m);
        System.out.println("crypt msg="+crypt);
        BigInteger msg = PaillierCipher.decrypt(kp, crypt);
        System.out.println("decrypt msg="+msg);
        System.out.println();

        BigInteger a = new BigInteger("40");
        BigInteger b = new BigInteger("141");
        BigInteger a_enc = PaillierCipher.encrypt(kp.getPublicKey(), a);
        System.out.println("a_enc="+a_enc);
        BigInteger b_enc = PaillierCipher.encrypt(kp.getPublicKey(), b);
        System.out.println("b_enc="+b_enc);
        BigInteger c_enc = PaillierCipher.addition(a_enc, b_enc, kp.getPublicKey()); //c=a+b
        System.out.println("c_enc="+c_enc);
        BigInteger c = PaillierCipher.decrypt(kp, c_enc);
        System.out.println("decrypt c="+c); //40+141=181
        System.out.println();

        BigInteger k = new BigInteger("7");
        int t = 5;
        BigInteger k_enc = PaillierCipher.encrypt(kp.getPublicKey(), k);
        System.out.println("k_enc=" + k_enc);
        // r = k*t
        BigInteger r_enc = PaillierCipher.multiplication(k_enc, t, kp.getPublicKey());
        System.out.println("r_enc=" + r_enc);
        BigInteger r = PaillierCipher.decrypt(kp, r_enc);
        System.out.println("r="+r); //7*5=35

    }

}



