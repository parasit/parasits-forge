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

		for (int x=0; x < this.elementCount; x++) {
			tEffect = this.elementAt(x);
			if (tEffect.getEffectTTL() > 0) {
				tEffect.doEffect(parent);
			}
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
