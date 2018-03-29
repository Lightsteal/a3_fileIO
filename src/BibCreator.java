// -----------------------------------------------------
// Assignment 3,: The purpose of this assignment is to practice Exception Handling, and File I/O, as well as other previous object-oriented concepts. 
// Written by: Abhijit Gupta 40066502
// -----------------------------------------------------

//import java.util.Arrays; for debugging
import java.util.Scanner;
import java.io.*;

/**
 * <h1>BibCreator Class (Driver)</h1>
 * The purpose of this program is to review some concepts covered in class
 * previously concerning Exception Handling and File I/O. For this assignment,
 * we had to create a BibCreator class which reads from Bib files containing one or more articles
 * and created 3 types of formatted bibliographies (IEEE, ACM, and NJ) which are written in JSON output files.
 * The program also lets the user review any of the JSON files <br>
 * @author Abhijit Gupta, Student: 40066502
 * COMP249<br>
 * Assignment 3 <br>
 * Due date: Monday, March 19th, 2018</br>
 */
public class BibCreator {
	/**
	 * Used to get the values of author (names) stored in file.
	 * @param String s, is the String line read by the scanner. It is passed to this method for processing.
	 * @return String containing all the authors separated by '#' or returns null if passed parameter does not contain author.
	 * @throws FileInvalidException with message "author" if author field is empty.
	 */
	public static String getAuthors(String s) throws FileInvalidException{
		String[] arr = s.split("\\=");
		String value = "";
		String[] result;
		if (arr[0].equals("author")) {
			if(arr[1].contains("{}")){
				throw new FileInvalidException("author");
			}
			value = arr[1].substring(1, (arr[1].indexOf("}")));
			result = value.split("\\sand\\s");
			value = "";
			for (int i = 0; i < result.length; i++) {
				value = value + result[i] + "#";
			}
			return value;
		}
		return null;
	}
	/**
	 * Used to get the value of title stored in file.
	 * @param String s, is the String line read by the scanner. It is passed to this method for processing.
	 * @return String, containing the Title or returns null if passed parameter does not contain author.
	 * @throws FileInvalidException, with message "title" if field is empty.
	 */
	public static String getTitle(String s)throws FileInvalidException{
		String[] arr = s.split("\\=");
		String value = "";
		if (arr[0].equals("title")) {
			if(arr[1].contains("{}")){
				throw new FileInvalidException("title");
			}
			value = arr[1].substring(1, (arr[1].indexOf("}")));
			return value;
		}
		return null;
	}
	/**
	 * Used to get the value of journal stored in file.
	 * @param String s, is the String line read by the scanner. It is passed to this method for processing.
	 * @return String, containing the journal name or returns null if passed parameter does not contain author.
	 * @throws FileInvalidException, with message "journal" if field is empty.
	 */
	public static String getJournals(String s)throws FileInvalidException {
		String[] arr = s.split("\\=");
		String value = "";
		if (arr[0].equals("journal")) {
			if(arr[1].contains("{}")){
				throw new FileInvalidException("journal");
			}
			value = arr[1].substring(1, (arr[1].indexOf("}")));
			return value;
		}
		return null;
	}
	/**
	 * Used to get the value of Volume stored in file.
	 * @param String s, is the String line read by the scanner. It is passed to this method for processing.
	 * @return String, containing the volume or returns null if passed parameter does not contain author.
	 * @throws FileInvalidException, with message "volume" if field is empty.
	 */
	public static String getVolume(String s)throws FileInvalidException {
		String[] arr = s.split("\\=");
		String value = "";
		if (arr[0].equals("volume")) {
			if(arr[1].contains("{}")){
				throw new FileInvalidException("volume");
			}
			value = arr[1].substring(1, (arr[1].indexOf("}")));
			return value;
		}
		return null;
	}
	/**
	 * Used to get the value of number stored in file.
	 * @param String s, is the String line read by the scanner. It is passed to this method for processing.
	 * @return String, containing the number or returns null if passed parameter does not contain author.
	 * @throws FileInvalidException, with message "number" if field is empty.
	 */
	public static String getNumber(String s)throws FileInvalidException {
		String[] arr = s.split("\\=");
		String value = "";
		if (arr[0].equals("number")) {
			if(arr[1].contains("{}")){
				throw new FileInvalidException("number");
			}
			value = arr[1].substring(1, (arr[1].indexOf("}")));
			return value;
		}
		return null;
	}
	/**
	 * Used to get the value of page stored in file.
	 * @param String s, is the String line read by the scanner. It is passed to this method for processing.
	 * @return String, containing the pages or returns null if passed parameter does not contain author.
	 * @throws FileInvalidException, with message "pages" if field is empty.
	 */
	public static String getPage(String s)throws FileInvalidException {
		String[] arr = s.split("\\=");
		String value = "";
		if (arr[0].equals("pages")) {
			if(arr[1].contains("{}")){
				throw new FileInvalidException("pages");
			}
			value = arr[1].substring(1, (arr[1].indexOf("}")));
			return value;
		}
		return null;
	}
	/**
	 * Used to get the value of Month stored in file.
	 * @param String s, is the String line read by the scanner. It is passed to this method for processing.
	 * @return String, containing the month or returns null if passed parameter does not contain author.
	 * @throws FileInvalidException, with message "month" if field is empty.
	 */
	public static String getMonth(String s)throws FileInvalidException {
		String[] arr = s.split("\\=");
		String value = "";
		if (arr[0].equals("month")) {
			if(arr[1].contains("{}")){
				throw new FileInvalidException("month");
			}
			value = arr[1].substring(1, (arr[1].length() - 2));
			return value;
		}
		return null;
	}
	/**
	 * Used to get the value of year stored in file.
	 * @param String s, is the String line read by the scanner. It is passed to this method for processing.
	 * @return String, containing the year or returns null if passed parameter does not contain author.
	 * @throws FileInvalidException, with message "year" if field is empty.
	 */
	public static String getYear(String s)throws FileInvalidException {
		String[] arr = s.split("\\=");
		String value = "";
		if (arr[0].equals("year")) {
			if(arr[1].contains("{}")){
				throw new FileInvalidException("year");
			}
			value = arr[1].substring(1, (arr[1].indexOf("}")));
			return value;
		}
		return null;
	}
	/**
	 * Used to get the value of DOI stored in file.
	 * @param String s, is the String line read by the scanner. It is passed to this method for processing.
	 * @return String, containing the doi or returns null if passed parameter does not contain author.
	 * @throws FileInvalidException, with message "doi" if field is empty.
	 */
	public static String getDOI(String s)throws FileInvalidException {
		String[] arr = s.split("\\=");
		String value = "";
		if (arr[0].equals("doi")) {
			if(arr[1].contains("{}")){
				throw new FileInvalidException("doi");
			}
			value = arr[1].substring(1, (arr[1].indexOf("}")));
			return "DOI:https://doi.org/" + value;
		}
		return null;
	}
	/**
	 * Used to get the value of ISSN stored in file.
	 * @param String s, is the String line read by the scanner. It is passed to this method for processing.
	 * @return String, containing the issn or returns null if passed parameter does not contain author.
	 * @throws FileInvalidException, with message "issn" if field is empty.
	 */
	public static String getISSN(String s)throws FileInvalidException {
		String[] arr = s.split("\\=");
		String value = "";
		if (arr[0].equals("ISSN")) {
			if(arr[1].contains("{}")){
				throw new FileInvalidException("ISSN");
			}
			value = arr[1].substring(1, (arr[1].indexOf("}")));
			return value;
		}
		return null;
	}
	/**
	 * Used to get the value of keywords stored in file.
	 * @param String s, is the String line read by the scanner. It is passed to this method for processing.
	 * @return String, containing the keywords or returns null if passed parameter does not contain author.
	 * @throws FileInvalidException, with message "keywords" if field is empty.
	 */
	public static String getKeyW(String s)throws FileInvalidException {
		String[] arr = s.split("\\=");
		String value = "";
		if (arr[0].equals("keywords")) {
			if(arr[1].contains("{}")){
				throw new FileInvalidException("keywords");
			}
			value = arr[1].substring(1, (arr[1].indexOf("}")));
			return value;
		}
		return null;
	}
	
