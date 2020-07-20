import java.util.Formatter;
import java.util.Locale;

public class ProgramLocale {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);
        f.format(Locale.US, "%,10.3f\n", 10000000.10); //вывод для английской локали

        f.format(Locale.forLanguageTag("ru"), "%,10.3f\n", 10000000.10); //вывод для русской локали
        //запятая и переменная локали образуют формат вывода
        //(запятая просто указывает на разделитель числа по разрядам, но для каждой странцы он свой)

        String s = String.format("%03d", 123);

        System.out.printf(Locale.US, "%,10.3f\n", 10000000.10);
        Locale.getAvailableLocales();
    }
}
