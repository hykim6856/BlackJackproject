package com.project.blackjack.service;

public class CardService {
	public int cardScore (String str) {
		// 문양을 제외 하는 명령어
		String result = str.substring(1);
		int score = 0;
		try {
			score = (Integer.valueOf(result));
			
		} catch (Exception e) {
			if (result.equalsIgnoreCase("A")) {
				return 1;
			}else {
				return 10;
			}
		}
		return score;
	}//end CS
	
	
	
	
	
}
