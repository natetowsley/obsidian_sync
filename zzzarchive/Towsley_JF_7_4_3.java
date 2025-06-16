package homwork_package;
import java.util.Date;

public class Towsley_JF_7_4_3 extends Person { //STUDENT CLASS
	private double gpa;
	private String studentID;
	private String major;
	private String degree;
	private int gradYear;
	
	public Towsley_JF_7_4_3/*STUDENT*/(String firstName, String middleName, String lastName, Date dateOfBirth,
			double gpa, String studentID, String major, String degree, int gradYear) {
		super(firstName, middleName, lastName, dateOfBirth);
		this.gpa = gpa;
		this.studentID = studentID;
		this.major = major;
		this.degree = degree;
		this.gradYear = gradYear;
	}
	public double getGPA() {
		return gpa;
	}
	public String getStudentID() {
		return studentID;
	}
	public String getMajor() {
		return major;
	}
	public String getDegree() {
		return degree + "in " + major;
	}
	public int getGradYear() {
		return gradYear;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setGPA(String[] grades) {
		double sum = 0;
		for (int i = 0; i < grades.length; i++) {
			switch (grades[i]) {
			case "A":
				sum += 4;
				break;
			case "A-":
				sum += 3.67;
				break;
			case "B+":
				sum += 3.33;
				break;
			case "B":
				sum += 3;
				break;
			case "B-":
				sum += 2.67;
				break;
			case "C+":
				sum += 2.33;
				break;
			case "C":
				sum += 2;
				break;
			case "D":
				sum += 1;
				break;
			case "F":
				sum += 0;
				break;
			default:
				System.out.println("Invalid grade read, grade skipped");
				break;
			}
		}
		this.gpa = sum / grades.length; //grades.length = number of classes
	}
}
