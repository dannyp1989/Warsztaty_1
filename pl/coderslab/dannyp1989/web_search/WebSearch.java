package pl.coderslab.dannyp1989.web_search;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


class WebSearch {

	public static void main(String[] args) {
		String site = "https://www.chelseafc.com/";
		String fileName = "webSearch";
		popularWords(site, fileName);
	}
	static void popularWords(String website, String fileName) {
		Connection connect = Jsoup.connect(website);
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(fileName + ".txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			Document document = connect.get();
			Elements links = document.select("span.title");
			for (Element elem : links) {
				StringTokenizer tok = new StringTokenizer(elem.text(), " '\"");
				while ( tok.hasMoreTokens()) {
					String tokX = tok.nextToken();
					String[] tokXs = tokX.split("[^a-zA-Z]");
					tokX = String.join("", tokXs);
					if (tokX.length() > 3) {
						out.append(tokX).append("\n");
					}
				}
			}
			System.out.println("Stworzono plik: " + fileName + ".txt");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Path path = Paths.get(fileName + ".txt");
		List<String> listOfWords = new ArrayList<String>();
		
		try {
			listOfWords = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] arrayOfWords = new String[listOfWords.size()];
		for (int i = 0 ; i < arrayOfWords.length ; i++) {
			arrayOfWords[i] = listOfWords.get(i);
		}
		Collections.sort(Arrays.asList(arrayOfWords));
		System.out.println(Arrays.toString(arrayOfWords));
		
		List<Integer> iOfNewWords = new ArrayList<Integer>();

		for ( int i = 0 ; i < arrayOfWords.length ; i++) {
			if (i == 0) {
				iOfNewWords.add(i);
			}else if ( !arrayOfWords[i].equals(arrayOfWords[i-1]))  {
				iOfNewWords.add(i);
			}
				
		}
		int[] newWords = new int[iOfNewWords.size()];
		for ( int i = 0; i < iOfNewWords.size(); i++) {
			newWords[i] = iOfNewWords.get(i);
		}
		
		int[][] sortowanie = new int[newWords.length][2];
		for ( int i = 0 ; i < newWords.length ; i++) {
			for (int j = 0; j < sortowanie[i].length ; j++) {
				if ( j == 0) {
					sortowanie[i][j] =newWords[i];
				} else if (j ==1) {
					if ( i == newWords.length - 1) {
						sortowanie[i][j] = arrayOfWords.length - newWords[i];
					} else {
						sortowanie[i][j] = newWords[i+1] - newWords[i];
					}	
				}
			}
			
		}
		
		int count = 1;
		while ( count < sortowanie.length) {
			for ( int i = 0 ; i < sortowanie.length -1 ;i++) {
				int[] temp = new int[2];
				for ( int j = 1 ; j < 2; j++) {
					if (sortowanie[i][j] >= sortowanie [i+1][j]) {
					} else {
						temp = sortowanie[i];
						sortowanie[i] = sortowanie[i+1];
						sortowanie[i+1] = temp;
					}

				}
			}
			count++;
		}

//		//wydruk tablicy dwuwymiarowej
//		for (int i = 0 ; i < sortowanie.length ; i++) {
//			for (int j = 0; j < sortowanie[i].length ; j++) {
//				if ( j== 0) {
//				System.out.print(arrayOfWords[sortowanie[i][j]] + " ");	
//				} else {
//					System.out.print(sortowanie[i][j]);
//				}
//			}
//			System.out.println();
//		}
//		//koniec wydruku
		
		PrintWriter out2 = null;
		try {
			out2 = new PrintWriter(fileName + "_most_popular_words.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for ( int i = 0; i < 3 ; i++) {
			out2.append(arrayOfWords[sortowanie[i][0]] + " " + sortowanie [i][1] + "\n");
		}

		out2.close();
	}

}
