import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class PackUnpackExample {
    public static void main(String[] args) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File("data.zip")))) { //cоздание архива
            ZipEntry ze = new ZipEntry("helloworld.txt");
            zos.putNextEntry(ze);
            PrintWriter pw = new PrintWriter(zos); //для работы как с консолью
            pw.printf("%s %S!", "hello", "world"); //как форматированный вывод в консоль
            pw.flush();
            zos.closeEntry(); //обязательно закрыть!!!

            //разархивация
//            ze = new ZipEntry("bye.txt");
//            zos.putNextEntry(ze);
//            pw.printf("bye bye!");
//            pw.flush();
//            zos.closeEntry();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //деархивация
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(new File("data.zip")))) {
            ZipEntry ze;
            while ((ze = zis.getNextEntry()) != null) { //получаем файлы из архива
                System.out.printf("Содержимое файла [%s] из архива:\n", ze.getName());
                LineNumberReader lnr = new LineNumberReader(new InputStreamReader(zis)); //для каждого файла создаем ридер
                String line;
                while ((line = lnr.readLine()) != null) { //читаем построчно
                    System.out.println(line); //выводим строку на консоль
                }
                // zis закрывать не надо, т.к. он в try-catch-resourse
            }
        } catch (Exception ex) {

        }
    }
}
