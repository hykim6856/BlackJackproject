package com.project.blackjack.service;

import java.util.Scanner;

import com.project.blackjack.utils.Card;
import com.project.blackjack.utils.Line;

public class CardService {

	protected Scanner scan = null;

	public int count;
	public int cardNum;
	public int scoreD; // 딜러 스코어
	public int scoreP; // 플레이어 스코어
	public int coin;// 돈
	public int betmoney;

	public int winnerD = 0;
	public int winnerP = 0;
	public int winnerNo = 0;

	// 생성자
	public CardService() {
		scan = new Scanner(System.in);

	}

	// 카드값계산
	public int cardsScore(String str) {

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

		String[] suits = { "♠", "♥", "♣", "◆" };
		String[] denos = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		String[] cards = new String[52];

		// 카드 배열에 값 할당
		int index = 0;
		for (String suit : suits) {
			for (String deno : denos) {
				cards[index++] = String.format("%s%s", suit, deno);
			}
		}

		// 카드 섞기
		for (int i = 0; i < 100; i++) {
			int index1 = (int) (Math.random() * cards.length);
			int index2 = (int) (Math.random() * cards.length);

			String temp = cards[index1];
			cards[index1] = cards[index2];
			cards[index2] = temp;
		}

		scoreP = 0;
		scoreD = 0;
		cardNum = 0;
		count++;
		if (count == 1) {
			coin = 10;
		}
		betmoney = this.mycoin(coin);
		Line.dLine(50);
		System.out.printf("%d 번째 게임\n", count);
		System.out.printf("%d승 | %d패 | %d무\n", winnerP, winnerD, winnerNo);
		System.out.printf("소지 포인트 : %d P | 베팅한 포인트 :  %d P\n", coin - betmoney, betmoney);
		Line.sLine(50);
		System.out.println();

		Line.pLine(50);
		System.out.println("딜러와 플레이어는 각각 카드 두 장씩 갖습니다.");
		Line.pLine(50);

		scoreD += cardsScore(cards[cardNum]);
		cardNum++;

		scoreD += cardsScore(cards[cardNum]);
		cardNum++;
		scan.nextLine();
		System.out.println();
		System.out.println("< 플레이어가 뽑은 카드 >");
		Card.printCard(cards[cardNum]);
		scoreP += cardsScore(cards[cardNum]);
		cardNum++;

		Card.printCard(cards[cardNum]);
		System.out.println();
		scoreP += cardsScore(cards[cardNum]);
		cardNum++;
		Line.sLine(50);
		System.out.println("현재 플레이어의 스코어 : " + scoreP);
		Line.sLine(50);
		System.out.println();

		scan.nextLine();
		if (scoreD > 16) {
			Line.pLine(50);
			System.out.println("딜러는 카드를 추가로 뽑지 않았습니다.");
			Line.pLine(50);
			System.out.println();
		}
		if (scoreD < 17) {
			Line.pLine(50);
			System.out.println("딜러의 카드의 합이 17 미만으로 딜러가 카드 한장을 더 갖습니다.");
			Line.pLine(50);
			System.out.println();
			scoreD += cardsScore(cards[cardNum]);
			cardNum++;
		}
		while (scoreP < 21 && scoreD < 21) {
			while (scoreP < 21 && scoreD < 21) {
				System.out.println();
				System.out.print("카드를 추가로 뽑으시겠습니까?(HIT/STOP)>> ");
				String str = scan.nextLine();

				if (str.equalsIgnoreCase("HIT")) {

					break;
				} else if (str.equalsIgnoreCase("STOP")) {
					while (scoreD < 17) {
						Line.pLine(50);
						System.out.println("딜러의 카드의 합이 17 미만으로 딜러가 카드 한장을 더 갖습니다.");
						Line.pLine(50);
						System.out.println();
						scoreD += cardsScore(cards[cardNum]);
						cardNum++;
					}
					return;
				}
				if (this.useCheat(str)) {
					System.out.println();
					Line.lLine(50);
					System.out.printf("현재 딜러의 스코어 : %d\n", scoreD);
					System.out.printf("만약 HIT할 경우 다음에 나올 카드 : %s\n", cards[cardNum]);
					Line.lLine(50);
					System.out.println();
					continue;
				}
				System.out.println();
				Line.lLine(50);
				System.out.println("**철자를 올바르게 입력했는지 확인해보세요**");
				Line.lLine(50);
				System.out.println();
			} // end while
			System.out.println();
			Line.pLine(50);
			System.out.println("< 새로 뽑은 카드 >");
			Card.printCard(cards[cardNum]);
			scoreP += cardsScore(cards[cardNum]);
			cardNum++;
			System.out.println("현재 플레이어의 스코어 : " + scoreP);
			Line.pLine(50);
			System.out.println();

			if (scoreD < 17) {
				Line.pLine(50);
				System.out.println("딜러의 카드의 합이 17 미만으로 딜러가 카드 한장을 더 갖습니다.");
				Line.pLine(50);
				System.out.println();
				scoreD += cardsScore(cards[cardNum]);
				cardNum++;
			}
		}
		return;
	}

