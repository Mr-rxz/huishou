package com.huishou.util;

import org.apache.commons.lang.StringUtils;


public class CodeUtil {
	public static String filterEmoji2(String source) {  
        if(StringUtils.isNotBlank(source)){  
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*");  
        }else{  
            return source;  
        }  
    } 
	/**
     * ����Ƿ���emoji�ַ�
     * @param source
     * @return һ�����о��׳�
     */
    private static boolean containsEmoji(String source) {
        if (StringUtils.isBlank(source)) {
            return false;
        }
 
        int len = source.length();
 
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
 
            if (isEmojiCharacter(codePoint)) {
                //do nothing���жϵ������������ȷ���б����ַ�
                return true;
            }
        }
 
        return false;
    }
 
    private static boolean isEmojiCharacter(char codePoint) {
        return !((codePoint == 0x0) ||
                (codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF)));
    }
 
    /**
     * ����emoji ���� �������������͵��ַ�
     * @param source
     * @return
     */
    public static String filterEmoji(String source) {
 
        if (!containsEmoji(source)) {
            return source;//�����������ֱ�ӷ���
        }
        //��������������
        StringBuilder buf = null;
 
        int len = source.length();
 
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            //System.out.println(i+"��"+codePoint + ":" +isEmojiCharacter(codePoint) + ":" + Integer.toHexString((int)codePoint));
            if (isEmojiCharacter(codePoint)) {
               
            } else {
            	 if (buf == null) {
                     buf = new StringBuilder(source.length());
                 }
  
                 buf.append(codePoint);
            }
        }
 
        if (buf == null) {
            return "";	//���ֻ�� emoji���飬�򷵻ؿ��ַ���
        } else {
            if (buf.length() == len) {//������������ھ������ٵ�toString����Ϊ�����������ַ���
                buf = null;
                return source;
            } else {
                return buf.toString();
            }
        }
 
    }
    
	public static String getEncoding(String str) {
		String encode = "GB2312";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = encode;
				return s;
			}
		} catch (Exception exception) {
		}
		encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s1 = encode;
				return s1;
			}
		} catch (Exception exception1) {
		}
		encode = "UTF-8";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s2 = encode;
				return s2;
			}
		} catch (Exception exception2) {
		}
		encode = "GBK";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s3 = encode;
				return s3;
			}
		} catch (Exception exception3) {
		}
		return "";
	}
	
	public static String getUTF8Encoding(String str) {
		String encode = "GB2312";
		String utf8 = "UTF-8";
		
		if(str == null) return str;
		
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = new String(str.getBytes(encode), utf8);
				return s;
			}
		} catch (Exception exception) {
		}
		encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = new String(str.getBytes(encode), utf8);
				return s;
			}
		} catch (Exception exception1) {
		}
		encode = "UTF-8";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = new String(str.getBytes(encode), utf8);
				return s;
			}
		} catch (Exception exception2) {
		}
		encode = "GBK";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = new String(str.getBytes(encode), utf8);
				return s;
			}
		} catch (Exception exception3) {
		}
		return "";
	}
}
