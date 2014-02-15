package com.danilov.androidgameframework.game;

import android.provider.MediaStore.Audio;

import com.danilov.androidgameframework.file.FileIO;
import com.danilov.androidgameframework.graphics.Graphics;
import com.danilov.androidgameframework.input.Input;
import com.danilov.androidgameframework.scene.Scene;

public interface Game {

	public Input getInput();
	
	public FileIO getFileIO();
	
	public Graphics getGraphics();
	
	public Audio getAudio();
	
	public void setScene(final Scene scene);
	
	public Scene getCurrentScene();
	
	public Scene getStartScene();
	
}
