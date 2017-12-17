
/* File: Dock.java
 * Due Date: 22 Nov 2017
 * Author: Jason Harkness
 * Purpose: Simulate some of the aspects of a number
 * 		of Sea Ports
 */import java.util.Scanner;

public class Dock extends Thing {
	Ship ship;

	public Dock(Scanner sc) {
		super(sc);
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public String toString() {
		return "Dock: " + super.toString() + "\n  Ship: " + ship.toString();
	}

}