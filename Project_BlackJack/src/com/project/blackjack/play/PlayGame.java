package com.project.blackjack.play;

import com.project.blackjack.service.CardService;

public class PlayGame {
	public static void main(String[] args) {
		CardService cardService = new CardService();
		cardService.printCards();
	}
}
