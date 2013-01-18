package org.iwt2.asteroids.model;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid extends SpaceEntity {

	public Asteroid(float xInit, float yInit, Vector2 size) {
		super(new Rectangle(xInit, yInit, size.x, size.y), new Vector2(0, 20), new Vector2(0, -1));
	}
	
	public void update(float delta) {
		bounds.x += velocity.x * delta * direction.x;
		bounds.y += velocity.y * delta * direction.y;
	}
	

	public boolean overlapsWith(SpaceEntity ship) {
		return Intersector.intersectRectangles(this.getBounds(), ship.getBounds());
	}

	public boolean isOutOfWorld(Vector2 worldSize) {
		return this.bounds.x > worldSize.x;
	}

}
