import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Worm {

    int numOfTimes;
    static String[] sourceArray;

    public static void main(String[] args) throws IOException, InterruptedException {

        String currentFileName = "src/Worm.java"; // Adjust the path if necessary
        List<String> sourceCodeList = readSourceCode(currentFileName);
        sourceArray = sourceCodeList.toArray(new String[0]);

        Worm worm = new Worm();
        worm.numOfTimes = args.length > 0 ? Integer.parseInt(args[0]) : 5;

        if (worm.numOfTimes > 0) {
            String className = "Worm" + worm.numOfTimes;
            String newFileName = className + ".java";
            String newDirectoryName = "src/dir" + worm.numOfTimes;
            File newDir = new File(newDirectoryName);
            if (!newDir.exists()) {
                newDir.mkdirs();
            }

            File newFile = new File(newDir, newFileName);
            try (PrintWriter writer = new PrintWriter(new FileWriter(newFile))) {
                for (String line : sourceArray) {
                    // Replace class name in each line
                    line = line.replace("public class Worm", "public class " + className);
                    writer.println(line);
                }
            }

            // Compile the new file
            Process compileProcess = Runtime.getRuntime().exec("javac " + newFile.getPath());
            compileProcess.waitFor();

            // Execute the new file
            Process execProcess = Runtime.getRuntime().exec("java -cp " + newDirectoryName + " " + className + " " + (worm.numOfTimes - 1));
            execProcess.waitFor();
        }
    }

    private static List<String> readSourceCode(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

}
