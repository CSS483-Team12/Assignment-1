import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Worm {
    int numOfTimes;
    String[] array = {
            "public class Worm2 {",
            "int numOfTimes",
            "String[] array ={",
            "};",
            "public static void main(String[] args){",
            "Worm worm = new Worm();",
            "char quote = 34;",
            "System.out.println(worm.array[0]);",
            "System.out.println(worm.array[1]+'='+ (worm.numOfTimes+1)+';');",
            "System.out.println(worm.array[2]);",
            "for (int i = 0; i < worm.array.length; i++) {",
            "System.out.println(quote+worm.array[i]+quote+',');",
            "}",
            "for (int i = 2; i <worm.array.length; i++) {",
            " System.out.println(worm.array[i]);",
            "}",
            "}",
            "}",
    };

    public static void main(String[] args) {
        Worm worm = new Worm();
        char quote = 34;
        if (worm.numOfTimes < 3) {
            try {

                PrintWriter myWriter = new PrintWriter("src/Worm2.java");
                myWriter.println(worm.array[0]);
                myWriter.println(worm.array[1] + '=' + (worm.numOfTimes + 1) + ';');
                myWriter.println(worm.array[2]);
                for (int i = 0; i < worm.array.length; i++) {
                    myWriter.println(quote + worm.array[i] + quote + ',');
                }
                for (int i = 3; i < worm.array.length; i++) {
                    myWriter.println(worm.array[i]);
                }
                myWriter.close();
                Process i = Runtime.getRuntime().exec("javac " + "Worm2" + ".java");
                i.waitFor();
                i = Runtime.getRuntime().exec("java " + "Worm2");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}