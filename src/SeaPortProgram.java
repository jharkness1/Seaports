
/* File: SeaPortProgram.java
 * Due Date: 22 Nov 2017
 * Author: Jason Harkness
 * Purpose: Simulate some of the aspects of a number
 * 		of Sea Ports
 */

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.*;

public class SeaPortProgram extends JFrame {

	HashMap<Integer, Seaport> hmsp = new HashMap<>();
	HashMap<Integer, Dock> hmd = new HashMap<>();
	HashMap<Integer, Ship> hms = new HashMap<>();
	HashMap<Integer, Person> hmp = new HashMap<>();

	private javax.swing.ButtonGroup bg;
	private javax.swing.JRadioButton index;
	private javax.swing.JButton sButton;
	private javax.swing.JScrollPane jsp;
	private javax.swing.JRadioButton name;
	private javax.swing.JRadioButton sort;
	private javax.swing.JTextArea jta;
	private javax.swing.JTextField input;
	private javax.swing.JRadioButton skill;

	public SeaPortProgram() {

		// Create File Chooser dialog box
		JFileChooser jfc = new JFileChooser(".");
		jfc.showOpenDialog(this);

		File myFile = jfc.getSelectedFile();
		if (myFile != null) {
			buildGUI();
			readFile(myFile);
		} else {
			JOptionPane.showMessageDialog(null, "No File Chosen");
		}
	}

	public static void main(String args[]) throws ClassNotFoundException {

		SeaPortProgram sp = new SeaPortProgram();

	}

	World w = new World(null);

	public void readFile(File f) {
		try {
			BufferedReader input = new BufferedReader(new FileReader(f));

			while (input.ready()) {
				String str = input.readLine().trim();
				Scanner sc = new Scanner(str);

				if (!str.startsWith("//")) {
					String type = "";
					if (sc.hasNext()) {
						type = sc.next();
					}

					if (type.equalsIgnoreCase("port")) {
						w.assignPort(new Seaport(sc));
						for(Seaport msp : w.ports) {
							hmsp.put(msp.index, msp);
						}
					} else if (type.equalsIgnoreCase("dock")) {
						w.assignDock(new Dock(sc));
						
						for(Seaport msp : w.ports) {
							for(Dock md : msp.docks)
							hmd.put(md.index, md);
						}
					} else if (type.equalsIgnoreCase("ship")) {
						Ship s = new Ship(sc);

						w.assignShip(s);
						
						for(Seaport msp : w.ports) {
							for(Ship ms : msp.ships){
								hms.put(ms.index, ms);
							}
						}
					} else if (type.equalsIgnoreCase("pship")) {
						Ship s = new PassengerShip(sc);

						w.assignShip(s);
						
						for(Seaport msp : w.ports) {
							for(Ship ms : msp.ships){
								hms.put(ms.index, ms);
							}
						}
					} else if (type.equalsIgnoreCase("cship")) {
						Ship s = new CargoShip(sc);

						w.assignShip(s);
						
						for(Seaport msp : w.ports) {
							for(Ship ms : msp.ships){
								hms.put(ms.index, ms);
							}
						}
					} else if (type.equalsIgnoreCase("person")) {
						w.assignPerson(new Person(sc));
						for(Seaport msp : w.ports) {
							for(Person mp : msp.persons){
								hmp.put(mp.index, mp);
							}
						}
					}
				}
			}

			jta.setText(w.toString());
		} catch (Exception e) {
			System.out.println(e + "-----");
		}
	}

