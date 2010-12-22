package ibu.forge.basics;

public abstract class Being {
	public Attribute Strenght;
	public Attribute Dexterity;
	public Attribute Inteligence;
	public Attribute Health;

	public Attribute HitPoints;
	public Attribute ManaPoints;
	
	EffectList currentEffects;

	public Being(int strength, int dexterity, int inteligence, int health) {
		this.Strenght = new Attribute(strength);
		this.Dexterity = new Attribute(dexterity);
		this.Inteligence = new Attribute(inteligence);
		this.Health = new Attribute(health);
		this.HitPoints = new Attribute(health * 2);
		this.ManaPoints = new Attribute(inteligence * 2);
		currentEffects = new EffectList(this);
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
	
	public void doEffects() {
		currentEffects.doEffects();
	}
	
	public void addEffect(Effect e) {
		currentEffects.add(e);
	}

	public void getDamage(int type, int material, int value) {
		this.HitPoints.setCurValue(this.HitPoints.getCurValue() - value);
	}

	public void getEffect(int type, int value) {
		if (type == Constans.EFFECT_HEAL) {
			if (this.HitPoints.getValue() <= this.HitPoints.getCurValue() + value) {
				this.HitPoints.setCurValue(this.HitPoints.getValue());
			} else {
				this.HitPoints.setCurValue(this.HitPoints.getCurValue() + value);
			}
		}
	}
}
