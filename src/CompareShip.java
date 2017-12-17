
/* File: CompareShip.java
 * Due Date: 22 Nov 2017
 * Author: Jason Harkness
 * Purpose: Simulate some of the aspects of a number
 * 		of Sea Ports
 */
import java.util.Comparator;

public class CompareShip implements Comparator<Ship> {

		private String s;
		
		public CompareShip(String s) {
			this.s = s;
		}
		public int compare(Ship s1, Ship s2) {
			int result = -1;
			switch (s.toLowerCase()) {
			case "weight":
				if (s1.getWeight() == s2.getWeight()) {
					result = 0;
				} else if (s1.getWeight() > s2.getWeight()) {
					result = 1;
				} else {
					result = -1;
				}
				break;
			case "length":
				if (s1.getLength() == s2.getLength()) {
					result = 0;
				} else if (s1.getLength() > s2.getLength()) {
					result = 1;
				} else {
					result = -1;
				}
				break;
			case "draft":
				if (s1.draft == s2.draft) {
					result = 0;
				} else if (s1.draft > s2.draft) {
					result = 1;
				} else {
					result = -1;
				}
				break;
			case "width":
				if (s1.getWidth() == s2.getWidth()) {
					result = 0;
				} else if (s1.getWidth() > s2.getWidth()) {
					result = 1;
				} else {
					result = -1;
				}
				break;
			}
			return result;
		}

	}
