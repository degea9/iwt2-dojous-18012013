package org.iwt2.asteroids.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundSystem {
	
	Sound snakeInHouse;
	Sound snakeDies;
	Sound addArrow;
	Sound touchButton;
	Sound enterHouse;
	Sound snakeHitsArrow;
	Sound removeArrow;
	
	Sound moreNebels;
	Music gameMusic;
	
	public SoundSystem() {
		
		//snakeInHouse = Gdx.audio.newSound(Gdx.files.internal("sounds/snakeInHouse.ogg"));
		snakeDies = Gdx.audio.newSound(Gdx.files.internal("data/snakeDies.ogg"));
		/*addArrow = Gdx.audio.newSound(Gdx.files.internal("sounds/addArrow.ogg"));
		touchButton = Gdx.audio.newSound(Gdx.files.internal("sounds/arrowButtonTouched.ogg"));
		enterHouse = Gdx.audio.newSound(Gdx.files.internal("sounds/enterHouse.ogg")); 
		snakeHitsArrow = Gdx.audio.newSound(Gdx.files.internal("sounds/snakeHitsArrow.ogg"));
		removeArrow = Gdx.audio.newSound(Gdx.files.internal("sounds/removeArrow.ogg"));
		moreNebels = Gdx.audio.newSound(Gdx.files.internal("sounds/moreNebels.ogg"));
		*/
		gameMusic = Gdx.audio.newMusic(Gdx.files.internal("data/tyrian.mp3"));
		this.gameMusic.setLooping(true);
	}

	
	/**
	 */
	public void dispose() {
		snakeDies.dispose();
		
		/*
		snakeInHouse.dispose();
		
		addArrow.dispose();
		touchButton.dispose();
		moreNebels.dispose();
		enterHouse.dispose();
		snakeHitsArrow.dispose();
		removeArrow.dispose();
		*/
		gameMusic.dispose();
	}
	
	public void playRemoveArrow() {
		this.removeArrow.play();
	}
	
	public void playSnakeInHouseSound() {
		snakeInHouse.play();
	}

	public void playCollitionSound() {
		snakeDies.play();
	}

	public void playButtonTouchedSound() {
		this.touchButton.play();
	}

	public void playAddArrowSound() {
		addArrow.play();
	}
	
	public void playSnakeHitsArrow() {
		this.snakeHitsArrow.play();
	}
	
	
	public void playMusic() {
		this.gameMusic.play();
	}

	public void stopMusic() {
		this.gameMusic.stop();
	}

	
	
	public void playMoreNebels() {
		this.moreNebels.play();
	}

	public void playEnterHouse() {
		this.enterHouse.play();
	}

}
