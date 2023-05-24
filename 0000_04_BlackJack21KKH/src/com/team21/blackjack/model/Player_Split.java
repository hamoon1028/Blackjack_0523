package com.team21.blackjack.model;
/**
 * 스플릿된 카드리스트에 카드를 저장하고 추가할 수 있도록 하는 클래스
 */
import java.util.ArrayList;
import java.util.List;

public class Player_Split extends HandImpl{
	private List<Card> splitCard = new ArrayList<Card>();
	
	/**
	 * 스플릿 된 카드리스트에 랜덤한 카드 한 장을 추가하는 메소드
	 * @since 	23.05.22
	 * @author 	HAMoon
	 */
	@Override
	public void drawCard() {
		List<Card> playerCard = this.splitCard;
		playerCard.add(allCard.get(0));
		allCard.remove(0);
	}
	
	public List<Card> getSplitCard() {
		return splitCard;
	}
}
