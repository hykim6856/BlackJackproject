package com.project.blackjack.utils;


public class Line {
	public static void dLine(int length) {
		System.out.println("=".repeat(length));

	}

	public static void sLine(int length) {
		System.out.println("-".repeat(length));

	}
	
	public static void pLine(int length) {
		System.out.println("+-".repeat(length/2));

	}

	public static void lLine(int length) {
		System.out.println("/".repeat(length));

	}
}