	/**
	 * This method formats all the inputs to be in IEEE and outputs the result.
	 * @param a String containing authors acquired by get().
	 * @param j String containing journal acquired by get().
	 * @param t String containing title acquired by get().
	 * @param volume String acquired by get().
	 * @param number String acquired by get().
	 * @param page String acquired by get().
	 * @param month String acquired by get().
	 * @param year String acquired by get().
	 * @return returns these values formatted according to IEEE standard.
	 */
	public static String formatIEEE(String a, String j, String t, String volume, String number, String page, String month, String year) {
		String[] authors = a.split("\\#");
		String value = "";
		int i = 0;
		for (i = 0; i < authors.length - 1; i++) {
			value = value + authors[i] + ", ";
		}
		value = value + authors[i] + ".";
		return (value + " \"" + t + "\", " + j + ", vol. " + volume + ", no. " + number + ", p. " + page + ", " + month+ " " + year + ".");
	}
	/**
	 * This method formats all the inputs to be in ACM and outputs the result.
	 * @param a String containing authors acquired by get().
	 * @param j String containing journal acquired by get().
	 * @param t String containing title acquired by get().
	 * @param volume String acquired by get().
	 * @param number String acquired by get().
	 * @param page String acquired by get().
	 * @param year String acquired by get().
	 * @param doi String acquired by get().
	 * @return returns these values formatted according to ACM standard.
	 */
	public static String formatACM(String a, String j, String t, String volume, String number, String page, String year, String doi) {
		String[] authors = a.split("\\#");
		String value = authors[0];
		return (value + " et al. "+year+". "+t+ ". " + j + ". " + volume + ", " + number + " (" + year +"), "+page + ". "+doi+".");
	}
	/**
	 * This method formats all the inputs to be in Nature Journal's (NJ) requirement and outputs the result.
	 * @param a String containing authors acquired by get().
	 * @param j String containing journal acquired by get().
	 * @param t String containing title acquired by get().
	 * @param volume String acquired by get().
	 * @param page String acquired by get().
	 * @param year String acquired by get().
	 * @return returns these values formatted according to NJ standard.
	 */
	public static String formatNJ(String a, String j, String t, String volume, String page, String year) {
		String[] authors = a.split("\\#");
		String value = "";
		int i = 0;
		for (i = 0; i < authors.length - 1; i++) {
			value = value + authors[i] + " & ";
		}
		value = value + authors[i] + ". ";
		return (value + t + ". " + j + ". " + volume + ", " + page + "(" + year + ").");
	}
	/**
	 * Processes each of these files to find out whether it is valid or not.
	 * If a file is valid it creates the proper records for each of the 3 formats (IEEE, ACM and NJ) and store them in these files.
	 * If a file is invalid, it stops the processing of this file only, throws and FileInvalidException to display the exception error message, 	
	 * then display a message indicating which file was detected as invalid, and where the “first” problem in that file was detected.
	 * The corresponding output file is then deleted.
	 * The method will then continue with the processing of the following files.
	 * @param pw1 PrintWriter writing IEEE file
	 * @param pw2 PrintWriter writing ACM file
	 * @param pw3 PrintWriter writing NJ file
	 * @param sc Scanner reading from input files.
	 * @param count count of how many files are/to read.
	 * @param invalids count of how many invalid files.
	 * @param f1 IEEE output file. 
	 * @param f2 ACM output file.
	 * @param f3 NJ output file.
	 * @param fread current file being read.
	 * @return int, number of invalid files.
	 */
	public static int processFilesForValidation(PrintWriter pw1, PrintWriter pw2, PrintWriter pw3, Scanner sc,
			int count, int invalids, File f1, File f2, File f3, File fread) {
		String avalue = null, jvalue = null, tvalue = null, vol = null, number = null, page = null, month = null,
				yr = null, doi = null, issn=null, keyw=null;
		String s1 = "";
		int acmCount = 1;
		while (sc.hasNextLine()) {
			s1 = sc.nextLine();
			try {
				if (getAuthors(s1) != null) {
					avalue = getAuthors(s1);
				}
				if (getTitle(s1) != null) {
					tvalue = getTitle(s1);
				}
				if (getJournals(s1) != null) {
					jvalue = getJournals(s1);
				}
				if (getVolume(s1) != null) {
					vol = getVolume(s1);
				}
				if (getNumber(s1) != null) {
					number = getNumber(s1);
				}
				if (getPage(s1) != null) {
					page = getPage(s1);
				}
				if (getMonth(s1) != null) {
					month = getMonth(s1);
				}
				if (getYear(s1) != null) {
					yr = getYear(s1);
				}
				if (getDOI(s1) != null) {
					doi = getDOI(s1);
				}
				if (getISSN(s1) != null) {
					issn = getISSN(s1);
				}
				if (getKeyW(s1) != null) {
					keyw = getKeyW(s1);
				}

				if (avalue != null && jvalue != null && tvalue != null && vol != null && number != null && page != null
						&& month != null && yr != null && issn != null && keyw != null) {
					pw1.println(formatIEEE(avalue, jvalue, tvalue, vol, number, page, month, yr) + "\n");
					pw2.println("[" + acmCount + "] " + formatACM(avalue, jvalue, tvalue, vol, number, page, yr, doi)
							+ "\n");
					pw3.println(formatNJ(avalue, jvalue, tvalue, vol, page, yr) + "\n");
					avalue = null;	jvalue = null;
					tvalue = null;	vol = null;
					number = null;	page = null;
					month = null;	yr = null;
					doi = null; 	acmCount++;
				}
			} catch (FileInvalidException e1) {
				System.out.println("===============ERROR===============");
				System.out.println("Problem Deteted with input file: " + fread);
				System.out.println("File is Invalid: Field \"" + e1.getMessage()
						+ "\" is empty.\nProcess Stopped, may have other empty fields!\n");
				pw1.close();
				pw2.close();
				pw3.close();
				f1.delete();
				f2.delete();
				f3.delete();
				sc.close();
				invalids++;
				break;
			}
		}
		return invalids;
	}
	/**
	 * Used to print the user requested file to screen for review.
	 * @param br Buffered Reader
	 */
	public static void printFromFile(BufferedReader br){
		try{
			String s = br.readLine();
			while(s != null){
				System.out.println(s);
				s = br.readLine();		
			}
			br.close();
		}
		catch(IOException e4){
			System.out.println("and error accured while read/writing (IOException), program will exit now.");
			System.exit(0);
		}
	}
	/**
	 * Main method
	 * Displays everything needed for user interactions.
	 * Initializes all the parameters required for passing onto other methods ( PrintWriters, Scanner, BufferedReaders, etc.).
	 * Calls all other methods.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = null;
		PrintWriter pw1 = null;
		PrintWriter pw2 = null;
		PrintWriter pw3 = null;
		int count =1, invalids=0;
		File fread=null;
        System.out.println("----------------<3----------------\n             Welcome!\n----------------<3----------------\nCoverting files now...\n");
		while(count<=10){
			try {
			fread = new File("Latex"+count+".bib");
			File f1 = new File("IEEE"+count+".json");
			File f2 = new File("ACM"+count+".json");
			File f3 = new File("NJ"+count+".json");
			sc = new Scanner(new FileInputStream(fread));
			pw1 = new PrintWriter(new FileOutputStream(f1));
			pw2 = new PrintWriter(new FileOutputStream(f2));
			pw3 = new PrintWriter(new FileOutputStream(f3));
			invalids = processFilesForValidation(pw1, pw2, pw3, sc, count, invalids, f1, f2, f3, fread);
			}
			catch (FileNotFoundException e2) {
				System.out.println("Could not open file "+fread+" for reading, please check if file exists!\nProgram will exit after closing all opened files.");
				System.exit(0);
			}
				pw1.close();
				pw2.close();
				pw3.close();
				sc.close();
				count++;
		}
		System.out.println("There were a total of "+invalids+" Invalid files, All other ("+(10-invalids)+") files were Valid, and have been created.\n");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		BufferedReader br=null;
		String fName;
		System.out.println("Please enter the name of one of the files that you need to review: ");
		fName = input.nextLine();
		try{
			br = new BufferedReader(new FileReader(fName));
		}
		catch(FileNotFoundException e3){
			System.out.println("Invalid input, could not find the file. Please try again.");
			fName = input.nextLine();
			try{
				br = new BufferedReader(new FileReader(fName));
			}
			catch(FileNotFoundException e4){
				System.out.println("Still could not find the file. Exhausted Attempts. Program will now exit now.");
				System.exit(0);
			}
		}
		System.out.println();
		printFromFile(br);
		input.close();
		System.out.println("----------------------<3----------------------\nBye bye, take care!\nFeel free to run my code as much as you like.\nDon't forget to leave a 11/10 rating!\n----------------------<3----------------------");
	}
}
