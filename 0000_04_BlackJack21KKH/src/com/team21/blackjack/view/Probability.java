package com.team21.blackjack.view;

public class Probability {

	/**
	 * 플레이어 카드의 합을 입력받아 버스트 확률을 계산
	 * @param player
	 */

	public void playerProbability(int player) {

		if (player <=11 || player == 21) {
			System.out.println("\t\t버스트 확률 : 0%");  
		}
		else if(player >=12 && player <=20) {
			double bustProbability = (player - 11)*7.69;
			System.out.printf(" \t\t버스트 확률 : %.2f%%\n", bustProbability);
		}
		else {
			System.out.println("\t잘못된 카드 합입니다.");
		}
	}



	//	private int getCardValue(Object card) {
	//		// card가 List<Card> 타입인 경우
	//		if (card instanceof List<?>) {
	//			List<?> cardList = (List<?>) card;
	//			if (!cardList.isEmpty()) {
	//				Object firstCard = cardList.get(0);
	//				if (firstCard instanceof Card) {
	//					Card cardObject = (Card) firstCard;
	//					String cardNumber = cardObject.getNumber().toString();
	//
	//					// A 카드 처리
	//					if (cardNumber.equals("A")) {
	//						return 11;  // A 카드의 값을 11로 반환
	//					}
	//
	//					// J, Q, K 카드 처리
	//					if (cardNumber.equals("J") || cardNumber.equals("Q") || cardNumber.equals("K")) {
	//						return 10;  // J, Q, K 카드의 값을 10으로 반환
	//					}
	//
	//					// 일반 숫자 카드 처리
	//					try {
	//						int cardValue = Integer.parseInt(cardNumber);
	//						return cardValue;
	//					} catch (NumberFormatException e) {
	//						e.printStackTrace();
	//					}
	//				}
	//			}
	//		}
	//
	//		// 추출 실패 시 기본값 반환
	//		return 0;
	//	}
}
