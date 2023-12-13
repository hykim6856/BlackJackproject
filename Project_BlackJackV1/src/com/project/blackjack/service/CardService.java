package com.project.blackjack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.blackjack.dto.CardsDto;
import com.project.blackjack.utils.Line;

public class CardService {
	protected List<CardsDto> cardsD = null;
	protected Scanner scan = null;

	public int count;
	public int cardNum;
	public int scoreD; // 딜러 스코어
	public int scoreP; // 플레이어 스코어

	// 생성자
	public CardService() {
		scan = new Scanner(System.in);
		cardsD = new ArrayList<CardsDto>();
	}

	// 셔플한 카드 리스트에 추가
	public void makeDecks() {

		String[] suits = { "♠", "♥", "♣", "◆" };
		String[] denos = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		String[] cards = new String[52];

		// 카드 배열에 값 할당
		int index = 0;
		for (String suit : suits) {
			for (String deno : denos) {
				cards[index++] = String.format("%s %s", suit, deno);
			}
		}

		// 카드 섞기
		for (int i = 0; i < 100; i++) {
			int index1 = (int) (Math.random() * cards.length - 1) + 1;
			int index2 = (int) (Math.random() * cards.length - 1) + 1;

			String temp = cards[index1];
			cards[index1] = cards[index2];
			cards[index2] = temp;
		}
		CardsDto cardsDto = new CardsDto();
		for (int i = 0; i < 52; i++) {
			cardsDto.cardDeck = cards[i];
		}
		cardsD.add(cardsDto);

	}// end makedeck

	// 카드값계산
	public int cardsScore(CardsDto cardsDto) {
		String str = cardsDto.toString();
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
	
	

	public void gameService() {
		scoreP = 0;
		scoreD = 0;
		count++;
		makeDecks();
		Line.dLine(50);
		System.out.printf("%d 번째 게임\n", count);
		Line.sLine(50);
		System.out.println("딜러가 카드 두장을 갖습니다.");
		// System.out.println("(딜러가 갖은 카드..이건나중에 가릴거임) : " + cards[cardNum]);
		scoreD += this.cardsScore(cardsD.get(cardNum));
		// System.out.println(scoreD);
		cardNum++;
		// System.out.println("(딜러가 갖은 카드..이건나중에 가릴거임) : " + cards[cardNum]);
		scoreD += this.cardsScore(cardsD.get(cardNum));
		// System.out.println(scoreD);
		cardNum++;

		System.out.printf("당신이 뽑은 카드 : %s\n", cardsD.get(cardNum));
		scoreP += this.cardsScore(cardsD.get(cardNum));
		cardNum++;
		// System.out.println(scoreP);

		System.out.printf("당신이 뽑은 카드 : %s\n", cardsD.get(cardNum));
		scoreP += this.cardsScore(cardsD.get(cardNum));
		cardNum++;

		System.out.println("현재 플레이어의 카드 : " + scoreP);
		
		while (scoreD < 17) {
				System.out.println("딜러의 카드의 합이 17 미만으로 딜러가 카드 한장을 더 갖습니다.");
				// System.out.println("(딜러가 갖은 카드..이건나중에 가릴거임) : " + cards[cardNum]);
				scoreD += this.cardsScore(cardsD.get(cardNum));
				cardNum++;
				continue;
		}
		while (scoreP < 21 && scoreD < 21) {
			while (scoreP < 21 && scoreD < 21) {
				System.out.println("카드를 추가로 뽑으시겠습니까?(HIT/STOP)>> ");
				String str = scan.nextLine();
				if (str.equalsIgnoreCase("HIT")) {

					break;
				} else if (str.equalsIgnoreCase("STOP")) {
					return ;
				}
				System.out.println("**철자를 올바르게 입력했는지 확인해보세요**");
			} // end while
			System.out.printf("당신이 뽑은 카드 : %s\n",cardsD.get(cardNum));
			scoreP += this.cardsScore(cardsD.get(cardNum));
			cardNum++;
			System.out.println(scoreP);
		}
		return;
	}
	public void whowin() {
		

		if (scoreP == 21 & scoreD == 21) {
			System.out.println("플레이어와 딜러 모두 블랙잭");
			System.out.println("아쉽게도 무승부입니다.");

		} else if (scoreP == 21) {
			System.out.println("블랙잭");
			System.out.println("축하합니다. 승리하셨습니다.");

		} else if (scoreD == 21) {
			System.out.println("딜러의 블랙잭");
			System.out.println("아쉽지만 패배하셨습니다.");

		} else if (scoreP > 21 & scoreD > 21) {
			System.out.println("아쉽게도 무승부입니다.");

		} else if (scoreP > 21) {
			System.out.println("플레이어의 burst");
			System.out.println("아쉽지만 21을 초과하여 플레이어의 패배입니다.");

		} else if (scoreD > 21) {
			System.out.println("딜러의 burst");
			System.out.println("축하합니다. 딜러가 21을 초과하여 플레이어의 승리입니다.");

		} else if (scoreD < scoreP) {
			System.out.println("딜러의 패보다 21에 더 가까움으로 플레이어의 승리입니다.");
			System.out.printf("딜러의 패 : %d ", scoreD);
			System.out.printf("플레이어의 패 : %d\n", scoreP);

		} else if (scoreD > scoreP) {
			System.out.println("딜러의 패가 21에 더 가까움으로 플레이어의 패배입니다.");
			System.out.printf("딜러의 패 : %d ", scoreD);
			System.out.printf("플레이어의 패 : %d\n", scoreP);
		}else if (scoreD == scoreP) {
			System.out.println("모두 동점이므로 무승부입니다.");
			System.out.printf("딜러의 패 : %d ", scoreD);
			System.out.printf("플레이어의 패 : %d\n", scoreP);
		}

	}
	
	public void newGames() {
		CardService cardService = new CardService();
		while (true) {
			cardService.gameService();
			cardService.whowin();
			while (true) {
				System.out.print("new game? (y/n) >>");

				String str = scan.nextLine();
				if (str.equalsIgnoreCase("y")) {

					break;
				} else if (str.equalsIgnoreCase("n")) {
					System.out.println("종료");
					return;
				} else {
					System.out.println("철자를 올바르게 입력했는지 다시 한번 확인해보세요.");
					continue;
				} // end while
			}
		}
	
		
	}
}
