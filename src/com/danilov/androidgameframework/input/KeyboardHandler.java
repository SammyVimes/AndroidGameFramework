package com.danilov.androidgameframework.input;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.View.OnKeyListener;

import com.danilov.androidgameframework.input.Input.KeyEvent;
import com.danilov.androidgameframework.util.Pool;
import com.danilov.androidgameframework.util.Pool.PoolObjectFactory;

public class KeyboardHandler implements OnKeyListener {
	
	private boolean[] pressedKeys = new boolean[128];
	private Pool<KeyEvent> keyEventPool;
	private List<KeyEvent> keyEventsBuffer = new ArrayList<KeyEvent>();
	private List<KeyEvent> keyEvents = new ArrayList<KeyEvent>();
	
	public KeyboardHandler(final View view) {
		PoolObjectFactory<KeyEvent> factory = new PoolObjectFactory<Input.KeyEvent>() {

			@Override
			public KeyEvent newObject() {
				return new KeyEvent();
			}
		};
		keyEventPool = new Pool<KeyEvent>(factory);
		view.setOnKeyListener(this);
		view.setFocusableInTouchMode(true);
		view.requestFocus();
	}

	@Override
	public boolean onKey(View v, int keyCode, android.view.KeyEvent event) {
		if (event.getAction() == android.view.KeyEvent.ACTION_MULTIPLE) {
			return false;
		}
		synchronized (this) {
			KeyEvent keyEvent = keyEventPool.newObject();
			keyEvent.keyChar = (char) event.getUnicodeChar();
			keyEvent.keyCode = event.getKeyCode();
			if (event.getAction() == android.view.KeyEvent.ACTION_DOWN) {
				keyEvent.type = KeyEvent.KEY_DOWN;
				if(keyCode > 0 && keyCode < 127) {
					pressedKeys[keyCode] = true;
				}
			}
			if (event.getAction() == android.view.KeyEvent.ACTION_UP) {
				keyEvent.type = KeyEvent.KEY_UP;
				if(keyCode > 0 && keyCode < 127) {
					pressedKeys[keyCode] = false;
				}
			}
			keyEventsBuffer.add(keyEvent);
		}
		return false;
	}

	public boolean isKeyPressed(int keyCode) {
		return keyCode >= 0 && keyCode <= 127 && pressedKeys[keyCode];
	}

	public List<KeyEvent> getKeyEvents() {
		synchronized (this) {
			int len = keyEvents.size();
			for (int i = 0; i < len; i++) {
				keyEventPool.free(keyEvents.get(i));
			}
			keyEvents.clear();
			keyEvents.addAll(keyEventsBuffer);
			keyEventsBuffer.clear();
			return keyEvents;
		}
	}

}
