import java.io.*;

public class Worm {
    public static void main(String[] args) throws IOException {
        int replicationCount = args.length > 0 ? Integer.parseInt(args[0]) : 5;

        if (replicationCount > 0) {
            String newFileName = "Worm" + replicationCount + ".java";
            String newDirectoryName = "src/dir" + replicationCount;
            File newDir = new File(newDirectoryName);
            if (!newDir.exists()) {
                newDir.mkdir();
            }

            File newFile = new File(newDir, newFileName);
            try (BufferedReader reader = new BufferedReader(new FileReader("src/Worm.java"));
                 PrintWriter writer = new PrintWriter(new FileWriter(newFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    writer.println(line);
                }
            }

            // Update the replication count for the next iteration
            String newArgs = String.valueOf(replicationCount - 1);

            // Compile the new file
            Runtime.getRuntime().exec("javac " + "src/dir" + replicationCount + "/" + newFileName);

            // Execute the new file
            Runtime.getRuntime().exec("java " + "src/dir" + replicationCount + "/" + newFileName);
        }
    }
}
