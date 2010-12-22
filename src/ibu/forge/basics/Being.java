package ibu.forge.basics;

public abstract class Being {
	Attribute Strenght;
	Attribute Dexterity;
	Attribute Inteligence;
	Attribute Health;

	Attribute HitPoints;
	Attribute ManaPoints;
	
	Attribute PassiveDefence;
	Attribute DamageResistance;
	
	EffectList currentEffects;
	
	int[] resistances;

	public Being(int strength, int dexterity, int inteligence, int health, int[] resistances) {
		this.Strenght = new Attribute(strength);
		this.Dexterity = new Attribute(dexterity);
		this.Inteligence = new Attribute(inteligence);
		this.Health = new Attribute(health);
		this.HitPoints = new Attribute(health * 2);
		this.ManaPoints = new Attribute(inteligence * 2);
		
		this.PassiveDefence = new Attribute(dexterity);
		this.DamageResistance = new Attribute(0);
		
		this.currentEffects = new EffectList(this);
		
		this.resistances = resistances;
		
	}
	
	public void log(int level, String message) {
		System.out.println(message);
	}
	
	public boolean isAlive() {
		if (HitPoints.CurValue > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void doDamage(int power) {
		HitPoints.CurValue -= power;
	}
	
	public void doEffects() {
		currentEffects.doEffects();
	}
	
	public void addEffect(Effect e) {
		currentEffects.add(e);
	}
	
	public boolean hasResistance(int effectType) {
		for (int x=0;x<resistances.length; x++) {
			if (resistances[x] == effectType) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isVulnerable(int effectType) {
		int tEffectType = effectType * -1;
		for (int x=0;x<resistances.length; x++) {
			if (resistances[x] == tEffectType) {
				return true;
			}
		}
		return false;
	}
	
	public int getCurrentHitPoints() { return HitPoints.CurValue; }
	
	public int getPassiveDefence() { return PassiveDefence.CurValue; }
	public int getDamageResistance() { return DamageResistance.CurValue; }
	
}
