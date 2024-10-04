import java.io.*;
import java.text.*;
import java.util.*;

public  class StudentList {
	//***** here we are reading the file with the file name ******/
	public static String readTheFile(String fileName) {
		try {
			BufferedReader fileToRead = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

			return fileToRead.readLine();
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public static void main(String[] args) {
//my name is habibi 
//amar nam pipra 
		CONSTANT constants = new CONSTANT();

		boolean IsValidArg = true;

		while (IsValidArg) {
			// Check arguments
			if (args[0].equals("a")) {
				IsValidArg = false;
				System.out.println(constants.LOADING_MESSAGE);
				try {
					String r = readTheFile("students.txt");
					String i[] = r.split(",");
					for (String j : i) {
						System.out.println(j);
					}
				} catch (Exception e) {
				}
				System.out.println("Data Loaded.");
			} else if (args[0].equals("r")) {
				IsValidArg = false;
				System.out.println("Loading data ...");
				try {
					BufferedReader s = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String r = s.readLine();
					String i[] = r.split(",");
					int length = i.length;
					Random x = new Random();
					int y = x.nextInt(0 , length-1);
					System.out.println(i[y]);
				} catch (Exception e) {
				}
				System.out.println("Data Loaded.");
			} else if (args[0].contains("+")) {
				IsValidArg = false;
				System.out.println("Loading data ...");
				try {
					BufferedWriter s = new BufferedWriter(
							new FileWriter("students.txt", true));
					String t = args[0].substring(1);
					Date d = new Date();
					String df = "dd/mm/yyyy-hh:mm:ss a";
					DateFormat dateFormat = new SimpleDateFormat(df);
					String fd = dateFormat.format(d);
					s.write(", " + t + "\nList last updated on " + fd);
					s.close();
				} catch (Exception e) {
				}

				System.out.println("Data Loaded.");
			} else if (args[0].contains("?")) {
				IsValidArg = false;
				System.out.println("Loading data ...");
				try {
					BufferedReader s = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String r = s.readLine();
					String i[] = r.split(",");
					boolean done = false;
					String t = args[0].substring(1);
					for (int idx = 0; idx < i.length && !done; idx++) {
						if (i[idx].equals(t)) {
							System.out.println("We found it!" +" at index := " + idx);
							done = true;
						}
						
					}
				} catch (Exception e) {
				}
				System.out.println("Data Loaded.");
			} else if (args[0].contains("c")) {
				IsValidArg = false;
				System.out.println("Loading data ...");
				try {
					BufferedReader s = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String D = s.readLine();
					char a[] = D.toCharArray();
					String i[] = D.split(",");
					System.out.println(i.length + " word(s) found " + a.length);
				} catch (Exception e) {
				}
				System.out.println("Data Loaded.");
			} else {
				System.out.println("Give an valid input please:::");
				Scanner inputScanner = new Scanner(System.in);
				String theArgument = inputScanner.nextLine();
				args = theArgument.split("\\s++");
			}
		}
	}
}