package fileUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import sun.misc.BASE64Decoder;

public class Base64SaveToFile {

	/**
	 * 保存base64的图片文件到指定目录
	 * 
	 * @param imgStr
	 * @param baseFileName
	 * @param filePath
	 * @return 文件路径
	 */
	public static String GenerateImage(String imgStr, String baseFileName,
			String filePath) {
		if (imgStr == null)return null; // 图像数据为空
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}

			Random random = new Random();
			filePath = filePath + baseFileName + System.currentTimeMillis()
					+ "-" + random.nextInt(10000) + ".jpg";

			OutputStream out = new FileOutputStream(filePath);
			out.write(b);
			out.flush();
			out.close();
		} catch (Exception e) {
			return null;
		}
		return filePath;
	}

	//测试代码
	public static String uplodaImg() throws Exception{
		Map<String,String> map = new HashMap();
		map.put("imgstr", "data:image/jpeg;base64,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");
		String path = "D:/workspace2/cuLibrary"+"/savetoimg/";
		String sfzimg = map.get("imgstr");
		String file_path_icard = "";
		if(sfzimg != null && !"".equals(sfzimg)){
			String sfzimgPath =  GenerateImage(sfzimg.substring(sfzimg.indexOf(",")+1,sfzimg.length()),"",createFolder(path));
			file_path_icard = sfzimgPath.replace(path, "");
		}
		Map<String,String> remap = new HashMap<String,String>();
		remap.put("imgPath", file_path_icard);
		return file_path_icard;
	}
	
	public static String createFolder(String path) throws Exception{
		File file = new File(path);
		if(!file.exists()&&!file.isDirectory()){
		   file.mkdirs();    
		}
		return path;
	}
	
	public static void main(String[] args) throws Exception {
		String c = uplodaImg();
		System.out.println(c);
	}
}