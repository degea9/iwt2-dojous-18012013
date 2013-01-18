package org.iwt2.asteroids.view;


import org.iwt2.asteroids.model.Asteroid;
import org.iwt2.asteroids.model.SpaceWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameView {

	Sprite asteroid;
	Sprite ship;
	Texture textures;
	Texture gameOver;
	Camera cam;
	SpriteBatch batch;
	BitmapFont font;

	ImmediateModeRenderer20 renderer; 
	
	public GameView(Camera cam) {
		textures = new Texture(Gdx.files.internal("data/sprites.png"));
		asteroid = new Sprite(new TextureRegion(textures, 0, 0, 25, 25));
		ship = new Sprite(new TextureRegion(textures, 26, 0, 22, 25));
		
		gameOver = new Texture(Gdx.files.internal("data/gameover.png"));
		
		this.cam = cam;
		batch = new SpriteBatch();
	
		font = new BitmapFont(Gdx.files.internal("data/font16.fnt"), Gdx.files.internal("data/font16.png"), false);
		renderer = new ImmediateModeRenderer20(false, true, 0);

	}
	
	public void dispose() {
		textures.dispose();
		gameOver.dispose();
		font.dispose();
		renderer.dispose();
		batch.dispose();
	}

	public void paint(SpaceWorld world) {
		clearScreen();
		cam.update(batch);
	
		batch.begin();
      	drawShip(world);
      	drawAsteroids(world);
      	batch.end();
      	
      	drawBounds(world);
	}


	private void drawAsteroids(SpaceWorld world) {
		Vector2 v;
		for (Asteroid a: world.getAsteroids()) {
			v = a.getPosition();
			this.asteroid.setPosition(v.x, v.y);
			this.asteroid.draw(this.batch);
		}
	}

	private void drawShip(SpaceWorld world) {
		Vector2 v = world.getPlayerShip().getPosition();
		
		this.ship.setPosition(v.x, v.y);
		this.ship.draw(this.batch);
		font.setColor(Color.MAGENTA);
		font.draw(batch, world.getPlayerShip().getEnergyField(), this.getScreenWidht() - 30, 25);
	}

	private void clearScreen() {
	    Gdx.gl.glClearColor(1f, 1f, 1f, 1);
	      Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	}

	public void paintGameOver(SpaceWorld world) {
		this.paint(world);
		
		float xCentered = (this.getScreenWidht() / 2) - (this.gameOver.getWidth() / 2);
		float yCentered = (this.getScreenHeight() / 2) - (this.gameOver.getHeight() / 2);
		
		batch.begin();
		batch.draw(gameOver, xCentered, yCentered);
		batch.end();
		
	}

	public Vector2 getAsteroidSize() {
		return new Vector2(this.asteroid.getWidth(), this.asteroid.getHeight());
	}

	public Vector2 getShipSize() {
		return new Vector2(this.ship.getWidth(), this.ship.getHeight());
	}

	public int getScreenWidht() {
		return Gdx.graphics.getWidth();
	}

	public float getScreenHeight() {
		return Gdx.graphics.getHeight();
	}

	
	
	private void drawBounds(SpaceWorld world) {
		for (Asteroid a: world.getAsteroids()) {
			this.drawBound(a.getBounds());
		}
		this.drawBound(world.getPlayerShip().getBounds());	
	}

	private void drawBound(Rectangle r) {
		renderer.begin(this.cam.getCombined(), GL10.GL_LINES);
		
		renderer.vertex(r.x, r.y, 0f);
		renderer.vertex(r.x + r.width, r.y, 0f);

		renderer.vertex(r.x + r.width, r.y, 0f);
		renderer.vertex(r.x + r.width, r.y + r.height, 0f);
		
		
		renderer.vertex(r.x + r.width, r.y + r.height, 0f);
		renderer.vertex(r.x, r.y + r.height, 0f);
		
		renderer.vertex(r.x, r.y + r.height, 0f);
		renderer.vertex(r.x, r.y, 0f);
		
		renderer.end();
	}
}
