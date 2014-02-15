package com.danilov.androidgameframework.scene;

import com.danilov.androidgameframework.game.Game;

public abstract class Scene {

	protected final Game game;
	
	public Scene(final Game game) {
		this.game = game;
	}
	
	public abstract void update(final long deltaMillis);
	
	public abstract void render(final long deltaMillis);
	
	public abstract void pause();
	
	public abstract void resume();
	
	public abstract void dispose();
	
}
