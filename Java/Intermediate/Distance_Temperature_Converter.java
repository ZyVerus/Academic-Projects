//
// Assignment:	*******
// Name: 		ZyVerus
// Course: 		*******
// Date: 		07/12/2021
// 
// This program helps with converting distance and temperature
//
// --------------------------------------

// Import Java Packages
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Distance_Temperature_Converter {
	// C L A S S E S
	// CONVERTER Class
	public static class Converter {
		private static double value;
		
		// CONSTRUCTOR
		//		No Parameter
		public Converter() {
			value = Double.NaN;
		}
		//		Input Parameter
		public Converter(double value) {
			Converter.value = value;
		}
		// METHODS
		//		Convert
		public double convert() {
			return value;
		}
		// 		SET Methods
		//			Input Value
		public void setValue(double value) {
			Converter.value = value;
		}
		// 		GET Methods
		// 			Input Value
		public static double getValue() {
			return value;
		}
	}
	// CONVERTER SUBCLASSES
	//		DISTANCE Converter
	public static class DistanceConverter extends Converter {
		// CONSTRUCTOR
		//		No Parameter
		public DistanceConverter() {
			super();
		}
		//		Input Parameter
		public DistanceConverter(double value) {
			super(value);
		}
		// METHODS
		//		Convert
		public double convert() {
			DecimalFormat df = new DecimalFormat("#.##");
			double convertedValue = 0;
			if (Converter.getValue() == Double.NaN) {
				convertedValue = Double.NaN;
			}
			else {
				convertedValue = (Converter.getValue() * 1.609);
				convertedValue = Double.valueOf(df.format(convertedValue));
			}
			return convertedValue;
		}
	}
	//		TEMPERATURE Converter
	public static class TemperatureConverter extends Converter {
		// CONSTRUCTOR
		//		No Parameter
		public TemperatureConverter() {
			super();
		}
		//		Input Parameter
		public TemperatureConverter(double value) {
			super(value);
		}
		// METHODS
		//		Convert
		public double convert() {
			DecimalFormat df = new DecimalFormat("#.##");
			double convertedValue = 0;
			if (Converter.getValue() == Double.NaN) {
				convertedValue = Double.NaN;
			}
			else {
				convertedValue = (((Converter.getValue() - 32) * 5) / 9);
				convertedValue = Double.valueOf(df.format(convertedValue));
			}
			return convertedValue;
		}
	}
		public static class GUIConverter extends JFrame {
			// Handle Serializable Static Class Warning
			private static final long serialVersionUID = 1L;
			
			// CONSTRUCTOR
			public GUIConverter() {
				JFrame frame = new JFrame("Welcome to Converter");
				frame.setLayout(new BorderLayout());
				frame.setSize(500, 250);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				// BUTTONS
				JButton distanceConverterButton = new JButton("Distance Converter");
				JButton temperatureConverterButton = new JButton("Temperature Converter");
				JButton exitButton = new JButton("Exit");
				// 		ADD Buttons to Frame
				frame.add(distanceConverterButton, BorderLayout.CENTER);
				frame.add(temperatureConverterButton, BorderLayout.EAST);
				frame.add(exitButton, BorderLayout.SOUTH);
				
				// ACTION LISTENERS
				//		DISTANCE Converter
				distanceConverterButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						DistanceConverter distanceConverter = new DistanceConverter();
						try {
							double distance = Double.parseDouble(JOptionPane.showInputDialog("Input Distance in Miles to convert to Kilometers."));
							distanceConverter.setValue(distance);
							JOptionPane.showMessageDialog(rootPane,  distance + " Miles equals " + distanceConverter.convert() + " Kilometers");
						}
						catch (NumberFormatException numException) {
							JOptionPane.showMessageDialog(rootPane, "No value inputted. Value = " + distanceConverter.convert());
						}
					}
				});
				//		TEMPERATURE Converter
				temperatureConverterButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						TemperatureConverter temperatureConverter = new TemperatureConverter();
						try {
							double temperature = Double.parseDouble(JOptionPane.showInputDialog("Input Temperature in Fahrenheit to convert to Celsius."));
							temperatureConverter.setValue(temperature);
							JOptionPane.showMessageDialog(rootPane,  temperature + " Fahrenheit equals " + temperatureConverter.convert() + " Celsius");
						}
						catch (NumberFormatException numException) {
							JOptionPane.showMessageDialog(rootPane, "No value inputted. Value = " + temperatureConverter.convert());
						}
					}
				});
				//		EXIT Button
				exitButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						System.out.print("\nExiting program. Thank you, and have a great day!");
						System.exit(0);
					}
				});
				// GENERATE Converter GUI
				frame.setVisible(true);
		}
	}
	
	// M A I N
	public static void main(String[] args) {
		// DATE
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate currentDate = LocalDate.now();
		// SET Submission Requirement Variables
		String firstName = "ZyVerus";
		String lastName = "*******";
		String courseIdentifier = "*******";
		// PRINT Submission Requirement Header
		System.out.println("Name: " + lastName + ", " + firstName);
		System.out.println("Course ID: " + courseIdentifier);
		System.out.println("Date: " + dtf.format(currentDate) + "\n");
		// INTRO
		System.out.println("Welcome! This program helps with converting distance and temperature.");
		
		// RUN Converter GUI
		new GUIConverter();
	}
}