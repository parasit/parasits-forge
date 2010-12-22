package ibu.forge.testclasses;

import ibu.forge.basics.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPlayer pp;
		pp = new TestPlayer(5, 5, 5, 15);

		Effect e,e2;
		e = new Effect(Constans.EFFECT_HEAL, 3, "2d6");
		e2 = new Effect(Constans.EFFECT_DAMAGE_IMPAILING, 1, "d6");
		pp.addEffect(e);
		pp.addEffect(e2);
		System.out.println(pp.HitPoints.getCurValue());
		for (int x = 0; x < 10; x++) {
			pp.doEffects();
			System.out.println(pp.HitPoints.getCurValue());
		}

		if (pp.isAlive()) {
			System.out.println("Its alive");
		} else {
			System.out.println("Its death");
		}
	}

}
