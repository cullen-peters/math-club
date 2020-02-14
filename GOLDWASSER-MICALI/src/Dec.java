import java.math.BigInteger;

public class Dec {
    public static void main(String[] args) {
        BigInteger p = new BigInteger(args[0]);
        BigInteger q = new BigInteger(args[1]);
        BigInteger c = new BigInteger(args[2]);

        BigInteger jp = jacobiSymbol(c, p);
        BigInteger jq = jacobiSymbol(c, q);
        BigInteger m;
        if ((jp.equals(BigInteger.ONE)) && (jq.equals(BigInteger.ONE)))
            m = BigInteger.ZERO;
        else
            m = BigInteger.ONE;
        System.out.println(m);
    }
    public static BigInteger jacobiSymbol(BigInteger a, BigInteger N) {
        BigInteger b = a.mod(N);
        BigInteger c = N;
        BigInteger s = BigInteger.ONE;
        BigInteger THREE = BigInteger.valueOf(3);
        BigInteger FOUR = BigInteger.valueOf(4);
        BigInteger FIVE = BigInteger.valueOf(5);
        BigInteger EIGHT = BigInteger.valueOf(8);

        while (b.compareTo(BigInteger.TWO) >= 0) {
            while ((b.mod(FOUR)).equals(BigInteger.ZERO)) {
                b = b.divide(FOUR);
            }
            if (b.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                if ((c.mod(EIGHT).equals(THREE)) || (c.mod(EIGHT).equals(FIVE)))
                    s = s.negate();
                b = b.divide(BigInteger.TWO);
            }
            if (b.equals(BigInteger.ONE))
                break;
            if (((b.mod(FOUR)).equals(c.mod(FOUR))) && ((b.mod(FOUR)).equals(THREE))) {
                s = s.negate();
            }
            BigInteger temp = b;
            b = c.mod(b);
            c = temp;
        }
        return s.multiply(b);
    }
}