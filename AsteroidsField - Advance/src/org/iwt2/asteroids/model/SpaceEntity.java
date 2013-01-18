package org.iwt2.asteroids.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SpaceEntity {
	
	Rectangle bounds;
	Vector2 velocity;
	Vector2 direction;
	
	public SpaceEntity(Rectangle bounds, Vector2 velocity, Vector2 direction) {
		super();
		this.bounds = bounds;
		this.velocity = velocity;
		this.direction = direction;
	}
	
	
	public Vector2 getPosition() {
		return new Vector2(bounds.x, bounds.y);
	}
	
	public Rectangle getBounds() {
		return this.bounds;
	}

}
