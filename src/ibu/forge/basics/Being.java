package ibu.forge.basics;

public abstract class Being {
	public Attribute Strenght;
	public Attribute Dexterity;
	public Attribute Inteligence;
	public Attribute Health;

	public Attribute HitPoints;
	public Attribute ManaPoints;

	public Being() {
		this.Strenght = new Attribute(0);
		this.HitPoints = new Attribute(0);
	}
	
	public boolean isAlive() {
		if (HitPoints.CurValue > 0) {
			return true;
		} else {
			return false;
		}
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
