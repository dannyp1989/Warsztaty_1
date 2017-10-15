package pl.coderslab.dannyp1989.cube;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

class cube {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		cubeThrow();
		while ( true) {
			System.out.println("Maybe one more time? Y / N");
			String yesNo = scan.next();
			if ( yesNo.equalsIgnoreCase("y")) {
				cubeThrow();
			}else if (yesNo.equalsIgnoreCase("n")) {
				break;
			}else {
				
			}
		}

	}
	static int cubeThrow () {
		Scanner scan = new Scanner(System.in);
		Random generator = new Random();
		int cubeThrow = 0;
		String throwType = "";
		int throwCount = 1;
		int cube;
		int addedValue = 0;
		int cubeGeneratorValue;

		cubeThrowRules();
		while (true) {
			throwType = scan.nextLine();
			while ( throwType.indexOf('D') == -1 ){
				System.out.println("Coś nie tak z zapisem rodzaju rzutu. Skup się." 
						+ "\nTo Twój kod: " + throwType + ". Pasuje do wzoru: xDy+z?");
				throwType = scan.nextLine();
			}
			StringTokenizer tok = new StringTokenizer(throwType, "D+-");
			if (tok.countTokens() == 1) {
				try {
					cube = Integer.parseInt(tok.nextToken());
					if (cube == 3 || cube == 4 || cube == 6 || cube == 8 || 
							cube == 10 || cube == 12 || cube == 20 || cube == 100) {
						break;
					} else {
						System.out.println("Żle podawa wartość kostki. Może jeszcze raz zasady:");
						cubeThrowRules();
					}
				} catch (NumberFormatException e) {
					System.out.println("Rodzaj kostki nie jest wartością liczbową");
				}
			}else if (tok.countTokens() == 2) {	
				if ( (throwType.indexOf('+') != -1 || throwType.indexOf('-') != -1 ) && throwType.charAt(0) == 'D') {
					try {
						cube = Integer.parseInt(tok.nextToken());
						if (cube == 3 || cube == 4 || cube == 6 || cube == 8 || 
								cube == 10 || cube == 12 || cube == 20 || cube == 100) {
							try {
								addedValue = Integer.parseInt(tok.nextToken());
								break;
							}catch (NumberFormatException e) {
								System.out.println("Dodawana wartość nie jest wartością liczbową");
							}
						} else {
							System.out.println("Żle podawa wartość kostki. Może jeszcze raz zasady:");
							cubeThrowRules();
						}
					} catch (NumberFormatException e) {
						System.out.println("Rodzaj kostki nie jest wartością liczbową");
					}
				}else {
					try {
						throwCount = Integer.parseInt(tok.nextToken());
						try {
							cube = Integer.parseInt(tok.nextToken());
							if (cube == 3 || cube == 4 || cube == 6 || cube == 8 || 
									cube == 10 || cube == 12 || cube == 20 || cube == 100) {
								break;
							} else {
								System.out.println("Żle podawa wartość kostki. Może jeszcze raz zasady:");
								cubeThrowRules();
							}
						} catch (NumberFormatException e) {
							System.out.println("Rodzaj kostki nie jest wartością liczbową");
						}
					}catch (NumberFormatException e) {
						System.out.println("Ilość rzutów nie jest wartością liczbową");
					}
				}
			}else if (tok.countTokens() == 3) {
				try {
					throwCount = Integer.parseInt(tok.nextToken());
					try {
						cube = Integer.parseInt(tok.nextToken());
						if (cube == 3 || cube == 4 || cube == 6 || cube == 8 || 
								cube == 10 || cube == 12 || cube == 20 || cube == 100) {
							try {
								addedValue = Integer.parseInt(tok.nextToken());
								break;
							}catch (NumberFormatException e) {
								System.out.println("Dodawana wartość nie jest wartością liczbową");
							}
						} else {
							System.out.println("Żle podawa wartość kostki. Może jeszcze raz zasady:");
							cubeThrowRules();
						}
					} catch (NumberFormatException e) {
						System.out.println("Rodzaj kostki nie jest wartością liczbową");
					}
				}catch (NumberFormatException e) {
					System.out.println("Ilość rzutów nie jest wartością liczbową");
				}
			}else {
				System.out.println("Coś nie tak z zapisem rodzaju rzutu. Skup się." 
						+ "\nTo Twój kod: " + throwType + ". Pasuje do wzoru: xDy+z?");
				}
			}

		
		cubeGeneratorValue = generator.nextInt(cube) + 1;
		if ( throwType.indexOf('-') == -1) {
			cubeThrow = throwCount * cubeGeneratorValue + addedValue;
		}else {
			cubeThrow = throwCount * cubeGeneratorValue - addedValue;
			if ( cubeThrow < 0 ) {
				cubeThrow = 0;
			}
		}
		System.out.println("Wynik rzutu kością D" + cube + " to = " + cubeGeneratorValue);
		System.out.println("Całkowity wynik: " + throwType + " to = " + cubeThrow);
		return cubeThrow;
	}
	static void cubeThrowRules () {
		System.out.println("Podaj rodzaj rzutu zgodnie ze schematem");
		System.out.println("xDy+z gdzie:");
		System.out.println("x - ilość rzutów \ny - ilość boków kostki (3,4,6,8,10,12,20,100)\nz - wartość dodana do rzutów");
		System.out.println("np. 2D10+13 - oznacz 2 rzuty kością 10-ścienną i dodanie do nich wartości 13");
	}
}
