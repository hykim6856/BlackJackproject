package com.project.blackjack.play;

import java.util.Scanner;

import com.project.blackjack.service.CardService;

public class PlayGame {
	Scanner scan = null;

	public PlayGame() {
		scan = new Scanner(System.in);
	}

	public void newGames() {
		CardService cardService = new CardService();
		while (true) {
			cardService.printCards();
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
