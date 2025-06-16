package homwork_package;
import java.util.Date; 
public class Person { 
	private String firstName; 
	private String middleName; 
	private String lastName; 
	private Date dateOfBirth; 
	public Person(String firstName, String middleName, 
	 String lastName, Date dateOfBirth){ 
		this.firstName = firstName; 
		this.middleName = middleName; 
		this.lastName = lastName; 
		this.dateOfBirth = dateOfBirth; 
	} 
	/** 
	* Returns a String of the firstName 
	* @return firstName 
	*/ 
	public String getFirstName(){
		return firstName; 
	} 
	/** 
	* Returns a string of the middleName 
	* @return middleName 
	*/ 
	public String getMiddleName(){ 
		return middleName; 
	} 
	/** 
	* Returns a String of the lastName 
	* @return lastName 
	*/ 
	public String getLastName(){ 
		return lastName; 
	} 
	/** 
	* Returns a concatenated string of the Person's name 
	* @return the Person's first, middle, and last name. 
	*/ 
	public String getName(){ 
		return firstName + " " + middleName + " " + lastName; 
	} 
	/** 
	* Returns the Person's date of birth as a date type 
	* @return a Date type of the Person's date of birth. 
	*/ 
	public Date getDateOfBirth(){ 
		return dateOfBirth; 
	} 
}