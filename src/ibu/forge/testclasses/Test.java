package ibu.forge.testclasses;

import ibu.forge.basics.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    // Testowa klasa
		Dices dice;
		TestPlayer pp;
		
		pp = new TestPlayer();
		// TODO Auto-generated method stub
		dice = new Dices();
		
		for (int x = 0; x < 10; x++) {
			System.out.println(dice.d10());
		}
		if (pp.isAlive()) {
			System.out.println("Its alive");
		}
	}

}
