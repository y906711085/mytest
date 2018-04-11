package com.baseframework.comm;

import java.io.File;

/**
 * 
 * @author 王鸿钦
 *
 */
public class FileHelper {

	public static void Create(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
	}
}
