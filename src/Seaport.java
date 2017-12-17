
/* File: SeaPort.java
 * Due Date: 22 Nov 2017
 * Author: Jason Harkness
 * Purpose: Simulate some of the aspects of a number
 * 		of Sea Ports
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Seaport extends Thing {

	ArrayList<Dock> docks;
	ArrayList<Ship> ships;
	ArrayList<Ship> que;
	ArrayList<Person> persons;

	public Seaport(Scanner sc) {
		super(sc);
		docks = new ArrayList<>();
		ships = new ArrayList<>();
		que = new ArrayList<>();
		persons = new ArrayList<>();
	}

	public ArrayList<Dock> getDocks() {
		return docks;
	}

	public void setDocks(ArrayList<Dock> docks) {
		this.docks = docks;
	}

	public ArrayList<Ship> getShips() {
		return ships;
	}

	public void setShips(ArrayList<Ship> ships) {
		this.ships = ships;
	}

	public ArrayList<Ship> getQue() {
		return que;
	}

	public void setQue(ArrayList<Ship> que) {
		this.que = que;
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

	public String toString() {
		String st = "\n\nSeaPort: " + super.toString();
		for (Dock md : docks) st += "\n" + md;
		st += "\n\n --- List of all ships in que:";
		for (Ship ms : que) st += "\n   > " + ms;
		st += "\n\n --- List of all ships:";
		for (Ship ms : ships) st += "\n   > " + ms;
		st += "\n\n --- List of all persons:";
		for (Person mp : persons) st += "\n   > " + mp;
		return st;
	} // end method toString
}
