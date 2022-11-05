public class Round {
    public static void main(String[] args) {
        Round k = new Round();
        // 1.
        double d1 = 7.82495;
        int i = 5;
        System.out.print(d1);
        while (i>0) {
            d1 = k.round(d1,i);
            System.out.print(" => " + d1);
            i--;
        }
        System.out.println();
        // 2.
        double d2 = 9.567526;
        int j = 6;
        System.out.print(d2);
        while (j>0) {
            d2 = k.round(d2,j);
            System.out.print(" => " + d2);
            j--;
        }
        
    }

    public double round(double x, int n){
        String s = "";
        if(x%1==0)
            s += (int)x;
        else
            s += x;

        String[] temp = s.split("");
        if(s.contains(".")){
            // Pozita e pikes (".")
            int i = 0;
            while (i < temp.length) {
                if(temp[i].equals("."))
                    break;
                i++;
            }

            int[] arr = new int[temp.length-1];
            for (int j = 0, k = 0; j < arr.length; j++, k++) {
                if(j==i)
                    k++;
                arr[j] = Integer.valueOf(temp[k]);
            }

            int[] r = doRound(arr,n);
            if(arr[0] == 9 && arr[0] != r[0])
                i++;
            String result = "";
            for (int j = 0; j < r.length; j++) {
                if(i==j)
                    result += ".";
                result += r[j];
            }

            return Double.valueOf(result);
        }

        int[] arr = new int[temp.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(temp[i]);
        }

        int[] r = doRound(arr,n);
        String result = "";
        for (int j = 0; j < r.length; j++) {
            result += r[j];
        }
        return Double.valueOf(result);
    }

    public int[] doRound(int[] arr, int n){
        // z - numri i zerove ne fillim.
        int z = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0)
                break;
            z++;
        }
        if(n+z >= arr.length){
            return arr;
        }

        if(arr[n+z]<5){
            int[] r = new int[n+z];
            for (int i = 0; i < r.length; i++)
                r[i] = arr[i];

            return r;
        }
        
        int[] temp = new int[arr.length];
        for (int i = 0; i < temp.length; i++)
            temp[i] = arr[i];
        
        boolean t = false;
        if (arr[n+z-1]==9) {
            int i = n+z-1;
            while(temp[i]==9){
                if(i==0){
                    if(temp[0] == 9){
                        int[] r = new int[temp.length+1];
                        r[0] = 1;
                        return r;
                    }
                    int[] r = new int[temp.length];
                    r[0] = arr[0]+1;
                    return r;
                }
                temp[i] = 0;
                if(temp[i-1]!=9){
                    temp[i-1] += 1;
                    if(i-1==0)
                        t = true;
                    break;
                }
                i--;
            }
            if(t){
                int[] r = new int[temp.length];
                for (int j = 0; j < n+z ; j++)
                r[j] = temp[j];
                return r;
            }
            int[] r = new int[n+z];
            for (int j = 0; j < r.length; j++)
                r[j] = temp[j];
            return r;
        }

        int[] r = new int[n+z];
        for (int i = 0; i < r.length-1; i++) {
            r[i] = temp[i];
        }
        r[r.length-1] = temp[r.length-1]+1;
        return r;
    }
}
