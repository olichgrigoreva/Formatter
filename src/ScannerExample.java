import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        Locale l = Locale.US;
        //calc(new Scanner((System.in)));
        try (Scanner sc = new Scanner(new File("scanner.txt")).useLocale(Locale.US)){
            calc(sc.useLocale(Locale.US));
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void calc(Scanner sc) {
        System.out.println("Введите число а: ");
        float a = sc.nextFloat();
        System.out.println("Введите число b: ");
        float b = sc.nextFloat();
        System.out.printf(Locale.US,"%f * %f = %f\n", a, b, a * b);
    }

}
