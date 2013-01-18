package org.iwt2.asteroids.model;

import com.badlogic.gdx.utils.TimeUtils;

/**
 * Only expires once.
 * @author Javier
 *
 */
public class TimeEvent {
	long time;
	long initTime;
	boolean invalid;
	
	public TimeEvent(long init) {
		this.initTime = TimeUtils.millis();
		this.time = init;
		invalid = false;
	}
	
	public boolean expired() {
		if (invalid)
			return false;
		invalid = TimeUtils.millis() - initTime > time;
		return invalid;
	}

	public void reset() {
		this.initTime = TimeUtils.millis();
		invalid = false;		
	}
}
