public class bisection {
    public static void main(String[] args) {
        System.out.println(bisect(-3,2.5, Math.pow(10,-3), 100));
        System.out.println(bisect(-2.5,3, Math.pow(10,-3), 100));
        System.out.println(bisect(-1.75,1.5, Math.pow(10,-3), 100));
        System.out.println(bisect(-1.5,1.75, Math.pow(10,-3), 100));
    }

    public static double bisect(double a, double b, double tol,int max_iteration) throws NumberFormatException {
        int i = 1;
        double FA = f(a);
        while (i <= max_iteration) {
            double p = a + (b-a)/2;
            double FP = f(p);
            if (FP == 0 || Math.abs(b-a)/2 < tol) {
                System.out.println("i: "+i);
                return p;
            }
            ++i;
            if (FA*FP > 0) {
                a = p;
                FA = FP;
            } else {
                b = p;
            }
        }
        throw new NumberFormatException("Max number of iterations reached");
    }

    private static double f(double x) {
        //return 3*(x+1)*(x-1.0/2.0)*(x-1);
        return (x+2)*(x+1)*x*Math.pow(x-1,3)*(x-2);
    }
}