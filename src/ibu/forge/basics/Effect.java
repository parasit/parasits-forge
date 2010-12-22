package ibu.forge.basics;

public class Effect {
	int effectType;
	int effectTTL;
	String effectPower;
	
	public Effect(int type) {
		this.effectType = type;
	}
	
	public Effect(int type, int ttl) {
		this.effectType = type;
		this.effectTTL = ttl;
	}
	
	public Effect(int type, int ttl, String power) {
		this.effectType = type;
		this.effectTTL = ttl;
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
}
