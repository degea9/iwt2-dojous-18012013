package org.iwt2.asteroids.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class PlayerShip extends SpaceEntity {
	
	int energyField;
	int despX;

	//public PlayerShip(Rectangle bounds) {
	public PlayerShip(float xInit, float yInit, Vector2 size) {
		super(new Rectangle(xInit, yInit, size.x, size.y), null, null);
		energyField = 3;
		despX = (int)size.x / 2;
	}

	public void update(Vector3 playerPos, Vector2 worldSize) {
		bounds.x = playerPos.x - despX;
		bounds.y = playerPos.y;
		
		if (bounds.x < 0) {
			bounds.x = 0;
		}
		if ((bounds.x + despX + despX) > worldSize.x) {
			bounds.x = worldSize.x - despX -despX;
		}
	}

	
	public String getEnergyField() {
		return String.valueOf(energyField);
	}


	public void decreasePowerShield() {
		assert energyField > 0;
		this.energyField--;
	}

	public boolean isEnergyFieldEmpty() {
		return this.energyField == 0;
	}
}
