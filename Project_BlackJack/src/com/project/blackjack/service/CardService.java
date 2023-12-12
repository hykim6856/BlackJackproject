package com.project.blackjack.service;

import java.util.Scanner;

import com.project.blackjack.dto.CardsDto;
import com.project.blackjack.utils.Line;

public class CardService {
	// 클래스에서 선언
	CardsDto cardsDto = null;
	Scanner scan = null;

	// 생성자에서 초기화
	public CardService() {
		cardsDto = new CardsDto();
		scan = new Scanner(System.in);
	}

	// 카드 점수계산
	public int loadScore(String str) {
		String result = str.substring(1);
		int score = 0;
		try {
			score = (Integer.valueOf(result));

		} catch (Exception e) {
			if (result.equalsIgnoreCase("A")) {
				return 1;

			} else {
				return 10;

			}
		}
		return score;
	}

	// 다른 메서드에서도 써야할것같아서 미리 선언해두기..(나중에 쓸모없으면 프린트에 합치기)
	public int count;
	public int cardNum;
	public int scoreD; // 딜러 스코어
	public int scoreP; // 플레이어 스코어

	// cards생성

	// 카드 출력
	public int printCards() {
		String[] cards = new String[53];

		cards[1] = "♠A";
		cards[2] = "♠2";
		cards[3] = "♠3";
		cards[4] = "♠4";
		cards[5] = "♠5";
		cards[6] = "♠6";
		cards[7] = "♠7";
		cards[8] = "♠8";
		cards[9] = "♠9";
		cards[10] = "♠10";
		cards[11] = "♠J";
		cards[12] = "♠Q";
		cards[13] = "♠K";

		cards[14] = "♥A";
		cards[15] = "♥2";
		cards[16] = "♥3";
		cards[17] = "♥4";
		cards[18] = "♥5";
		cards[19] = "♥6";
		cards[20] = "♥7";
		cards[21] = "♥8";
		cards[22] = "♥9";
		cards[23] = "♥10";
		cards[24] = "♥J";
		cards[25] = "♥Q";
		cards[26] = "♥K";

		cards[27] = "♣A";
		cards[28] = "♣2";
		cards[29] = "♣3";
		cards[30] = "♣4";
		cards[31] = "♣5";
		cards[32] = "♣6";
		cards[33] = "♣7";
		cards[34] = "♣8";
		cards[35] = "♣9";
		cards[36] = "♣10";
		cards[37] = "♣J";
		cards[38] = "♣Q";
		cards[39] = "♣K";

		cards[40] = "◆A";
		cards[41] = "◆2";
		cards[42] = "◆3";
		cards[43] = "◆4";
		cards[44] = "◆5";
		cards[45] = "◆6";
		cards[46] = "◆7";
		cards[47] = "◆8";
		cards[48] = "◆9";
		cards[49] = "◆10";
		cards[50] = "◆J";
		cards[51] = "◆Q";
		cards[52] = "◆K";

		for (int i = 0; i < 100; i++) {
			int index1 = (int) (Math.random() * cards.length - 1) + 1;
			int index2 = (int) (Math.random() * cards.length - 1) + 1;

			String _temp = cards[index1];
			cards[index1] = cards[index2];
			cards[index2] = _temp;
		}
		// ==
		count++;
		cardNum++;// cards 배열이 실수로 1부터시작해서...1먹고 들어가야함.
		Line.dLine(50);
		System.out.printf("%d 번째 턴\n", count);
		Line.sLine(50);
		System.out.println("딜러가 카드 두장을 갖습니다.");
		System.out.println("(딜러가 갖은 카드..이건나중에 가릴거임) : " + cards[cardNum]);
		scoreD += this.loadScore(cards[cardNum]);
		System.out.println(scoreD);
		cardNum++;
		System.out.println("(딜러가 갖은 카드..이건나중에 가릴거임) : " + cards[cardNum]);
		scoreD += this.loadScore(cards[cardNum]);
		System.out.println(scoreD);
		cardNum++;
		
		System.out.printf("당신이 뽑은 카드 : %s\n", cards[cardNum]);
		scoreP += this.loadScore(cards[cardNum]);
		cardNum++;
		System.out.println(scoreP);

		System.out.printf("당신이 뽑은 카드 : %s\n", cards[cardNum]);
		scoreP += this.loadScore(cards[cardNum]);
		cardNum++;
		
		System.out.println(scoreP);
		
		while(true) {
		if (scoreD < 17) {
			System.out.println("딜러의 카드의 합이 17이하라 딜러가 카드 한장을 더 갖습니다.");
			scoreD += this.loadScore(cards[cardNum]);
			cardNum++;
		}
		break;
		}
		
		while(true) {
			System.out.println("카드를 추가로 뽑으시겠습니까?(HIT/STOP)>> ");
			String str = scan.nextLine();
			if(str.equalsIgnoreCase("HIT")) {
				
				break;
			} else if (str.equalsIgnoreCase("STOP")) {
				return 1;
			}
			System.out.println("**철자를 올바르게 입력했는지 확인해보세요**");
		}
		System.out.printf("당신이 뽑은 카드 : %s\n", cards[cardNum]);
		scoreP += this.loadScore(cards[cardNum]);
		cardNum++;
		System.out.println(scoreP);
		return 0;
	}

}
