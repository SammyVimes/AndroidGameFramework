package com.danilov.androidgameframework.input;

import java.util.List;

import android.content.Context;
import android.view.View;

public class AndroidInput implements Input {
	
	KeyboardHandler keyboardHandler;
	TouchHandler touchHandler;
	
	//TODO: add MultiTouchHandler
	public AndroidInput(final Context context, final View view,
					    final float scaleX, final float scaleY) {
		keyboardHandler = new KeyboardHandler(view);
		touchHandler = new SingleTouchHandler(view, scaleX, scaleY);
	}
	
	@Override
	public boolean isKeyPressed(final int keyCode) {
		return keyboardHandler.isKeyPressed(keyCode);
	}
	
	@Override
	public boolean isTouchDown(final int pointer) {
		return touchHandler.isTouchDown(pointer);
	}
	
	@Override
	public int getTouchX(final int pointer) {
		return touchHandler.getTouchX(pointer);
	}
	
	@Override
	public int getTouchY(final int pointer) {
		return touchHandler.getTouchY(pointer);
	}
	
	@Override
	public float getAccelX() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public float getAccelY() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public float getAccelZ() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<KeyEvent> getKeyEvents() {
		return keyboardHandler.getKeyEvents();
	}
	
	@Override
	public List<TouchEvent> getTouchEvents() {
		return touchHandler.getTouchEvents();
	}

}
