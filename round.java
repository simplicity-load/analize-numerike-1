import java.util.ArrayList;
import java.util.Arrays;

/** Rrumbullakimi i numrave dhjetorë pozitiv
  */
public class round {

    public static void main(String[] args) {
        System.out.println("Numri 0.9999 ne 3 shifra: " + fnRrumbullakso(0.9999,3));
        System.out.println("Numri 9665.3667 ne 1 shifra: " + fnRrumbullakso(9665.3667,1));
        System.out.println("Numri 235.36 ne 4 shifra: " + fnRrumbullakso(235.36,4));
    }

    public static double fnRrumbullakso(double numri, int shifra) {
        int check_for_float = (int) numri;
        boolean isfloat = numri - check_for_float != 0;

        // "123.456" -> ["1", "2", "3", ".", "4", "5", "6"]
        String kopja = numri+"";
        ArrayList<String> sarr = new ArrayList<String>(Arrays.asList(kopja.split("")));

        // Gjetja e pozitës së pikës
        int point = 0;
        if (isfloat) {
            while (!sarr.get(point).equals(".")) {
                point++;
            }
        }

        // ["1", "2", "3", ".", "4", "5", "6"] -> [1, 2, 3, 4, 5, 6]
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (String k : sarr) {
            if (!k.equals(".")) {
                arr.add(Integer.valueOf(k));
            }
        }

        // Në këtë variabël ruajmë mbetjen pasi të kryejmë rrumbullakimin. P.sh [9, 9, 9] do të kemi mbetjen 1 dhe [0, 0, 0]
        int last = 0;
        // Fillojmë nga numri me më së paku rëndësi dmth numri i fundit në varg dhe ndalemi nëse kemi arritur deri te shifra e dëshiruar që dëshirojmë të kryejmë rrumbullakimin (i >= shifra)
        for (int i = arr.size()-1; i >= 0 && i >= shifra; i--) {
            // Rrumbullakimi
            if (arr.get(i) <= 4) {
                arr.set(i,0);
            } else if (arr.get(i) <= 9){
                arr.set(i,10);
            }
            // Balancojmë vargun, P.sh [1, 2, 3, 4, 5, 10] -> [1, 2, 3, 4, 6, 0]. Shiko metodën rebalance për më shumë detaje
            last = rebalance(arr, arr.size()-1);
        }
        // Nëse kemi mbetje shtoje në fillim të vargut
        if (last == 1) {
            arr.add(0,1);
        }
        // Nëse kemi mbetje dhe kemi shtuar mbetjen në fillim të vargut atëherë pika do të lëvizë për një numër më në të djathtë
        point += last;

        // Kthejmë vargun e int-ave në varg të stringjeve
        ArrayList<String> OutputString = new ArrayList<>();
        for (Integer k : arr) {
            OutputString.add(String.valueOf(k));
        }
        // Shtojmë pikën në pozitën e duhur
        OutputString.add(point, ".");

        // Kthejmë vargun e stringjeve në një string të vetëm, P.sh ["1", "2", "3", ".", ""]
        String listString = String.join("", OutputString);

        // Kthejmë stringun e mësipërm në Double dhe e kthejmë
        return Double.parseDouble(listString);
    }

    // Magji :D
    // [9, 9, 9, 9, 9, 9, 10]
    //                   <--
    // [9, 9, 9, 9, 9, 10, 0]
    //          -//-
    //  X--
    // [0, 0, 0, 0, 0, 0, 0]
    // Në këtë rast kthejmë mbetjen 1
    private static int rebalance(ArrayList<Integer> a, int i) {
        if (i == 0) {
            if (a.get(0) == 10) {
                a.set(0, 0);
                return 1;
            } else {
                return 0;
            }
        }
        if (a.get(i) == 10) {
            a.set(i, 0);
            a.set(i-1, a.get(i-1)+1);
        }
        return rebalance(a,i-1);
    }
}
