package com.team21.blackjack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 플레이어의 카드리스트와 관련된 클래스.
 * - HandImpl 추상메소드 drawCard()를 구현하여 플레이어의 카드 리스트에 담음
 * - 두 카드의 숫자를 비교하여 같을 경우, 두번째 카드를 split카드 리스트로 옮김
 * @author HAMoon
 */
public class Player extends HandImpl{

	private List<Card> playerCard = new ArrayList<Card>();
	
	/**
	 * 플레이어의 카드리스트에 랜덤한 카드 한 장을 추가하는 메소드
	 * @since 23.05.22
	 * @author HAMoon
	 */
	@Override
	public void drawCard() {
		List<Card> playerCard = this.playerCard;
		playerCard.add(allCard.get(0));
		allCard.remove(0);
	}
	

	public List<Card> getPlayerCard() {
		return playerCard;
	}
	
	public void setPlayerCard(List<Card> playerCard) {
		this.playerCard = playerCard;
	}

	/**
	 * 플레이어 카드리스트의 두번째 카드를
	 * 스플릿된 카드리스트의 첫번째 카드로 옮기는 기능을 하는 메소드
	 * @since 23.05.22
	 * @author HaMoon
	 */
	public void makeSplitCard(){
		List<Card> splitCard = this.playerCard;
		splitCard.get(1);
		splitCardStart.add(splitCard.get(1));
		splitCard.remove(1);
	}
	
	/**
	 * 두 장의 카드 숫자가 같은지 판별하는 메소드
	 * @since	23.05.22
	 * @author 	HAMoon
	 * @param 	idx1 카드리스트 중 첫번째 카드
	 * @param 	idx2 카드리스트 중 두번째 카드
	 * @return	true -> 두 카드의 숫자가 같다
	 * 			false-> 두 카드의 숫자가 다르다
	 */		
	public boolean compareCard(Card idx1, Card idx2) {
		boolean isc = false;
		String cardNumber1 = idx1.getNumber().toString();
		String cardNumber2 = idx2.getNumber().toString();
		
		if (cardNumber1.equals(cardNumber2)) {
			isc = true;
		}
		return isc;
	}

}
