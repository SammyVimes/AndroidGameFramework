package com.danilov.androidgameframework.audio;

public interface Music {
	
	public void play();
	
	public void stop();
	
	public void pause();
	
	public void setLooping(final boolean looping);
	
	public void setVolume(final float volume);
	
	public boolean isPlayin();
	
	public boolean isStopped();
	
	public boolean isLooping();
	
	public void dispose();
	
}
