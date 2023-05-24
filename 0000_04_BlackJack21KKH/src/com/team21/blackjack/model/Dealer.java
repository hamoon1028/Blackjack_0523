package com.team21.blackjack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 딜러의 카드리스트와 관련된 클래스.
 * 다음의 기능을 함
 * -딜러의 카드리스트에 카드를 추가하는 기능
 * -딜러 카드리스트의 두번째 카드가 Ace인지 판단하는 기능
 * -두번째 카득 Ace라면, 딜러 카드리스트의 첫번째와 두번째 카드의 순서를 바꾸는 기능
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
