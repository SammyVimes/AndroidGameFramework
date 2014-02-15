package com.danilov.androidgameframework.util;

import java.util.ArrayList;
import java.util.List;

public class Pool<T> {
	
	public static final int DEFAULT_MAX_SIZE = 50;
	
	private PoolObjectFactory<T> factory;
	private List<T> pool;
	private int maxSize;
	
	public Pool(final PoolObjectFactory<T> factory) {
		this(factory, DEFAULT_MAX_SIZE);
	}
	
	public Pool(final PoolObjectFactory<T> factory, final int maxSize) {
		this.factory = factory;
		this.maxSize = maxSize;
		pool = new ArrayList<T>(maxSize);
	}
	
	public T newObject() {
		T object = null;
		if (pool.size() == 0) {
			object = factory.newObject();
		} else {
			object = pool.remove(pool.size() - 1);
		}
		return object;
	}
	
	public void free(final T object) {
		if (pool.size() < maxSize) {
			pool.add(object);
		}
	}
	
	
	
	public interface PoolObjectFactory<T> {
		
		T newObject();
		
	}
	
}
