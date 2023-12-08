public class Cards {
	public static void main(String[] args) {

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
		CardScore cardscore = new CardScore();
		int count = 0;
		int cardNum = 0;
		int scoreD = 0; // 딜러 스코어
		int scoreP = 0; // 플레이어 스코어
		while (count < 10) {
			count++;
			cardNum++;
			Line.dLine(50);
			System.out.printf("%d 번째 턴\n", count);
			Line.sLine(50);
			System.out.println("딜러가 카드 두장을 갖습니다.");
			System.out.println("(딜러가 갖은 카드..이건나중에 가릴거임) : " + cards[cardNum]);
			scoreD += cardscore.cardScore(cards[cardNum]);

			cardNum++;
			System.out.println("(딜러가 갖은 카드..이건나중에 가릴거임) : " + cards[cardNum]);
			scoreD += cardscore.cardScore(cards[cardNum]);
			cardNum++;
			System.out.printf("당신이 뽑은 카드 : %s\n", cards[cardNum]);
			scoreP += cardscore.cardScore(cards[cardNum]);

			cardNum++;
			System.out.printf("당신이 뽑은 카드 : %s\n", cards[cardNum]);
			scoreP += cardscore.cardScore(cards[cardNum]);

			cardNum++;

			/*
			 * for(int i = 1 ; i < 53 ; i++) { System.out.println(cards[i]); }
			 */
			// ---------------------
			// 문양을 제외 하는 명령어
			// String result = cards[1].substring(1);

			// ===============stop?
			NumberService numService = new NumberService();
			String str = numService.inputStop();
			if (scoreP < 21) {
				if (scoreP == 21 & scoreD == 21) {
					System.out.println("플레이어와 딜러 모두 블랙잭");
					System.out.println("아쉽게도 무승부입니다.");
					break;

				} else if (scoreP == 21) {
					System.out.println("블랙잭");
					System.out.println("축하합니다. 승리하셨습니다.");
					break;
				} else if (scoreD == 21) {
					System.out.println("딜러의 블랙잭");
					System.out.println("아쉽지만 패배하셨습니다.");
					break;
				} else if (scoreP > 21 & scoreD > 21) {

					System.out.println("아쉽게도 무승부입니다.");
					break;

				} else if (scoreP > 21) {
					System.out.println("burst");
					System.out.println("아쉽지만 21을 초과하여 플레이어의 패배입니다.");
					break;
				} else if (scoreD > 21) {
					System.out.println("burst");
					System.out.println("축하합니다. 딜러가 21을 초과하여 플레이어의 승리입니다.");
					break;
				} else if (scoreD < 17) {
					System.out.println("딜러의 패가 16이하 이므로 딜러가 패를 하나 더 가져갑니다.");
					scoreD += cardscore.cardScore(cards[cardNum]);
					cardNum++;
					continue;
				}
				
			}
			if (str.equalsIgnoreCase("yes")) {
				break;
				
			} else {
				continue;
			}

		} // end while
		System.out.println("딜러점수 : " + scoreD);
		System.out.println("내 점수 : " + scoreP);
		// 여기에다가 총합...더하기? 웅,,,아마,,,maybe..
	}

}
