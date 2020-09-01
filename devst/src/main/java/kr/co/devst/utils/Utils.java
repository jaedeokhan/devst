package kr.co.devst.utils;

public class Utils {
	public static int parseToInt(String str, int num) {//문자열 "123"을 숫자로 파싱하는 유틸
		int result = num;
		
		
		try {
			int parse = Integer.parseInt(str);
			result = parse;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
