package examscore;

	import java.io.FileWriter;
	import java.io.IOException;

	public class StudentLogger {

	    private final String filePath;

	    public StudentLogger(String filePath) {
	        this.filePath = filePath;
	    }

	    public synchronized void logStudent(Students student) {
	        try (FileWriter writer = new FileWriter(filePath, true)) { 
	            writer.write(student.toCSV() + "\n");
	            System.out.println("Written by " + Thread.currentThread().getName() + ": " + student.toCSV());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


