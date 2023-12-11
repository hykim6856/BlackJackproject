package com.project.blackjack.service;

import com.project.blackjack.dto.CardsDto;
import com.project.blackjack.utils.Line;

public class ProjectBlackJack {
	//게임에 매개변수로 카운트 넣어도 될듯?
    public static void game() {

        // 셔플 코드
        CardsDto cardsDto = new CardsDto();

        // 점수 도출 코드
        CardService cardService = new CardService();

        int count = 0;
        int cardNum = 0;
        int scoreD = 0; // 딜러 스코어
        int scoreP = 0; // 플레이어 스코어

        while (count < 20) {
            count++;
            cardNum++;
            Line.sLine(50);
            System.out.printf("%d 번째 턴\n", count);
            Line.sLine(50);
            System.out.println("딜러가 카드 두장을 갖습니다.");

            // 딜러의 카드를 가림 (cardsDto.getCards() 사용)
            System.out.println("(딜러가 갖은 카드..이건 나중에 가릴거임) : " + CardsDto.cards(cardNum));
            System.out.println(CardsDto.cards(cardNum));
            System.out.println(cardService.cardScore(CardsDto.cards(cardNum)));
            scoreD += cardService.cardScore(CardsDto.cards(cardNum));
            cardNum++;
            System.out.println("(딜러가 갖은 카드..이건 나중에 가릴거임) : " + CardsDto.cards(cardNum));
            System.out.println(CardsDto.cards(cardNum));
            System.out.println(cardService.cardScore(CardsDto.cards(cardNum)));
            scoreD += cardService.cardScore(CardsDto.cards(cardNum));
            cardNum++;
            // 딜러의 점수 계산 (cardService 사용)
            System.out.println("내가 갖은 카드 : " + CardsDto.cards(cardNum));
            System.out.println(CardsDto.cards(cardNum));
            System.out.println(cardService.cardScore(CardsDto.cards(cardNum)));
            scoreP += cardService.cardScore(CardsDto.cards(cardNum));
            cardNum++;
            System.out.println("내가 갖은 카드 : " + CardsDto.cards(cardNum));
            System.out.println(CardsDto.cards(cardNum));
            System.out.println(cardService.cardScore(CardsDto.cards(cardNum)));
            scoreP += cardService.cardScore(CardsDto.cards(cardNum));
            System.out.println("내총점:" + scoreP);
            cardNum++;
            
            
        }
    }



	
}


