import java.io.File;
import java.io.FileWriter;
import java.util.Formatter;

public class Program {
    public Program() {
        StringBuilder sb = new StringBuilder();
        format(new Formatter(sb));
        System.out.println(sb.toString());
        try (Formatter fileFormatter = new Formatter(new FileWriter(new File("data.txt")))) {
            format(fileFormatter);
        } catch (Exception ex) {

        }
    }

    private void format(Formatter formatter) {
        String s = "Привет!";
        formatter.format("|%-10s|%10S|\n", s, s);
        byte b = 1;
        int i = 2;
        long l = 1000000;
        short sh = -100;
        formatter.format("|%-10d|%10d|%10d|%10d|\n", b, i, l, sh);
        formatter.format("|%010d|\n", Integer.parseInt("100"));
        formatter.format("|%10d|\n", Integer.parseInt("100"));
        formatter.format("%10s\n", new Data());
        double d = 1.000000001234;
        float f = 10000000000.123456f;
        formatter.format("%5.2f, %5.3f\n", f, d);
    }


    public static void main(String[] args) {
        new Program();
    }

    class Data {
        @Override
        public String toString() {
            return "Data class";
        }
    }
}
