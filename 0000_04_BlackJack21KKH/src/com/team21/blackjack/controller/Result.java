package com.team21.blackjack.controller;

/**
 * 블랙잭 게임의 결과 판단에 필요한 메소드를 제공하는 클래스
 * @author YJKim
 */
public class Result {

	/** 
	 * 플레이어와 딜러의 카드 점수를 받아와서 결과 정보를 반환하는 메소드
	 * @author 	YJKim
	 * @since 	23.05.22
	 * @param 	player = 플레이어 카드 점수의 합계
	 * @param 	dealer = 딜러 카드 점수의 합계
	 * @return 	게임의 결과 정보를 담은 int
	 */
	public int gameResult(int player, int dealer) {

		if(player>21) {
			return 3;
		}else if(dealer > 21) {
			return 4;
		}


		if(player == dealer) {
			return 0;
		}else if(player > dealer) {
			return 1;
		}
		else {
			return 2;
		}
	}

	/**
	 * 카드의 점수를 받아서, 21점 초과(버스트) 여부를 판단해서 boolean으로 반환하는 메소드
	 * @author 	YJKim
	 * @since 	23.05.22
	 * @param 	numBust
	 * @return 	true = 21점 초과(버스트)
	 * 			false = not 21점 초과(버스트)
	 */
	public boolean checkBlackJack(int number) {
		boolean isc = false;
		if (number == 21) {
			isc = true;
		}
		return isc;
	}

	/**
	 * 카드의 점수를 받아서, 21점 초과(버스트) 여부를 판단해서 boolean으로 반환하는 메소드
	 * @author 	YJKim
	 * @since 	23.05.22
	 * @param 	numBust
	 * @return 	true = 21점 초과(버스트)
	 * 			false = not 21점 초과(버스트)
	 */
	public boolean checkBust(int numBust) {
		boolean isc = false;
		if(numBust>21) {
			isc = true;
		}
		return isc;
	}



}
