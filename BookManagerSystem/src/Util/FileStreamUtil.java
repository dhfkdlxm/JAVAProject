package Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileStreamUtil {


	public static void close(InputStream is) {

		if (is != null) {
			try {
				is.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void close(OutputStream os) {
		if (os != null) {
			try {
				os.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static void close(InputStream bis, InputStream is) {
		FileStreamUtil.close(bis);
		FileStreamUtil.close(is);
	}
	public static void close(OutputStream bos, OutputStream os) {
		FileStreamUtil.close(bos);
		FileStreamUtil.close(os);
	}

	
//	public static <T> void writeFile(String url, T t) {
//		
//		List<T> obList = new ArrayList<T>(); 
//		FileWriter fw;
//
//		try {
//			fw = new FileWriter("url", true);
//			
//			for (int i = 0; i < obList.size(); i++) {
//				fw.write(obList.get(i).getMemberID() + "/" + memberList.get(i).getMemberPW() + "/"
//						+ memberList.get(i).getMemberName() + "/" + memberList.get(i).getMemberPhone() + "/"
//						+ memberList.get(i).getMemberISAdmin() + "\r\n");
//			}
//			fw.close();
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("저장완료");
//
//	}
//	
	
	
	
}
