package com.danilov.androidgameframework.graphics;

public interface Graphics {

	public static enum PixmapFormat {
		ARGB8888, ARGB4444, RGB565
	}
	
	public Pixmap newPixmap(final String fileName, final PixmapFormat format);
	
	public void clear(final int color);
	
	public void drawPixel(final int x, final int y, final int color);
	
	public void drawLine(final int x1, final int x2, final int y1, final int y2, final int color);
	
	public void drawRect(final int x, final int y, final int width,
						 final int height, int color);
	
    public void drawPixmap(final Pixmap pixmap, final int x, final int y, final int srcX, final int srcY,
    					   final int srcWidth, final int srcHeight);
    
    public void drawPixmap(final Pixmap pixmap, final int x, final int y);

    public int getFrameBufferWidth();
    
    public int getFrameBufferHeight();
    
}
