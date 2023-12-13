package com.project.blackjack.exec;

import com.project.blackjack.service.CardService;

public class BlackJackExec {
	public static void main(String[] args) {
		CardService cardService = new CardService();
		cardService.newGames();

	}
}
