import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Worm /* WormClassMarker */ {

    int numOfTimes;
    static List<String> sourceCode;
    static {
        try {
            sourceCode = readSourceCode("Worm.java");
            for (int i = 0; i < sourceCode.size(); i++) {
                if (sourceCode.get(i).contains("public class Worm")) {
                    // Replace only the class name part
                    String modifiedLine = sourceCode.get(i).replace("Worm", "CLASS_NAME_PLACEHOLDER");
                    sourceCode.set(i, modifiedLine);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int numOfTimes = args.length > 0 ? Integer.parseInt(args[0]) : 5;

        if (numOfTimes > 0) {
            String className = "Worm" + numOfTimes;
            String newFileName = className + ".java";
            String newDirectoryName = "src/dir" + numOfTimes;
            File newDir = new File(newDirectoryName);
            if (!newDir.exists()) {
                newDir.mkdirs();
            }

            File newFile = new File(newDir, newFileName);
            List<String> sourceCode = readSourceCode("src/Worm.java"); // Assuming this method returns the source code of Worm.java

            try (PrintWriter writer = new PrintWriter(new FileWriter(newFile))) {
                for (String line : sourceCode) {
                    line = line.replace("CLASS_NAME_PLACEHOLDER", className);
                    writer.println(line);
                }
            }

            // Compile the new file
            Process compileProcess = Runtime.getRuntime().exec("javac " + newFile.getPath());
            compileProcess.waitFor(); // Wait for compilation to complete

            // Execute the new file with decremented numOfTimes
            Process execProcess = Runtime.getRuntime().exec("java -cp " + newDirectoryName + " " + className + " " + (numOfTimes - 1));
            execProcess.waitFor(); // Wait for execution to complete
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
