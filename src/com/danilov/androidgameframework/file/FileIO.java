package com.danilov.androidgameframework.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface FileIO {
	
	public InputStream readAsset(final String fileName) throws IOException;
	
	public InputStream readFile(final String fileName) throws IOException;
	
	public OutputStream writeFile(final String fileName) throws IOException;
	
}
