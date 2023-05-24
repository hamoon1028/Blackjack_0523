package com.team21.blackjack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 각 하위 클래스에서 실행되는 카드 뽑기(drawCard) 기능을 전달하며
 * IHand 인터페이스 클래스를 자식에게 abstract
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
