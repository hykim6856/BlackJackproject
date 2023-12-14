package com.project.blackjack.utils;

public class Card {
	public static void printCard(String card) {

		System.out.println("┌──────┐ ");
		System.out.printf("│  %s  │ \n", card);
		System.out.println("│      │ ");
		System.out.println("│      │ ");
		System.out.println("└──────┘ ");

	}
}