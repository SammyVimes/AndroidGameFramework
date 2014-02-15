package com.danilov.androidgameframework.input;

import java.util.List;

import android.view.View.OnTouchListener;

import com.danilov.androidgameframework.input.Input.TouchEvent;

public interface TouchHandler extends OnTouchListener {

	public boolean isTouchDown(final int pointer);
	
	public int getTouchX(final int pointer);
	
	public int getTouchY(final int pointer);
	
	public List<TouchEvent> getTouchEvents();
	

}
