package com.danilov.androidgameframework.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.res.AssetManager;
import android.os.Environment;

public class AndroidFileIO implements FileIO {
	
	private AssetManager assets;
	private String externalStoragePath;
	
	public AndroidFileIO(final AssetManager assets) {
		this.assets = assets;
		this.externalStoragePath = Environment.getExternalStorageDirectory()
									          .getAbsolutePath() + File.separator;
	}

	@Override
	public InputStream readAsset(final String fileName) throws IOException {
		return assets.open(fileName);
	}

	@Override
	public InputStream readFile(final String fileName) throws IOException {
		return new FileInputStream(externalStoragePath + fileName);
	}

	@Override
	public OutputStream writeFile(final String fileName) throws IOException {
		return new FileOutputStream(externalStoragePath + fileName);
	}

}
