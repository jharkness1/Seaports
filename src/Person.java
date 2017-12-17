
/* File: Person.java
 * Due Date: 22 Nov 2017
 * Author: Jason Harkness
 * Purpose: Simulate some of the aspects of a number
 * 		of Sea Ports
 */
import java.util.Scanner;

public class Person extends Thing {

	String skills;

	public Person(Scanner sc) {
		super(sc);
		skills = sc.next();
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Person: " + name + " " + index + " " + skills;
	}

}
