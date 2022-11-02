import java.util.Arrays;

/** Kthimi i numrave me pikë lëvizëse të reprezentuara në 64 bit në numra decimal
  */
public class floating_point_binary_to_decimal {
    public static void main(String[] args){
        int[] varg =   {1,
                        1,0,0,0,0,0,0,1,0,1,0,
                        1,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(bin_to_dec(varg));
    }
    private static double bin_to_dec(int[] a) {
        int sign = a[0];
        int[] b = Arrays.copyOfRange(a, 1, 12);
        int[] c = Arrays.copyOfRange(a, 12, 64);

        double imp = 0.0;
        for (int i = 0; i < b.length; i++) {
            imp += b[i] * Math.pow(2,b.length - 1 - i);
        }

        double floating = 0.0;
        for (int i = 0; i < c.length; i++) {
            floating += c[i] * Math.pow(2,-(i+1));
        }
        return Math.pow(-1, sign) * Math.pow(2, imp-1023)*(1+floating);
    }
}
