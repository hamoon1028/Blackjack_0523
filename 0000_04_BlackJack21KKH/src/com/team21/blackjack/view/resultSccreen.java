package com.team21.blackjack.view;

public class resultSccreen {

	
	
	public void insuranceSScreen() {
		System.out.println("==================================================\n");
		System.out.println("                딜러 블랙잭 !\n");
		System.out.println("         인슈어런스로 플레이어 승리\n");
		System.out.println("==================================================\n");
	}
	
	public void insuranceFScreen() {
		System.out.println("==================================================\n");
		System.out.println("          딜러의 패는 블랙잭이 아닙니다\n");
		System.out.println("              게임이 재개됩니다\n");
		System.out.println("==================================================\n");
	}
	
	public void splitCheckScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t 뽑은 카드의 숫자가 같습니다 ! \n");
		System.out.println("\t\t   스플릿 하시겠습니까?  ");
		System.out.println("\t\t   [1] 예 [2] 아니오 \n");
		System.out.println("==================================================\n");
	}
	
	public void winScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t게임에서 승리하셨습니다\n");
		System.out.println("\t\t받은 배팅액의 2배를 지급합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void winInsuranceScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t딜러 블랙잭!");
		System.out.println("\t플레이어 인슈어런스로, 모든 배팅액을 반환합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void winBlackJackScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t  플레이어 블랙잭!\n");
		System.out.println("\t받은 배팅액의 2.5배를 지급합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void winDBustScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t딜러 버스트! 플레이어가 승리했습니다");
		System.out.println("\t\t받은 배팅액의 2배를 지급합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void pushScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t푸쉬!");
		System.out.println("\t\t배팅액을 반환합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void loseScreen() {
		System.out.println("==================================================\n");
		System.out.println("                  플레이어 패배 \n");
		System.out.println("                배팅액을 잃었습니다\n");
		System.out.println("==================================================\n");
	}
	
	public void bustLoseScreen() {
		System.out.println("==================================================\n");
		System.out.println("        카드의 합이 21을 넘었습니다. 버스트! \n");
		System.out.println("             배팅액을 잃었습니다 \n");
		System.out.println("==================================================\n");
	}
	
	public void blackPush() {
		System.out.println("==================================================\n");
		System.out.println("\t\t 딜러도 블랙잭입니다. 푸쉬!\n");
		System.out.println("\t      배팅액을 반환합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void blackLose() {
		System.out.println("==================================================\n");
		System.out.println("\t\t 딜러가 블랙잭입니다. 플레이어 패배입니다\n");
		System.out.println("\t        배팅액을 잃었습니다\n");
		System.out.println("==================================================\n");
	}
	
	

	public void endScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t 게임을 종료합니다. 이용해주셔서 감사합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void splitPBust() {
		System.out.println("==================================================\n");
		System.out.println("\t 플레이어가 버스트했습니다. 다음 스플릿게임으로 넘어갑니다\n");
		System.out.println("==================================================\n");
	}
	
	public void splitDBust() {
		System.out.println("==================================================\n");
		System.out.println("\t 딜러가 버스트했습니다. 각 스플릿 게임이 전부 승처리 됩니다\n");
		System.out.println("==================================================\n");
	}
	public void gameOver() {
		System.out.println("==================================================\n");
		System.out.println("\t\t 배팅할 돈이 없습니다 \n");
		System.out.println("\t\t    Game Over \n");
		System.out.println("==================================================\n");
		
	}
	
	
}
