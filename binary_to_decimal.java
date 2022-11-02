/** Kthejmë një numër binar në numër decimal 
  */
public class binary_to_decimal {
    public static void main(String[] args) {
        System.out.println("Numri i formuar " + b_t_d(new int[] {}, new int[] {1,1,0,0,0,1,1}));
    }
    //Vargu `a` është vargu i numrave binarë para pikës, ndërsa vargu `b` është vargu i atyre pas pikës.
    public static double b_t_d (int[] a, int[] b) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * Math.pow(2, a.length-i-1);
        }
        for (int j = 0; j < b.length; j++) {
            sum += b[j] * Math.pow(2, -j-1);
        }
        return sum;
    }
}
