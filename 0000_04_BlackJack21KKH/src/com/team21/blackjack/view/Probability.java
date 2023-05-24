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

}
