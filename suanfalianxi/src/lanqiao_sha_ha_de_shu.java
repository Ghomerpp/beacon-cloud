public class lanqiao_sha_ha_de_shu {
    public static void main(String[] args) {
        int m = 2023;
        int i = 1;
        while (m > 0){
            if (check(i++)){
                m--;
            }
        }
        System.out.println(i-1);
    }

    public static int fun(int n,int k){
        int sum = 0;
        while (n > 0){
            sum += n%k;
            n /= k;
        }
        return sum;
    }

    public static boolean check(int n){
        if (n % fun(n,2) == 0 && n % fun(n,8) == 0 && n % fun(n,10) == 0 && n % fun(n,16) == 0){
            return true;
        }else {
            return false;
        }
    }
}
