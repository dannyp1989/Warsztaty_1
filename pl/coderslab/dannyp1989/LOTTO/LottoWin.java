package pl.coderslab.dannyp1989.LOTTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class LottoWin {

	public static void main(String[] args) {
		int counter = 1;
		int win = 0;
		while ( win != 6) {
			System.out.println("Próba " + counter++);
			win = lottoWin();
			System.out.println();
			System.out.println();
		}
	}
	static int lottoWin() {
		Random generator = new Random();
		int[] myNumbers = new int[6];
		Integer[] lottoNumbers = new Integer[49];
		int[] lottoNumbersLast = new int[6];
		int number = 0;
		int pause = 0;
		int price = 0;

		for ( int i = 0; i < myNumbers.length ; i++) {
			while (true) {
				number = generator.nextInt(49) + 1;
				for ( int j = 0 ; j < i; j ++) {
					pause = 0;
					if (number == myNumbers[j]) {
						pause = 1;
						break;
					}
				}
				if ( pause == 0) {
					myNumbers[i] = number;
					break;
				}
			}
		}	
		Arrays.sort(myNumbers);

		for (int i = 0 ; i < lottoNumbers.length ; i++) {
			lottoNumbers[i] = i + 1;
		}

		Collections.shuffle(Arrays.asList(lottoNumbers));

		for ( int i = 0 ; i < lottoNumbersLast.length ; i++) {
			lottoNumbersLast[i] = lottoNumbers[i];
		}
		Arrays.sort(lottoNumbersLast);
		System.out.println("Moje liczby: " + Arrays.toString(myNumbers));
		System.out.println("Liczby wylosowane: " + Arrays.toString(lottoNumbersLast));

		for ( int i = 0 ; i < myNumbers.length ; i++) {
			for ( int j = 0 ; j < myNumbers.length ; j++) {
				if (myNumbers[i] == lottoNumbersLast[j]) {
					price++;
					break;
				}
			}
		}
		System.out.println("Trafione: " + price);
		return price;
	}
}
