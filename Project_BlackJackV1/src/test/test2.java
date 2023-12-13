package test;

import java.util.ArrayList;
import java.util.List;

public class test2 {

	private static List<String> cardsDeck = null;

	public test2() {
		cardsDeck = new ArrayList<String>();
	}

	public static void decks() {
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

		// ArrayList에 카드 추가
		for (String card : cards) {
			cardsDeck.add(card);
		}

		// cardsDeck 사용 가능
		// 예: System.out.println(cardsDeck.get(0));
	}
}
