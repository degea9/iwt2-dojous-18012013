package org.iwt2.asteroids.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

public class Input {

	Camera cam;
	Vector3 vector;
	
	public Input (Camera cam) {
		this.cam = cam;
		vector = new Vector3(this.cam.getWidth()/2, this.cam.getHeight() -30, 0);
		this.cam.unproject(vector);
	}
	
	/**
	 * 
	 * @return null if screen has not been touched
	 */
	public Vector3 screenTouchedPoint() {
		if (Gdx.input.isTouched() ) {		
			vector.x = Gdx.input.getX();
			this.cam.unproject(vector);
			vector.y = 30;
		}
		return vector;
	}
}
