package com.team21.blackjack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 딜러의 카드리스트와 관련된 클래스.
 * - HandImpl 추상메소드 drawCard()를 구현하여 딜러의 카드 리스트에 담음
 * - 처음 두장의 카드를 받았을 때 Ace 카드가 포함되어 있다면 
 *   오픈되는 첫번째 카드로 고정
 * @author HAMoon
 */
public class Dealer extends HandImpl{

	private List<Card> dealerCard = new ArrayList<Card>();
	
	@Override
	public void drawCard() {
		List<Card> dealerCard = this.dealerCard;
		dealerCard.add(allCard.get(0));
		allCard.remove(0);
	}

	public List<Card> getDealerCard() {
		return dealerCard;
	}
	

	public Card sortCard() {
		if(isAce()) {
			Card idx0 = dealerCard.get(0);
			dealerCard.set(0, dealerCard.get(1));
			dealerCard.set(1, idx0);
		}
		return dealerCard.get(0);
	}
	
	public boolean isAce() {
		Card idx1 = dealerCard.get(1);
		String cardNumber2 = idx1.getNumber().toString();
		return cardNumber2.equals("A");
	}
	
}
