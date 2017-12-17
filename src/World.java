
/* File: World.java
 * Due Date: 22 Nov 2017
 * Author: Jason Harkness
 * Purpose: Simulate some of the aspects of a number
 * 		of Sea Ports
 */
import java.util.ArrayList;
import java.util.Scanner;

public class World extends Thing {
	ArrayList<Seaport> ports;
	PortTime time;

	public World(Scanner sc) {
		super(sc);
		ports = new ArrayList<>();
	}

	public ArrayList<Seaport> getPorts() {
		return ports;
	}

	public void setPorts(ArrayList<Seaport> ports) {
		this.ports = ports;
	}

	public PortTime getTime() {
		return time;
	}

	public void setTime(PortTime time) {
		this.time = time;
	}

	Ship getShipByIndex(int x) {
		for (Seaport msp : ports)
			for (Ship ms : msp.ships)
				if (ms.index == x)
					return ms;
		return null;
	} // end getShipByIndex

	Dock getDockByIndex(int x) {
		for (Seaport msp : ports)
			for (Dock ms : msp.docks)
				if (ms.index == x)
					return ms;
		return null;
	}// end getDockByIndex

	Seaport getSeaPortByIndex(int x) {
		for (Seaport msp : ports)
			if (msp.index == x)
				return msp;
		return null;
	}

	void assignShip(Ship ms) {
		Dock md = getDockByIndex(ms.parent);
		if (md == null) {
			getSeaPortByIndex(ms.parent).ships.add(ms);
			getSeaPortByIndex(ms.parent).que.add(ms);
			return;
		}
		md.ship = ms;
		getSeaPortByIndex(md.parent).ships.add(ms);
	} // end method assignShip

	void assignPerson(Person p) {
		for (Seaport sp : ports) {
			if (sp.getIndex() == p.getParent()) {
				sp.persons.add(p);
			}
		}
	} // end assignPerson

	void assignDock(Dock d) {
		for (Seaport sp : ports) {
			if (sp.getIndex() == d.getParent()) {
				sp.docks.add(d);
			}
		}
	}// end assignDock

	void assignPort(Seaport p) {
		ports.add(p);
	}

	public String toString() {
		String str = "";
		for (Seaport s : ports) {
			str += s.toString() + "\n";
		}
		return str;
	}

}
