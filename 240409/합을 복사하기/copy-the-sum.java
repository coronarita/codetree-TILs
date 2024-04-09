public class Main {
    public static void main(String[] args) {
        int a=1, b=2, c=3;
        int tot = a+b+c;
        a = b = c = tot;
        System.out.println(a + " " + b + " " + c);
    }
}