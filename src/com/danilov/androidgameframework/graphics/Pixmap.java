package com.danilov.androidgameframework.graphics;

import com.danilov.androidgameframework.graphics.Graphics.PixmapFormat;

public interface Pixmap {
	
	public int getWidth();
	
	public int getHeight();
	
	public PixmapFormat getFormat();
	
	public void dispose();
	
}
