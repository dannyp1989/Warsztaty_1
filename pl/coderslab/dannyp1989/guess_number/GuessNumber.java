package pl.coderslab.dannyp1989.guess_number;

import java.util.Random;
import java.util.Scanner;

class GuessNumber {
	public static void main(String[] args) {
		guessNumber();
	}
	static void guessNumber() {
		Random generator = new Random();
		int generatedNumber = generator.nextInt(100) + 1;
		Scanner scan = new Scanner(System.in);
		int yourNumber;
		int count = 0;
		while (true) {
			System.out.println("Podaj liczbę z zakresu 1 - 100:");
			while( !scan.hasNextInt() ) {
				System.out.println("Nie podałeś wartości z zakresu 0 - 100.\n Podaja wartość 0 - 100.");
				scan.next();
			}
			yourNumber = scan.nextInt();
			if (yourNumber > generatedNumber) {
				System.out.println("Podałeś za wysoką liczbę");
			}else if (yourNumber < generatedNumber) {
				System.out.println("Podałeś za niską liczbę");
			}else {
				System.out.println("Wygrałeś");
				break;
			}
			count++;
			if (count > 20) {
				System.out.println("Dziecko w podstawówce by to ogarneło!!!!");
			}else if (count > 15) {
				System.out.println("Chyba nie można gorzej!!!");
			}else if (count > 10) {
				System.out.println("Ogarnij się!!");
			}else if (count > 5) {
				System.out.println("Byli w tej gre lepsi!");
			}
		}
		
	}
}
