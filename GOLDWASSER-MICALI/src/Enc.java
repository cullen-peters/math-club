import java.math.BigInteger;
import java.security.SecureRandom;

public class Enc {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        BigInteger z = new BigInteger(args[0]);
        BigInteger N = new BigInteger(args[1]);
        BigInteger m = new BigInteger(args[2]);

        BigInteger x = uniformX(N, random);
        BigInteger c = (z.modPow(m, N).multiply(x.modPow(BigInteger.TWO, N))).mod(N);
        System.out.println(c.toString());
    }

    public static BigInteger uniformX(BigInteger N, SecureRandom random) {
        BigInteger x = BigInteger.ZERO;
        do {
            x = new BigInteger(N.bitLength(), random);
        } while ((x.compareTo(BigInteger.ZERO) == -1) || (x.compareTo(N) == 1));
        return x;
    }
}