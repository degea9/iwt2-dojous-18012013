package org.iwt2.asteroids.model;

import java.util.Iterator;

import org.iwt2.asteroids.view.GameView;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class SpaceWorld {

	PlayerShip ship;
	Array<Asteroid> asteroids;
	Vector2 asteroidSize;
	Vector2 asteroidVel;
	Vector2 worldSize;
	TimeEvent newAsteroidEvent;
	
	public SpaceWorld(GameView gv) {
		asteroids = new Array<Asteroid>();
		
		this.worldSize = new Vector2(gv.getScreenWidht(), gv.getScreenHeight());
		
		this.asteroidSize = gv.getAsteroidSize();	
		ship = new PlayerShip(worldSize.x / 2, 100, gv.getShipSize());

		newAsteroidEvent = new TimeEvent(2000);
	}

	
	public void update(float delta, Vector3 playerPos) {
		this.ship.update(playerPos, this.worldSize);
		//System.out.println("Player pos: " + playerPos);
		
		updateAsteroids(delta);
		
		checkCreateNewAsteroid();
	}


	private void updateAsteroids(float delta) {
		Iterator<Asteroid> it = this.asteroids.iterator();
		Asteroid a;
		
		while (it.hasNext()) {
			a = it.next();
			a.update(delta);
			if (a.isOutOfWorld(this.worldSize)) {
				it.remove();
			}
		}
	}


	private void checkCreateNewAsteroid() {
		if (this.newAsteroidEvent.expired()) {
			float x = MathUtils.random(0, this.worldSize.x - this.asteroidSize.x);
			asteroids.add(new Asteroid(x, this.worldSize.y + this.asteroidSize.y, this.asteroidSize));

			
			this.newAsteroidEvent.reset();
		}		
	}


	public boolean isShipCollidingWithAsteroid() {
		Iterator<Asteroid> it = asteroids.iterator();
		Asteroid as;
		
		while(it.hasNext()) {
			as = it.next();
			if (as.overlapsWith(this.ship)) {
				it.remove();
				ship.decreasePowerShield();
				return true;
			}
		}
		
		return false;
	}


	/**
	 * El juego termina si la nave se queda sin energía
	 * @return
	 */
	public boolean isGameOver() {
		return this.ship.isEnergyFieldEmpty();
	}


	public Array<Asteroid> getAsteroids() {
		return this.asteroids;
	}


	public PlayerShip getPlayerShip() {
		return this.ship;
	}
}
