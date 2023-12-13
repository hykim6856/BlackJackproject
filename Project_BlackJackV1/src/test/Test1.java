package test;

import java.util.ArrayList;
import java.util.Collections;

public class Test1 {

	public static void main(String[] args) {
		String strSuit = "♠,♥,◆,♣";
		String strDeno = "A 2 3 4 5 6 7 8 9 10 J Q K";

		String[] suits = strSuit.split(",");
		String[] denos = strDeno.split(" ");

		ArrayList<String> cardsList = new ArrayList<String>();

		// 생성된 카드 덱에 52장의 카드 추가
		for (String suit : suits) {
			for (String deno : denos) {
				String card = String.format("%s %s", suit, deno);
				cardsList.add(card);
			}
		}

		for(int i = 0 ; i <52;i++) {
			System.out.println(cardsList.get(i));
		}
		// 카드 섞기
		Collections.shuffle(cardsList);

		// 배열로 변환
		String[] cards = cardsList.toArray(new String[0]);

		// 결과 출력
		for (String card : cards) {
			System.out.println(card);
		}
	}
	/*
	 * int cardLine = cardA.length; for(int arr = 0 ; arr < cardLine ; arr+) { int
	 * cardCount = cardList.size(); for(int list = 0 ; list <cardCount; list++) {
	 * String[] card = cardList.get(list); System.out.println(card[arr]+\t); }
	 * sysout(); }
	 */
}
