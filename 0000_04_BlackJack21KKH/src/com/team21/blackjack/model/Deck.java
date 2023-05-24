package com.team21.blackjack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 중복되지 않는 랜덤한 카드로 구성된 덱을 만드는 클래스
 * @author MKJeon
 */
public class Deck {
	
	private List<Card> cardcase;
	
	public Deck() {
		cardcase = new ArrayList<Card>();
		make();
	}

	private void make() {
		int cnt = 0;
		while (true) {
			Card card = new Card();
			if(!cardcase.contains(card)) {
				cardcase.add(card);
				cnt++;
			}
			if(cnt == Card.SHAPE.length * Card.NUMBER.length) {
				break;
			}
		}//while
	}//make

	public List<Card> getCardcase() {
		return cardcase;
	}
	
	
}
