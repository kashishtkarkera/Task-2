package examscore;

public class Main {

	public static void main(String[] args) {
		        String filePath = "students.csv"; // file to store data
		        StudentLogger logger = new StudentLogger(filePath);

		        // Create student objects
		        Students s1 = new Students("Pallavi", 101, 85);
		        Students s2 = new Students("Tharnath", 102, 92);
		        Students s3 = new Students("Kashish", 103, 78);

		        // Create threads for each student
		        Thread t1 = new Thread(() -> {
		            logger.logStudent(s1);
		        }, "Thread-1");

		        Thread t2 = new Thread(() -> {
		            logger.logStudent(s2);
		        }, "Thread-2");

		        Thread t3 = new Thread(() -> {
		            logger.logStudent(s3);
		        }, "Thread-3");

		        // Start threads
		        t1.start();
		        t2.start();
		        t3.start();

		        // Wait for all threads to finish
		        try {
		            t1.join();
		            t2.join();
		            t3.join();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }

		        System.out.println("All Student Threads data written successfully!");
		    }
		}


