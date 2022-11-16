public class table_of_convergence {
    public static void main(String[] args) {
        present_table_of_convergence(new int[] {5,10,50,100,1000,5000});
    }

    public static void present_table_of_convergence (int values[]) {
        System.out.println("   n |      1/n |     1/n2 |     1/n3 |     1/n4 |");
        for (int value: values) {
            System.out.printf("%4d |", value);
            for (int i = 1; i <= 4; i++) {
//                System.out.printf(" %.13f ", Math.pow(value, -i));
                System.out.printf(" %8s |", "" + Math.pow(value, -i));
            }

            System.out.println();
        }
    }
}
