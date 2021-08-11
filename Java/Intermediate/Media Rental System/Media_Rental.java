//
// Assignment:	*******
// Name: 		ZyVerus
// Course: 		*******
// Date: 		07/12/2021
// 
// This program helps manage a media rental system.
//
// --------------------------------------

// Import Java Packages
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Media_Rental {
	// INIT Scanner
	Scanner inputString = new Scanner(System.in);
	Scanner inputNumber = new Scanner(System.in);
	
	// C L A S S E S
	// MEDIA Class
	protected static class Media {
		private int id, year;
		private String title;
		private boolean available;
		// CONSTRUCTOR
		// 		No Parameter
		public Media() {
		}
		//		Input Parameters
		public Media(int id, boolean available, String title, int year) {
			this.id = id;
			this.available = available;
			this.title = title;
			this.year = year;
		}
		// GET & SET Methods
		// ID
		//		Set
		public void setID(int id) {
			this.id = id;
		}
		//		Get
		public int getID() {
			return id;
		}
		// Available
		//		Set
		public void setAvailable(boolean available) {
			this.available = available;
		}
		//		Get
		public boolean isAvailable() {
			return available;
		}
		// Title
		//		Set
		public void setTitle(String title) {
			this.title = title;
		}
		//		Get
		public String getTitle() {
			return title;
		}
		// Year
		//		Set
		public void setYear(int year) {
			this.year = year;
		}
		//		Get
		public int getYear() {
			return year;
		}
		// CALCULATE Rental Fee
		public double calculateRentalFee() {
			return 3.50;
		}
	}
	// MEDIA SUBCLASSES
	//		E-BOOK Media
	public static class EBook extends Media {
		private int chapters;
		// CONSTRUCTOR
		public EBook(int id, boolean available, String title, int year, int chapters) {
			super(id, available, title, year);
			this.chapters = chapters;
		}
		// Chapters
		//		Set
		public void setChapters(int chapters) {
			this.chapters = chapters;
		}
		//		Get
		public int getChapters() {
			return chapters;
		}
		// Override Media Rental Fee
		@Override
		public double calculateRentalFee() {
			double fee = chapters * 0.10;	// basic fee
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			if (this.getYear() == currentYear)
				fee += 1;	// Add $1.00 fee
			return fee;
		}
		@Override
		// Send Values to String
		public String toString() {
			return "\n---E-Book---"
					+ "\nID: " + getID()
					+ "\nTitle: " + getTitle()
					+ "\nYear: " + getYear()
					+ "\nChapters: " + getChapters()
					+ "\nAvailable: " + isAvailable()
					+ "\n";
		}
	}
	//		MOVIE-DVD Media
	public static class MovieDVD extends Media {
		private double size; // Value in MB
		// CONSTRUCTOR
		public MovieDVD(int id, boolean available, String title, int year, double size) {
			super(id, available, title, year);
			this.size = size;
		}
		// Size
		//		Set
		public void setSize(double size) {
			this.size = size;
		}
		//		Get
		public double getSize() {
			return size;
		}
		@Override
		// Send Values to String
		public String toString() {
			return "\n---Movie DVD---"
					+ "\nID: " + getID()
					+ "\nTitle: " + getTitle()
					+ "\nYear: " + getYear()
					+ "\nSize: " + getSize() + " MB"
					+ "\nAvailable: " + isAvailable()
					+ "\n";
		}
	}
	//		MUSIC-CD MEDIA
	public static class MusicCD extends Media {
		private int length;
		// CONSTRUCTOR
		public MusicCD(int id, boolean available, String title, int year, int length) {
			super(id, available, title, year);
			this.length = length;
		}
		// Length
		//		Set
		public void setLength(int length) {
			this.length = length;
		}
		//		Get
		public int getLength() {
			return length;
		}
		// Override Media Rental Fee
		@Override
		public double calculateRentalFee() {
			double fee = length * 0.02;	// basic fee
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			if (this.getYear() == currentYear)
				fee += 1;	// Add $1.00 fee
			return fee;
		}
		@Override
		// Send Values to String
		public String toString() {
			return "\n---Movie DVD---"
					+ "\nID: " + getID()
					+ "\nTitle: " + getTitle()
					+ "\nYear: " + getYear()
					+ "\nLength: " + getLength() + " Minutes"
					+ "\nAvailable: " + isAvailable()
					+ "\n";
		}
	}
	
	// O B J E C T  M A N A G E R
	// Manager
	public static class Manager {
		private List<Media> list;
		// CONSTRUCTOR
		public Manager() {
			list=new ArrayList<>();
		}
		// METHODS
		//		Load
		public boolean LoadMedia(String path) {
			File myFile = new File(path);
			try {
				Scanner inputString = new Scanner(myFile);
				while (inputString.hasNextLine()) {
					String mediaItem = inputString.nextLine();
					String[] string = mediaItem.split(", ");
					if (string[2].equals("E")) {
						list.add(new EBook(	Integer.parseInt(string[0]),
											Boolean.parseBoolean(string[1]),
											string[3],
											Integer.parseInt(string[4]),
											Integer.parseInt(string[5])
											));
					}
					else if (string[2].equals("D")) {
						list.add(new MovieDVD(	Integer.parseInt(string[0]),
											Boolean.parseBoolean(string[1]),
											string[3],
											Integer.parseInt(string[4]),
											Double.parseDouble(string[5])
											));
					}
					else if (string[2].equals("C")) {
						list.add(new MusicCD(	Integer.parseInt(string[0]),
											Boolean.parseBoolean(string[1]),
											string[3],
											Integer.parseInt(string[4]),
											Integer.parseInt(string[5])
											));
					}
				}
				inputString.close();
				System.out.println("\nSuccess! File Imported From: "
						+ "\n" + myFile);
				return true;
			}
			catch (FileNotFoundException exception) {
				System.out.println("\nFile Not Found. Unable to load file from the directory specified: "
						+ "\n" + myFile);
				return false;
			}
		}
		//		Find
		public void findMedia(String title) {
			boolean found = false;
			for(Media media : list) {
				if(media.getTitle().toLowerCase().contains(title.toLowerCase())) {
					found = true;
					System.out.print(media.toString());
				}
			}
			if(!found) {
				System.out.println("\nMedia not found with Title: " + title);
			}
		}
		//		Rent
		public void rentMedia(int id) {
			boolean found = false;
			for(Media media : list) {
				if(media.getID()==id) {
					found = true;
					if(media.isAvailable()) {
						System.out.println("Media successfully rented. Rental Fee: $" + media.calculateRentalFee());
						media.setAvailable(false);
					}
					else
						System.out.println("\nSorry - Media Item (ID: " + id + ") is currently unavailable.");
				}
			}
			if(!found) {
				System.out.println("\nMedia not found with ID: " + id);
			}
		}
	}
	// U S E R  I N T E R F A C E
	// Media Rental System
	public static class MediaRentalSystem {
		// Manager Instance
		private Manager iMan;
		// CONSTRUCTOR
		public MediaRentalSystem() {
			iMan = new Manager();
		}
		// INIT Scanner
		Scanner inputString = new Scanner(System.in);
		Scanner inputNumber = new Scanner(System.in);

		// Display Menu
		public void displayMenu() {
			System.out.print("\n"
					+ "\tMENU:"
					+ "\n1 - Load Media Objects"
					+ "\n2 - Find Media Object"
					+ "\n3 - Rent Media Object"
					+ "\n9 - Exit Program"
					+ "\n"
					+ "Enter Selection:"
					+ "\n> ");
		}
		// Process Menu Choices
		public void processChoice(int choice) {
			switch (choice) {
				case 1:
					System.out.print("Enter File Path Directory to Load Objects from:"
							+ "\n> ");
					String filePath = inputString.nextLine();
					iMan.LoadMedia(filePath);
					break;
				case 2:
					System.out.print("Enter media's title:"
							+ "\n> ");
					String title = inputString.nextLine();
					iMan.findMedia(title);
					break;
				case 3:
					System.out.print("Enter media's ID:"
							+ "\n> ");
					int id = inputNumber.nextInt();
					iMan.rentMedia(id);
					break;
				case 9:
					System.out.println("");
					System.out.print("Exiting program. Thank you, and have a great day!");
					System.exit(0);
					break;
				default:
					System.out.println("\nYou did not make an appropriate selection.");
					break;
			}
		}
	}
	// M A I N
	public static void main(String[] args) {
		// INIT Scanner
		Scanner inputNumber = new Scanner(System.in);
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
		System.out.println("Welcome! This program helps manage a media rental system.");
		
		// Initialize Media Rental System
		MediaRentalSystem system = new MediaRentalSystem();
		// Action Variable
		int action = 0;
		do {
			system.displayMenu();
			action = inputNumber.nextInt();
			system.processChoice(action);
		} while (action != 9);
		inputNumber.close();
	}
}