	private void buildGUI() {

		// Settings for JFrame to search
		setTitle("Search");
		setSize(600, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// Add components to JFrame in a JSplitPane
		GridBagConstraints c = new GridBagConstraints();

		JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();

		sButton = new JButton("Search");
		sButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sButtonActionPerformed(evt);
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		jp1.add(sButton, c);

		input = new JTextField();
		input.setPreferredSize(new Dimension(400, 24));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		jp1.add(input, c);

		Box b = Box.createHorizontalBox();
		bg = new ButtonGroup();
		name = new JRadioButton("name");
		index = new JRadioButton("index");
		skill = new JRadioButton("skill");
		sort = new JRadioButton("Sort");
		bg.add(name);
		bg.add(index);
		bg.add(skill);
		bg.add(sort);
		b.add(name);
		b.add(index);
		b.add(skill);
		b.add(sort);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		jp1.add(b, c);

		jta = new JTextArea(27, 75);
		jta.setFont(new java.awt.Font("Monospaced", 0, 12));
		jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setViewportView(jta);
		
		jp2.add(jsp, BorderLayout.CENTER);

		add(sp);
		sp.setDividerLocation(75);
		sp.setEnabled(false);
		sp.setTopComponent(jp1);
		sp.setBottomComponent(jp2);

		validate();

	}

	private void sButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (index.isSelected()) {
			try {
				int ind = Integer.parseInt(input.getText());
				jta.setText("");
				String out = "";
				
				if (hmsp.containsKey(ind)){
					out = hmsp.get(ind).toString();
				}else if (hmd.containsKey(ind)){
					out = hmd.get(ind).toString();
				}else if (hms.containsKey(ind)){
					out = hms.get(ind).toString();
				} else if (hmp.containsKey(ind)){
					out = hmp.get(ind).toString();
				}
				
				jta.setText(out);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else if (skill.isSelected()) {
			String skillString = input.getText();
			jta.setText("");
			String out = "";
			ArrayList<Seaport> arr = w.getPorts();
			for (Seaport s : arr) {
				ArrayList<Person> pArr = s.getPersons();
				for (Person p : pArr) {
					if (p.getSkills().equalsIgnoreCase(skillString)) {
						out += p.toString() + "\n";
					}
				}
			}
			jta.setText(out);
		} else if (name.isSelected()) {
			String nameString = input.getText();
			jta.setText("");
			String out = "";
			ArrayList<Seaport> arr = w.getPorts();
			for (Seaport s : arr) {
				ArrayList<Dock> dArr = s.getDocks();
				for (Dock d : dArr) {
					if (d.getName().equalsIgnoreCase(nameString)) {
						out += d.toString() + "\n";
					}
				}

				ArrayList<Ship> sArr = s.getShips();
				for (Ship d : sArr) {
					if (d.getName().equalsIgnoreCase(nameString)) {
						out += d.toString() + "\n";
					}
				}
				ArrayList<Ship> qArr = s.getQue();
				for (Ship d : qArr) {
					if (d.getName().equalsIgnoreCase(nameString)) {
						out += d.toString() + "\n";
					}
				}
				ArrayList<Person> pArr = s.getPersons();
				for (Person d : pArr) {
					if (d.getName().equalsIgnoreCase(nameString)) {
						out += d.toString() + "\n";
					}
				}
			}
			jta.setText(out);
		} else if (sort.isSelected()) {
			String mySort = input.getText();
			String result = sortShip(mySort);
			jta.setText(result);
		}
	}
		private String sortShip(String sortInput) {
			String result = "";
			ArrayList<Ship> ships = new ArrayList<>();
			
			for (Seaport msp : w.ports) {
				for (Ship ms : msp.ships) {
					ships.add(ms);
				}
			}
			
			if (sortInput.equalsIgnoreCase("weight")) {
				Collections.sort(ships, new CompareShip("weight"));
			} else if (sortInput.equalsIgnoreCase("width")) {
				Collections.sort(ships, new CompareShip("width"));
			} else if (sortInput.equalsIgnoreCase("length")) {
				Collections.sort(ships, new CompareShip("length"));
			} else if (sortInput.equalsIgnoreCase("draft")) {
				Collections.sort(ships, new CompareShip("draft"));
			}

			for (Ship ship : ships) {
				result += ship.toString() + "\n";
			}
			return result;
		}

}
