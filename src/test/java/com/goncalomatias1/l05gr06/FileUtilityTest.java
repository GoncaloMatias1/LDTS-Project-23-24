package com.goncalomatias1.l05gr06;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilityTest {

    private static final String FILE_NAME = "data/scores.txt";
    private static final Path FILE_PATH = Paths.get(FILE_NAME);

    @BeforeEach
    void setUp() throws IOException {
        Files.createDirectories(FILE_PATH.getParent());
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(FILE_PATH);
    }

    @Test
    void testWriteScoreToFile() throws IOException {
        int score = 100;
        FileUtility.writeScoreToFile(score);

        assertTrue(Files.exists(FILE_PATH));

        int readScore = Files.readAllLines(FILE_PATH).stream()
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(-1);

        assertEquals(score, readScore);
    }

    @Test
    void testGetHighScoreWithNoFile() {
        assertDoesNotThrow(() -> Files.deleteIfExists(FILE_PATH));

        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));

        int highScore = FileUtility.getHighScore();

        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err)));

        assertEquals(0, highScore);
        assertTrue(errContent.toString().contains("File not found"));
    }

    @Test
    void testGetHighScoreWithExistingFile() throws IOException {
        List<String> scores = List.of("10", "20", "30", "40", "50");
        Files.write(FILE_PATH, scores);

        int highScore = FileUtility.getHighScore();

        assertEquals(50, highScore);
    }
}
