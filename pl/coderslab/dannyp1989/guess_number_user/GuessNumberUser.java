package pl.coderslab.dannyp1989.guess_number_user;

import java.util.Scanner;

class GuessNumberUser {

	public static void main(String[] args) {
		guessNumberUserVersion();

	}
	static void guessNumberUserVersion() {
		Scanner scan = new Scanner(System.in);
		int win = 0;
		int number = 500;
		int min = 1;
		int max = 1000;
		int counter = 1;
		String instruction = "";
		String upper = "wyższa";
		String lower = "niższa";
		String winning = "trafione";
		
		
		System.out.println("Pomyśl liczbę z zakresu 1 - 1000, a ja ją zgadne w maksymalnie 10 ruchach." + 
		"\nKomputer zawsze wyrgywa!!" + "\nPomyślałeś liczbę? Tak? No to zaczynamy!\nW ramach wyjaśnienia "
				+ "po każdym ruchu musisz wskazać czy Twoja liczba jest wyższa czy niższa niż wskazana."
				+ "\nWskazania dokonasz za pomocą komend \"wyższa\" / \"niższa\" oraz \"trafione\"" );
		while ( win == 0) {
			System.out.println("Próba " + counter);
			System.out.println("Może pomyślałeś/aś o liczbie " + number + " ? :)");
			System.out.println(" \"wyższa\" \"niższa\" \"trafione\"");
			instruction = scan.next();
			if (instruction.equals(upper)) {
				counter++;
				min = number;
				number = (number + max) / 2;
			}else if (instruction.equals(lower)) {
				counter++;
				max = number;
				number = (min + number) / 2;
			}else if (instruction.equals(winning)) {
				win = 1;
				System.out.println("Wygrana w " + counter + " próbie");
				
			}else {
				System.out.println("Niepoprawna komenda, spróbuj jeszcze raz");
			}	
		}
	}
}
