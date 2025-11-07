package examscore;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;
public class Scorelog {

    void testStudentLogger() throws Exception {
        String filePath = "test_students.csv";
        File file = new File(filePath);
        if (file.exists()) file.delete();

        StudentLogger logger = new StudentLogger(filePath);

        Students s1 = new Students("Pallavi", 101, 85);
        Students s2 = new Students("Tharnath", 102, 92);
        Students s3 = new Students("Kashish", 103, 78);

        // Log students (single-thread test)
        logger.logStudent(s1);
        logger.logStudent(s2);
        logger.logStudent(s3);
      
        // Check if file is created
        assertTrue(file.exists(), "File should be created");

        // Read lines from file
        var lines = Files.readAllLines(file.toPath());

        // Check count
        assertEquals(3, lines.size(), "There should be 3 records");

        // Simple content check
        assertTrue(lines.get(0).contains("Pallavi"));
        assertTrue(lines.get(1).contains("Tharnath"));
        assertTrue(lines.get(2).contains("Kashish"));

        file.delete(); // cleanup
    }
}
