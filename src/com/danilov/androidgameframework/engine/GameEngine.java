package com.danilov.androidgameframework.engine;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class GameEngine {

	EngineLock engineLock = new EngineLock(true);
	
	public void onTickUpdate() throws InterruptedException {
		engineLock.lock();
		try {
			//TODO: update
			engineLock.notifyCanDraw();
			engineLock.waitUntilCanUpdate();
		} finally {
			engineLock.unlock();
		}
	}
	
	public static class UpdateThread extends Thread {
		
		private GameEngine engine;
		
		@Override
		public void run() {
			try {
				while (true) {
					engine.onTickUpdate();
				}
			} catch (final InterruptedException e) {
				
			}
			
		}
		
		
	}
	
	public static class EngineLock extends ReentrantLock {
		
		final Condition drawingCondition = this.newCondition();
		final AtomicBoolean isDrawing = new AtomicBoolean(false);
		
		public EngineLock(final boolean fair) {
			super(fair);
		}
		
		void notifyCanDraw() {
			this.isDrawing.set(true);
			this.drawingCondition.signalAll();
		}
		
		void notifyCanUpdate() {
			this.isDrawing.set(false);
			this.drawingCondition.signalAll();
		}
		
		void waitUntilCanDraw() throws InterruptedException {
			while(!isDrawing.get()) {
				drawingCondition.await();
			}
		}
		
		void waitUntilCanUpdate() throws InterruptedException {
			while(isDrawing.get()) {
				drawingCondition.await();
			}
		}
		
	}
	
}
