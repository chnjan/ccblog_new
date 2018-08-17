/**
 * 
 */
package com.chnjan.ccblog.pub.secure;

/**
 * @author chenjian
 * @date 2018年4月21日
 * 字符串转换工具
 */
public class String4Secure {

	@SuppressWarnings("unused")
	private static char[] chartable1 = {'1','2','3','4','5','6','7','8','9','0'
			,'A','B','C','D','E','F'};
	
	private static char[] chartable = {'G','H','J','K','L','M','N','P','Q','R'
			,'A','B','C','D','E','F'};
	
	
	/**
	 * byte数组映射成字符串
	 * @param byteArry 要转换的字节数组
	 * @return String 映射的字符串
	 * */
	public static String HexbyteToString(byte[] byteArry) {
		if (byteArry == null) {
			return "";
		}
		char[] chars = new char[byteArry.length*2];
		
		for (int i = 0; i < byteArry.length; i++) {
			//高4位
			int index1 = byteArry[i]>>4&0x0f;
			chars[i*2] = chartable[index1];
			//低4位
			index1 = byteArry[i]&0x0f;
			chars[i*2+1] = chartable[index1];
		}
		
		String hexString = new String(chars);
		
		return hexString;
	}
	
	/**
	 * 将字符串按照映射表转换成字节数组
	 * 
	 * */
	public static byte[] StringToHexbyte(String content) {
		if (content == null) {
			return null;
		}
		char[] chars = content.toCharArray();
		byte[] rsltbyte = new byte[chars.length/2];
		int j = 0;
		//将每两个字符对应的index转换成一个byte
		for (int i = 0; i < chars.length; i=i+2) {
			int hindex = indexOf(chartable, chars[i]);
			hindex = (hindex<<4)&0xf0;
			
			int lindex = indexOf(chartable, chars[i+1]);
			int index = hindex + lindex;
			rsltbyte[j] = (byte)(index&0xff);
			j++;
		}
		return rsltbyte;
	}
	
	/**
	 * 查出字符c，在字符数组chars的下标，不在返回-1
	 * 
	 * */
	public static int indexOf(char[] chars, char c) {
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == c) {
				return i;
			}
		}
		return -1;
	}
}
