package ibu.forge.basics;

public class Effect {

	public static final int EFFECT_DAMAGE_PHISICAL = 1;
	public static final int EFFECT_DAMAGE_MAGIC = 2;
	public static final int EFFECT_DAMAGE_POISON = 3;
	public static final int EFFECT_DAMAGE_COLD = 4;
	public static final int EFFECT_DAMAGE_FIRE = 5;
	public static final int EFFECT_DAMAGE_ACID = 6;
	public static final int EFFECT_DAMAGE_ELECTRIC = 7;
	public static final int EFFECT_DAMAGE_WATER = 8;
	public static final int EFFECT_DAMAGE_LIGHT = 9;
	public static final int EFFECT_DAMAGE_DARKNES = 10;

	// Heal
	public static final int EFFECT_HEAL = 100;

	int effectType;
	int effectTTL;
	String effectPower = "";
	int effectMaterial = Constans.MATERIAL_NONE;

	public Effect(int type, int ttl) {
		this.effectType = type;
		this.effectTTL = ttl;
	}

	public Effect(int type, int ttl, String power) {
		this.effectType = type;
		this.effectTTL = ttl;
		this.effectPower = power;
	}
	
	public Effect(int type, int ttl, int material, String power) {
		this.effectType = type;
		this.effectTTL = ttl;
		this.effectMaterial = material;
		this.effectPower = power;
	}


	public int getEffectType() {
		return effectType;
	}

	public void setEffectType(int effectType) {
		this.effectType = effectType;
	}

	public int getEffectTTL() {
		return effectTTL;
	}

	public void setEffectTTL(int effectTTL) {
		this.effectTTL = effectTTL;
	}

	public String getEffectPower() {
		return effectPower;
	}

	public void setEffectPower(String effectPower) {
		this.effectPower = effectPower;
	}

	public void tick() {
		if (this.effectTTL > 0) {
			this.effectTTL--;
		}
	}

	public void doEffect(Being parent) {
		int power = 0;
		Dices dice = new Dices();
		power = dice.DiceThrow(getEffectPower());
		power = checkModifiers(parent, power);
		switch (getEffectType()) {
		case EFFECT_HEAL:
			parent.log(1, "Heal " + power + " points");
			power *= -1;
			break;

		case EFFECT_DAMAGE_PHISICAL:
			power -= parent.getDamageResistance();
			parent.log(1, "Get " + power + " damage points");
			break;
			
		case EFFECT_DAMAGE_FIRE:
			power -= parent.getDamageResistance();
			parent.log(1, "Get " + power + " fire damage points");
			break;
		}
		if (power != 0) {
			parent.doDamage(power);
		}
		tick();
	}
	
	public int checkModifiers(Being parent, int power) {
		int result = 0;
		boolean hasResistance = parent.hasResistance(effectType);
		boolean isVulnerable = parent.isVulnerable(effectType);
		if (hasResistance) {
			result = Math.round(power / 2);
		}
		if (isVulnerable) {
			result = power * 2;
		}
		return result;
	}

}
