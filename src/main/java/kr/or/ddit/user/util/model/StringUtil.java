package kr.or.ddit.user.util.model;

public class StringUtil {
	
	public static String getFileNameFromHeader(String contentDisposition){
		
		String fileName = "";
		
		int indexFilename = contentDisposition.indexOf("filename");
		int indexEnd = contentDisposition.lastIndexOf("\"");
		fileName = contentDisposition.substring(indexFilename+10, indexEnd);
		return fileName;
	}
}
