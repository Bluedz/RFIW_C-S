/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw.service;

/**
 *
 * @author Zyh
 */
public class StrHexExchange {
    public static void main(String[] args) {
        System.out.println("HEX: " + 
        	str2Hex("b10, b11, b12, b13"));	
        // str2Hex("00001,SF600117,D00000000000145,3S15000A002"));
		System.out.println("String: " + 
        		hex2Str("30303030312C53463630303131372C4430303030303030303030303134352C3353313530303041303032"));
    }
	
    /**
     * *直接字符串转换成为16进制(无需Unicode解码)
     * @param hexStr
     * @return
     */	
	public static String str2Hex(String str) {
		
    	char[] chars = "0123456789ABCDEF".toCharArray();
    	StringBuilder sb = new StringBuilder("");
    	byte[] bs = str.getBytes();
    	int bit;
		for (int i = 0; i < bs.length; i++) {
        	bit = (bs[i] & 0x0f0) >> 4;
        	sb.append(chars[bit]);
       	 	bit = bs[i] & 0x0f;
        	sb.append(chars[bit]);
        	// sb.append(' ');
    	}
    	return sb.toString().trim();
	}
	
/**
 * 16进制直接转换成为字符串(无需Unicode解码)
 * @param hexStr
 * @return
 */
	public static String hex2Str(String hexStr) {
    	String str = "0123456789ABCDEF";
    	char[] hexs = hexStr.toCharArray();
    	byte[] bytes = new byte[hexStr.length() / 2];
    	int n;
    	for (int i = 0; i < bytes.length; i++) {
        	n = str.indexOf(hexs[2 * i]) * 16;
        	n += str.indexOf(hexs[2 * i + 1]);
        	bytes[i] = (byte) (n & 0xff);
    	}
    	return new String(bytes);
	}    
}
