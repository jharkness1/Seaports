
/* File: CargoShip.java
 * Due Date: 22 Nov 2017
 * Author: Jason Harkness
 * Purpose: Simulate some of the aspects of a number
 * 		of Sea Ports
 */
import java.util.Scanner;

public class CargoShip extends Ship {
	double cargoValue;
	double cargoVolume;
	double cargoWeight;

	public CargoShip(Scanner sc) {
		super(sc);
		cargoWeight = sc.nextDouble();
		cargoVolume = sc.nextDouble();
		cargoValue = sc.nextDouble();
	}

	public double getCargoValue() {
		return cargoValue;
	}

	public void setCargoValue(double cargoValue) {
		this.cargoValue = cargoValue;
	}

	public double getCargoVolume() {
		return cargoVolume;
	}

	public void setCargoVolume(double cargoVolume) {
		this.cargoVolume = cargoVolume;
	}

	public double getCargoWeight() {
		return cargoWeight;
	}

	public void setCargoWeight(double cargoWeight) {
		this.cargoWeight = cargoWeight;
	}

	@Override
	public String toString() {
		return "Cargo Ship: " + name + " " + index;
	}
}
