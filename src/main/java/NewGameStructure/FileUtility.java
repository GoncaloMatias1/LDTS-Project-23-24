package NewGameStructure;

import java.io.*;
import java.util.*;

public class FileUtility {
    private static final String FILE_NAME = "data/scores.txt";

    static {
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
    }

    public static void writeScoreToFile(int score) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(score);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static int getHighScore() {
        int highScore = 0;
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextInt()) {
                int score = scanner.nextInt();
                if (score > highScore) {
                    highScore = score;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return highScore;
    }
}


