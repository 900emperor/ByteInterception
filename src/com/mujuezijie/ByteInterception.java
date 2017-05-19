package com.mujuezijie;

import java.io.UnsupportedEncodingException;

/**
 * 问题：编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
 * 但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"，6，
 * 应该输出为"我ABC"而不是"我ABC+汉的半个"
 * @author Anthony
 */
public class ByteInterception {

	/**
	 * 字符串按字节截取
	 * @param temp
	 * @param size
	 */
	public void interception(String temp, int size){
		byte[] bytes;
		int num = 0;
		String result = "";
		for(int i=0;i<temp.length();i++){
			bytes = (temp.charAt(i)+"").getBytes();
			num+=bytes.length;
			if(num>size){
				break;
			}else{
				result+=temp.charAt(i);
			}
		}
		System.out.println(result);
	}
	
	/**
	 * 获取字节
	 * @param temp
	 */
	public void sizeOfString(String temp){
		System.out.println(temp.getBytes().length);
	}
	
	/**
	 * 获取字节(GBK)
	 * @param temp
	 */
	public void sizeOfStringGBK(String temp){
		try {
			System.out.println("GBK:"+temp.getBytes("GBK").length);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取字节(utf-16)
	 * @param temp
	 */
	public void sizeOfStringUTF16(String temp){
		try {
			System.out.println("UTF-16:"+temp.getBytes("utf-16").length);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取字节(utf-8)
	 * @param temp
	 */
	public void sizeOfStringUTF8(String temp){
		try {
			System.out.println("UTF-8:"+temp.getBytes("utf-8").length);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ByteInterception byteInterception = new ByteInterception();
		byteInterception.interception("我ABC", 4);
		byteInterception.sizeOfString("我");
		byteInterception.sizeOfString("A");
		byteInterception.sizeOfStringGBK("我");
		byteInterception.sizeOfStringUTF16("我");
		byteInterception.sizeOfStringUTF8("我");
		System.out.println("char字节:"+Character.BYTES);
	}

}
