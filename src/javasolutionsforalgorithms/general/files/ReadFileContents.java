package javasolutionsforalgorithms.general.files;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFileContents {

    public String fileContents() {
        String path = "C:\\Users\\MikeHenry\\JavaProjects\\LeetCoding\\src\\javasolutionsforalgorithms\\general\\files\\testfiles\\read_file_sample.txt";
        StringBuilder sb = new StringBuilder();
        File myFile = new File(path);
        try {
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                sb.append(reader.nextLine());
                sb.append("\n");
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFileContents.class.getName()).log(Level.SEVERE, "File not found {0}", ex.getMessage());
        }

        return sb.toString();
    }

    public String fileContentsBufferedReader() {
        String path = "C:\\Users\\MikeHenry\\JavaProjects\\LeetCoding\\src\\javasolutionsforalgorithms\\general\\files\\testfiles\\read_file_sample.txt";
        StringBuilder sb = new StringBuilder();
        File myFile = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(myFile));

            String str;

            while ((str = br.readLine()) != null) {
                sb.append(str);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFileContents.class.getName()).log(Level.SEVERE, "File not found {0}", ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReadFileContents readFileContents = new ReadFileContents();
        String contents = readFileContents.fileContents();
        System.out.println(contents);
    }
}
