package utils.tools;

import java.io.*;
import java.util.Scanner;

public class FileTools {
    public static String readInput(InputStream inputStream) {
        Scanner scan = new Scanner(inputStream).useDelimiter("\\A");

        return (scan.hasNext() ? scan.next() : "");
    }
    public static String readFile(String fileName) {
        File file = new File(fileName);

        if (!file.exists()) {
            ClassLoader classLoader = FileTools.class.getClassLoader();
            return FileTools.readInput(classLoader.getResourceAsStream(fileName));
        } else {
            return FileTools.parseFile(file);
        }
    }

    public static String parseFile(File file) {
        StringBuilder content = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void writeInFile(String fileName, String value) {
        fileName = "C:\\Users\\keandres\\Documents\\" + fileName;
        File file = new File(fileName);
        try {
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(value);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
