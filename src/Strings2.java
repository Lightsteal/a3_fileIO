
// *******************************************************************
// Strings2.java By: Aiman Hanna (C) 1993 - 2016
// This program illustrates the StringTokenizer class. 
// 
// Key Points: 
//	1) StringTokenizer class
// ******************************************************************* 
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer; // must import that package to use StringTokenizer

public class Strings2 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		String st1, st2, word;

		int count, i;

		System.out.print("Please Enter a one line string: ");
		st1 = kb.nextLine();

		StringTokenizer stknz1 = new StringTokenizer(st1);

		System.out.println("\nHere are the words of your string: ");

		count = stknz1.countTokens();

		for (i = 1; i <= count; i++) {
			word = stknz1.nextToken();

			System.out.println("Word # " + i + ": " + word);

		}

		System.out
				.print("\nPlease Enter a one line string; different parts of your string should be separated by ##: ");
		st2 = kb.nextLine();

		// create another object of StringTokenizer, but change the delimiter
		// from the default
		// white space to ##
		StringTokenizer stknz2 = new StringTokenizer(st2, "##");

		System.out.println("\nHere are the parts of your string: ");

		count = stknz2.countTokens();

		for (i = 1; i <= count; i++) {
			word = stknz2.nextToken();

			System.out.println("Part # " + i + ": " + word);

		}
		kb.close();
	}


	/*
	 * The Output Please Enter a one line string: Who knows where the roads will
	 * lead us, only a fool would say!
	 * 
	 * Here are the words of your string: Word # 1: Who Word # 2: knows Word #
	 * 3: where Word # 4: the Word # 5: roads Word # 6: will Word # 7: lead Word
	 * # 8: us, Word # 9: only Word # 10: a Word # 11: fool Word # 12: would
	 * Word # 13: say!
	 * 
	 * Please Enter a one line string; different parts of your string should be
	 * separated by ##: The##first##duty##of society##is justice.
	 * 
	 * Here are the parts of your string: Part # 1: The Part # 2: first Part #
	 * 3: duty Part # 4: of society Part # 5: is justice.
	 * 
	 */

//	public static void processFilesForValidation(PrintWriter pw1, PrintWriter pw2, PrintWriter pw3, Scanner sc,
//			int count, int invalids, File f1, File f2, File f3, File fread) {
//		String avalue = null, jvalue = null, tvalue = null, vol = null, number = null, page = null, month = null,
//				yr = null, doi = null;
//		String s1 = "";
//		int acmCount = 1;
//		while (sc.hasNextLine()) {
//			s1 = sc.nextLine();
//			try {
//				if (getAuthors(s1) != null) {
//					avalue = getAuthors(s1);
//				}
//				if (getTitle(s1) != null) {
//					tvalue = getTitle(s1);
//				}
//				if (getJournals(s1) != null) {
//					jvalue = getJournals(s1);
//				}
//				if (getVolume(s1) != null) {
//					vol = getVolume(s1);
//				}
//				if (getNumber(s1) != null) {
//					number = getNumber(s1);
//				}
//				if (getPage(s1) != null) {
//					page = getPage(s1);
//				}
//				if (getMonth(s1) != null) {
//					month = getMonth(s1);
//				}
//				if (getYear(s1) != null) {
//					yr = getYear(s1);
//				}
//				if (getDOI(s1) != null) {
//					doi = getDOI(s1);
//				}
//
//				if (avalue != null && jvalue != null && tvalue != null && vol != null && number != null && page != null
//						&& month != null && yr != null) {
//					pw1.println(formatIEEE(avalue, jvalue, tvalue, vol, number, page, month, yr) + "\n");
//					pw2.println("[" + acmCount + "] " + formatACM(avalue, jvalue, tvalue, vol, number, page, yr, doi)
//							+ "\n");
//					pw3.println(formatNJ(avalue, jvalue, tvalue, vol, page, yr) + "\n");
//					avalue = null;
//					jvalue = null;
//					tvalue = null;
//					vol = null;
//					number = null;
//					page = null;
//					month = null;
//					yr = null;
//					doi = null;
//					acmCount++;
//				}
//			} catch (FileInvalidException e1) {
//				System.out.println("===============ERROR===============");
//				System.out.println("Problem Deteted with input file: " + fread);
//				System.out.println("File is Invalid: Field \"" + e1.getMessage()
//						+ "\" is empty.\nProcess Stopped, may have other empty fields!\n");
//				pw1.close();
//				pw2.close();
//				pw3.close();
//				f1.delete();
//				f2.delete();
//				f3.delete();
//				sc.close();
//				invalids++;
//				break;
//			}
//		}

}

