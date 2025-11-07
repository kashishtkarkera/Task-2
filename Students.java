package examscore;

public class Students {
	    private String name;
	    private int rollNo;
	    private int marks;

	    public Students(String name, int rollNo, int marks) {
	        this.name = name;
	        this.rollNo = rollNo;
	        this.marks = marks;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getRollNo() {
	        return rollNo;
	    }

	    public int getMarks() {
	        return marks;
	    }

	    // Format the data as a line for CSV/text file
	    public String toCSV() {
	        return name + "," + rollNo + "," + marks;
	    }
	}


