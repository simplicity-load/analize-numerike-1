public class fixed_point {
    public static void main(String[] args) {
        System.out.println(point_fixed(0,0.001, 10));
    }

    public static double point_fixed(double in, double tol, int iter) throws NumberFormatException {
        int i = 1;
        double p0 = in;
        while (i <= iter) {
            double p = g(p0);
            if (Math.abs(p-p0) < tol) {
                System.out.println("iters:"+i);
                return p;
            }
            p0 = p;
            i++;
        }
        throw new NumberFormatException("Max number of iterations reached");
    }
    private static double g(double x) {
        return (x*x-1)/3;
    }
}
