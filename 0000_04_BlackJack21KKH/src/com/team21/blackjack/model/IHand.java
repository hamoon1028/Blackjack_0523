package com.team21.blackjack.model;

import java.util.Iterator;
import java.util.List;

/**
 * 플레이어, 딜러의 공통 기능인 카드받기(drawCard)를 구현시킴.
 * default 메소드: 각 카드 리스트의 카드 합을 반환
 * @since 	23.05.22
 * @author 	HAMoon
 */
public interface IHand {
	
	//자식 클래스들에 drawCard 메소드를 강제함
	void drawCard();
	
	/**
	 * 카드리스트를 파라미터로 받아서
	 * 리스트 안의 각 카드 점수를 합해주는 역할을 하는 메소드
	 * @since 	23.05.22
	 * @author 	HAMoon
	 * @param 	eachList = 점수를 합산할 카드리스트
	 * @return	각 카드점수의 합 int
	 * 점수 값이 숫자인 경우 각 숫자를 점수로 계산
	 * 점수 값이 J,Q,K 문자인 경우 10점을 점수로 계산
	 * 점수 값이 A 문자인 경우 	-> A를 제외한 카드 합에 11을 더해도 21 이하인 경우 -> 11점으로 계산
	 * 						-> A를 제외한 카드 합에 11을 더하면 21을 초과하는 경우 -> 1점으로 계산
	 */
	default int cardSum(List<Card> eachList) {
	    int sum = 0;
	    int numOfAce = 0; // 에이스 카드의 개수를 저장하는 변수 추가
	    Iterator<Card> currentCard = eachList.iterator();
	    while (currentCard.hasNext()) {	        
	    	String cardNumber = currentCard.next().getNumber();
	    	
	        switch (cardNumber) {
	            case "A":
	                numOfAce++; // 카드의 값은 나중에 계산하기 위해 일단 개수만 증가시킴
	                break;
	            case "J":
	            case "Q":
	            case "K":
	                sum += 10;
	                break;
	            default:
	                sum += Integer.parseInt(cardNumber);
	                break;
	        }
	    }
	    // 에이스 카드의 값을 결정하고 총 합을 계산함
	    while (numOfAce > 0) {
	        if (sum + 11 <= 21) { // 총 합에 11을 더해도 21 이하인 경우
	            sum += 11;
	        } else {
	            sum += 1;
	        }
	        numOfAce--;
	    }
	    return sum;
	}
	
	
}
