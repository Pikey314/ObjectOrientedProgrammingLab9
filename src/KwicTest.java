import prKWIC.Kwic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class KwicTest {

    public static void main(String[] args) {
        Kwic kwic = new Kwic();
        try {
            kwic.noSignificantWords("noSignificant.txt");
            kwic.createIndex("statements.txt");
            kwic.printIndex("output.txt");
            PrintWriter pw = new PrintWriter(System.out, true);
            kwic.printIndex(pw);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
