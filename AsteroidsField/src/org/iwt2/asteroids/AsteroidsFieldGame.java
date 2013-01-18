package org.iwt2.asteroids;

import org.iwt2.asteroids.model.SpaceWorld;
import org.iwt2.asteroids.view.*;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

public class AsteroidsFieldGame implements ApplicationListener {

	int GAME = 1;
	int GAMEOVER = 2;
	int mode = GAME;
	
	GameView view;
	Input input;
	SoundSystem sounds;
	SpaceWorld world;
	
	FPSLogger log;
	
	@Override
	public void create() {	
		createViewObjects();
		createModelObjects();
		
		log = new FPSLogger() ;
	}

	private void createModelObjects() {
		world = new SpaceWorld(this.view);
	}

	private void createViewObjects() {
		Camera camera;
		camera = new Camera();
		this.view = new GameView(camera);
		this.input = new Input(camera);
		this.sounds = new SoundSystem();
		this.sounds.playMusic();
	}

	@Override
	public void dispose() {
		this.view.dispose();
		this.sounds.dispose();
	}

	@Override
	public void render() {
		log.log();
		
		if (mode == GAMEOVER) {
			this.view.paintGameOver(world);
			return;
		}
		updateWorld();
		checkCollisions();
		this.view.paint(world);
	}

	private void checkCollisions() {
		if (this.world.isShipCollidingWithAsteroid()) {
			this.sounds.playCollitionSound();
			if (this.world.isGameOver()) {
				this.mode = GAMEOVER;
				this.sounds.stopMusic();
			}
		}
	}

	private void updateWorld() {
		Vector3 playerPos = this.input.screenTouchedPoint();
		this.world.update(Gdx.graphics.getDeltaTime(), playerPos);
		
	}

	//-----------------------------------------------------
	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
		// Implementar
	}

	@Override
	public void resume() {
		// Implementar
	}
}
