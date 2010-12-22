package ibu.forge.basics;

import java.util.Random;

public class Dices {
	int sides;
	Random random;

	public Dices() {
		this.random = new Random();
	}

	public int DiceThrow(int sides) {
		return this.random.nextInt(sides) + 1;
	}

	public int DiceThrow(String dices) {
		int result = 0;
		int sides, times;
		String tmp[];
		if (dices.matches("^\\d*[d]\\d*$")) {
			tmp = dices.split("d");
			sides = new Integer(tmp[1]);
			if (tmp[0].length() != 0) {
				times = new Integer(tmp[0]);
				if (times < 1) {
					times = 1;
				}
			} else {
				times = 1;
			}
			result = doThrows(sides, times);
		}
		return result;
	}

	public int doThrows(int sides, int times) {
		int result = 0;
		for (int x = 0; x < times; x++) {
			result += DiceThrow(sides);
		}
		return result;
	}

	public int d100() {
		return this.DiceThrow(100);
	}

	public int d20() {
		return this.DiceThrow(20);
	}

	public int d12() {
		return this.DiceThrow(12);
	}

	public int d10() {
		return this.DiceThrow(10);
	}

	public int d6() {
		return this.DiceThrow(6);
	}

	public int d4() {
		return this.DiceThrow(4);
	}
}
