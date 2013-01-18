package org.iwt2.asteroids.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public class Camera {

	float w;
	float h;
	OrthographicCamera camera;
	
	
	public Camera() {
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
		
	}

	public void unproject(Vector3 v) {
		this.camera.unproject(v);
	}

	public void update(SpriteBatch batch) {
		camera.update();
		batch.setProjectionMatrix(camera.combined);	
	}

	public int getWidth() {
		return (int)w;
	}

	public int getHeight() {
		return (int)h;
	}

	public Matrix4 getCombined() {
		return camera.combined;
	}
	
	
	
}
