package com.project.blackjack.play;

import com.project.blackjack.dto.CardsDto;
import com.project.blackjack.service.CardService;
import com.project.blackjack.utils.Line;

public class ProjectBlackJack {
public static void game() {
	
	//*셔플코드
	CardsDto cardsDto = new CardsDto();
	//cardsDto.cards[cardNum]
	
	//*점수 도출 코드
	CardService cardService = new CardService();
	//cardService.cardScore(cards[cardNum])
	
	int count = 0;
	int cardNum = 0;
	int scoreD = 0; // 딜러 스코어
	int scoreP = 0; // 플레이어 스코어
	
	
	while(count <20) {
		count++;
		cardNum++;
		Line.sLine(50);
		System.out.printf("%d 번째 턴\n", count);
		Line.sLine(50);
		System.out.println("딜러가 카드 두장을 갖습니다.");
		System.out.println("(딜러가 갖은 카드..이건나중에 가릴거임) : " + cardsDto.cards(cardNum);
		scoreD += cardscore.cardScore(cards[cardNum]);
	}
	
	
}
}
