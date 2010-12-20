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
