package com.project.blackjack.dto;

public class CardsDto {

	public static void cards() {
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
		
	}
}