	public void whowin() {
		Line.sLine(50);
		if (scoreP == 21 & scoreD == 21) {
			System.out.println();
			System.out.println("[{{플레이어와 딜러 모두 블랙잭}}]");
			System.out.println("아쉽게도 무승부입니다.");
			System.out.printf("딜러의 패 : %d \n", scoreD);
			System.out.printf("플레이어의 패 : %d\n", scoreP);
			System.out.println();
			System.out.printf("베팅한 %d P 는 그대로 돌려받습니다.\n", betmoney);
			System.out.printf("현재 소지 포인트 : %d P \n", coin);
			winnerNo++;

		} else if (scoreP == 21) {
			System.out.println();
			System.out.println("[{{+-+-블랙잭-+-+}}]");
			System.out.println("축하합니다. 승리하셨습니다.");
			System.out.printf("딜러의 패 : %d \n", scoreD);
			System.out.printf("플레이어의 패 : %d\n", scoreP);
			System.out.println();
			System.out.printf("베팅한 %d P 의 두 배인 %d P 얻습니다.\n", betmoney, betmoney * 2);
			coin = coin + betmoney;
			System.out.printf("현재 소지 포인트 : %d P \n", coin);
			winnerP++;

		} else if (scoreD == 21) {
			System.out.println();
			System.out.println("[{{--딜러의 블랙잭--}}]");
			System.out.println("아쉽지만 패배하셨습니다.");
			System.out.printf("딜러의 패 : %d \n", scoreD);
			System.out.printf("플레이어의 패 : %d\n", scoreP);
			System.out.println();
			System.out.printf("베팅한 %d P 를 잃었습니다.\n", betmoney);
			coin = coin - betmoney;
			System.out.printf("현재 소지 포인트 : %d P \n", coin);
			winnerD++;

		} else if (scoreP > 21 && scoreD > 21) {
			System.out.println();
			System.out.println("아쉽게도 무승부입니다.");
			System.out.printf("딜러의 패 : %d \n", scoreD);
			System.out.printf("플레이어의 패 : %d\n", scoreP);
			System.out.println();
			System.out.printf("베팅한 %d P 는 그대로 돌려받습니다.\n", betmoney);
			System.out.printf("현재 소지 포인트 : %d P \n", coin);
			winnerNo++;

		} else if (scoreP > 21) {
			System.out.println();
			System.out.println("플레이어의 burst");
			System.out.println("아쉽지만 21을 초과하여 플레이어의 패배입니다.");
			System.out.printf("딜러의 패 : %d \n", scoreD);
			System.out.printf("플레이어의 패 : %d\n", scoreP);
			System.out.println();
			System.out.printf("베팅한 %d P 를 잃었습니다.\n", betmoney);
			coin = coin - betmoney;
			System.out.printf("현재 소지 포인트 : %d P \n", coin);
			winnerD++;

		} else if (scoreD > 21) {
			System.out.println();
			System.out.println("딜러의 burst");
			System.out.println("축하합니다. 딜러가 21을 초과하여 플레이어의 승리입니다.");
			System.out.printf("딜러의 패 : %d \n", scoreD);
			System.out.printf("플레이어의 패 : %d\n", scoreP);
			System.out.println();
			System.out.printf("베팅한 %d P 의 두 배인 %d P 얻습니다.\n", betmoney, betmoney * 2);
			coin = coin + betmoney;
			System.out.printf("현재 소지 포인트 : %d P \n", coin);
			winnerP++;

		} else if (scoreD < scoreP) {
			System.out.println();
			System.out.println("축하합니다. 승리하셨습니다.");
			System.out.println("딜러의 패보다 21에 더 가까움으로 플레이어의 승리입니다.");
			System.out.printf("딜러의 패 : %d \n", scoreD);
			System.out.printf("플레이어의 패 : %d\n", scoreP);
			System.out.println();
			System.out.printf("베팅한 %d P 의 두 배인 %d P 얻습니다.\n", betmoney, betmoney * 2);
			coin = coin + betmoney;
			System.out.printf("현재 소지 포인트 : %d P \n", coin);
			winnerP++;

		} else if (scoreD > scoreP) {
			System.out.println();
			System.out.println("아쉽지만. 패배하셨습니다.");
			System.out.println("딜러의 패가 21에 더 가까움으로 플레이어의 패배입니다.");
			System.out.printf("딜러의 패 : %d \n", scoreD);
			System.out.printf("플레이어의 패 : %d\n", scoreP);
			System.out.println();
			System.out.printf("베팅한 %d P 를 잃었습니다.\n", betmoney);
			coin = coin - betmoney;
			System.out.printf("현재 소지 포인트 : %d P \n", coin);
			winnerD++;

		} else if (scoreD == scoreP) {
			System.out.println();
			System.out.println("모두 동점이므로 무승부입니다.");
			System.out.printf("딜러의 패 : %d \n", scoreD);
			System.out.printf("플레이어의 패 : %d\n", scoreP);
			System.out.println();
			System.out.printf("베팅한 %d P 는 그대로 돌려받습니다.\n", betmoney);
			System.out.printf("현재 소지 포인트 : %d P \n", coin);
			winnerNo++;

		} else {
			System.err.println("이곳까지 보여지면 오류난거니 확인해봐야함.");
			System.out.printf("딜러의 패 : %d \n", scoreD);
			System.out.printf("플레이어의 패 : %d\n", scoreP);
		}

	}

