package ibu.forge.basics;

import java.util.Vector;

public class EffectList extends Vector<Effect> {
	static final long serialVersionUID = 1;
	Being parent;
	public EffectList(Being parent) {
		super();
		this.parent = parent;
	}
	
	public void doEffects() {
		Effect tEffect; 
		Dices dice;
		int power;
		dice = new Dices();
		for (int x=0; x < this.elementCount; x++) {
			tEffect = this.elementAt(x);
			switch (tEffect.getEffectType()) {
				case Constans.EFFECT_HEAL:
					power = dice.DiceThrow(tEffect.getEffectPower());
					parent.HitPoints.addCurValue(power);
					parent.log(1, "Heal " + power + " points");
					break;
				
				case Constans.EFFECT_DAMAGE_IMPAILING:
					power = (dice.DiceThrow(tEffect.getEffectPower())) * 2;
					parent.HitPoints.addCurValue(power * -1);
					parent.log(1, "Get " + power + " impaling damage points");
					break;
				
			}
			tEffect.tick();
		}
		int x = 0;
		while (x < this.elementCount) {
			if (this.elementAt(x).getEffectTTL() == 0) {
				this.removeElementAt(x);
			} else {
				x++;
			}
		}
	}
}
