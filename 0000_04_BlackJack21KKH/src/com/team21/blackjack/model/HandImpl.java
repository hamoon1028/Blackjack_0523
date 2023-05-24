package com.team21.blackjack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * IHand 인터페이스 클래스를 자식 클래스에게 abstract하는 추상 클래스
 * 자식인 Player클래스에서 생성한 splitCard 시작 카드를 담는 array. 
 *  (자식인 Player_Split에서 이어받도록)
 * @since 23.05.22
 * @author HAMoon
 */
public abstract class HandImpl implements IHand {

	Deck make = new Deck();
	protected List<Card> allCard = make.getCardcase();
	protected List<Card> splitCardStart = new ArrayList<Card>();
	
	/**
	 * 카드를 한 장 뽑는 기능
	 * 실제 구현은 각 하위 클래스에서 이루어진다.
	 * @since 	23.05.22
	 * @author 	HAMoon
	 */
	@Override
	public abstract void drawCard();

	public List<Card> getSplitCardStart() {
		return splitCardStart;
	}

	public void setSplitCardStart(List<Card> splitCardStart) {
		this.splitCardStart = splitCardStart;
	}
	
	
	
	
	
	
}
