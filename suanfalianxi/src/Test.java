public class Test {
    public static void main(String[] args) {
        double num = 3.1415926;
        String re = String.format("%.3f",num);
        double res = Math.round(num * 1000) / 1000.0;
        System.out.println(re);
    }
}