	// 베팅할 금액을 리턴
	public int mycoin(int coin) {
		int betmoney = 0;
		while (true) {
			System.out.println();
			Line.sLine(50);
			System.out.printf("현재 소지 포인트: %d P \n", coin);
			System.out.print("베팅할 포인트를 입력해주세요>> ");
			String money = scan.nextLine();
			try {
				betmoney = Integer.valueOf(money);

			} catch (Exception e) {
				Line.lLine(50);
				System.out.println("**정수를 똑바로 입력해주세요**");
				Line.lLine(50);
				continue;
			}
			if (betmoney > 0 && betmoney < coin + 1) {
				System.out.println("베팅한 포인트 : " + betmoney + " P");
				return betmoney;
			}
			Line.lLine(50);
			System.out.printf("베팅한 포인트가 너무 작거나 큽니다. 1~%d 까지의 범위의 정수로 베팅해주세요\n", coin);
			Line.lLine(50);
		}
	}

	public void newGames() {
		Line.dLine(50);
		System.out.println("블랙잭에 오신것을 환영합니다.");
		System.out.println("환영의 의미로 10p를 드립니다.");
		Line.dLine(50);
		// CardService cardService = new CardService();
		while (true) {
			this.gameService();
			this.whowin();
			while (true) {
				if (coin == 0) {
					System.out.println();
					Line.lLine(50);
					System.out.println("[{{Game Over}}]");
					System.out.println("포인트를 모두 잃었습니다.");
					System.out.println("현재 소지 포인트 : " + coin + " P");
					System.out.println("도박은 패가망신의 지름길입니다. 안녕히 가세요.");
					return;
				}
				System.out.println();
				Line.sLine(50);
				System.out.print("new game? (y/n) >>");
				String str = scan.nextLine();
				if (str.equalsIgnoreCase("y")) {

					break;
				} else if (str.equalsIgnoreCase("n")) {
					System.out.println("종료");
					return;
				} else {
					Line.lLine(50);
					System.out.println("철자를 올바르게 입력했는지 다시 한번 확인해보세요.");
					Line.lLine(50);
					continue;
				} // end while
			}
		}

	}

	public boolean useCheat(String str) {
		if (str.equalsIgnoreCase("cheat")) {

			return true;
		}
		return false;
	}

}
