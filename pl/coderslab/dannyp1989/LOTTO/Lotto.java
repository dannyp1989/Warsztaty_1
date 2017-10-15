package pl.coderslab.dannyp1989.LOTTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Lotto {

	public static void main(String[] args) {
		lotto();
	}
	static void lotto() {
		Scanner scan = new Scanner(System.in);
		int[] yourNumbers = new int[6];
		int yourNumber;
		System.out.println("Gramy w lotto.\nJest milion powodów, żeby nie grać!!\nAle Ty graj z nami");
		for ( int i = 0; i < yourNumbers.length ; i++) {
			while(true) {
				System.out.println("Podaj liczbę " + (i + 1) + " z zakresu 1 - 49:");
				while( !scan.hasNextInt() ) {
					scan.next();
					System.out.println("Tak się nie bawimy, to musi być liczba!!");
				}
				yourNumber = scan.nextInt();
				if ( yourNumber < 1 || yourNumber > 49) {
					System.out.println("Liczba z zakresu 1 - 49 amatorze łatwych pieniędzy!!!");
				}else {
					int pause = 0;
					for ( int j = 0; j < i ; j ++) {
						if ( yourNumbers[j] == yourNumber ) {
							pause = 1;
						}
					}
					if ( pause == 0) {
						yourNumbers[i] = yourNumber;
//						System.out.println(yourNumbers[i]);
//						System.out.println(Arrays.toString(yourNumbers));
						break;
					}else
						System.out.println("Taką liczbę już podałeś, podaj inną!!");
				}
			}

		}
		Arrays.sort(yourNumbers);
		//System.out.println("Twoje liczby: " + Arrays.toString(yourNumbers));
		//mam juz 6 liczb od uzytkownika
		Integer[] lottoNumbersList = new Integer[49];
		for (int i = 0; i < lottoNumbersList.length; i++) {
			lottoNumbersList[i] = i + 1;
		}
//		System.out.println(Arrays.toString(lottoNumbersList));
		Collections.shuffle(Arrays.asList(lottoNumbersList));
//		System.out.println(Arrays.toString(lottoNumbersList));
		int[] lottoNumbers = new int[6];
		for ( int i = 0; i < lottoNumbers.length ; i++) {
			lottoNumbers[i] = lottoNumbersList[i];
		}
		Arrays.sort(lottoNumbers);
		int trafione = 0;
		for ( int i = 0; i < lottoNumbers.length ; i++) {
			for ( int j = 0 ; j < lottoNumbers.length ; j++) {
				if ( lottoNumbers[i] == yourNumbers[j] ) {
					trafione++;
					break;
				}
			}
		}
		System.out.println("Twoje liczby " + Arrays.toString(yourNumbers));
		System.out.println("Wylosowane liczby " + Arrays.toString(lottoNumbers));
		System.out.println("Trafiłeś " + trafione );
		if (trafione > 6) {
			System.out.println("Zostałeś milionerem!!!!!!");
		}
	}
}
