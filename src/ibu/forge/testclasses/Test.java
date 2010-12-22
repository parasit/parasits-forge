package ibu.forge.testclasses;

import ibu.forge.basics.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPlayer pp;
		int[] tmp = {-Effect.EFFECT_DAMAGE_FIRE};
		pp = new TestPlayer(5, 5, 5, 15, tmp);

		Effect e,e2;
		e = new Effect(Effect.EFFECT_HEAL, 3, "2d6");
		e2 = new Effect(Effect.EFFECT_DAMAGE_FIRE, 1, "d6");
		pp.addEffect(e);
		System.out.println(pp.getCurrentHitPoints());
		for (int x = 0; x < 10; x++) {
			pp.doEffects();
			e2.doEffect(pp);
			System.out.println(pp.getCurrentHitPoints());
		}
		

		if (pp.isAlive()) {
			System.out.println("Its alive");
		} else {
			System.out.println("Its dead");
		}
	}

}
