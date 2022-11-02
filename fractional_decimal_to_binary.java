import java.util.Arrays;
/** Kthimi i numrave dhjetorë në numra binarë me përafrim dhe gjetja e gabimeve gjatë përafrimeve
  */
public class fractional_decimal_to_binary {
    public static void main(String[] args) {
        double vlera = 0.4;
        int shifra = 5;
        int[] perafrimi = d_t_b(vlera, shifra);
        System.out.println();
        double perafrimi_ne_decimal = binary_to_decimal.b_t_d(new int[] {}, perafrimi);
        double gabimi_absolut = Math.abs(vlera - perafrimi_ne_decimal);
        double gabimi_relativ = Math.abs(gabimi_absolut/vlera);
        System.out.println( "Vlera e sakte: " + vlera +
                            "\nVlera e perafruar: " + "0." + Arrays.toString(perafrimi).replaceAll("\\[|\\]|,|\\s", "") +
                            "\nGabimi absolut: " + gabimi_absolut +
                            "\nGabimi relativ: " + gabimi_relativ);
    }
    // Kthimi vetëm i numrave thyesorë në numra binarë
    private static int[] d_t_b (double a, int b) {
        int[] return_array = new int[b];
        double d = a;
        for (int i = 1; i < b+1; i++) {
            d = d * 2;
            int c = (int) d;
            if (c == 1)
                d -= 1;
            return_array[i-1] = c;
        }
        return return_array;
    }
}
