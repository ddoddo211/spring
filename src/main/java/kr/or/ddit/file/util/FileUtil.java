package kr.or.ddit.file.util;

public class FileUtil {

	public static String getFileExt(String fileName) {
		
		if(fileName.indexOf(".")!=-1) {
			int dotIndex = fileName.lastIndexOf(".");
			String ext = fileName.substring(dotIndex);
			return ext;
		} else {
			return "";
		}
		
	}
	
}
