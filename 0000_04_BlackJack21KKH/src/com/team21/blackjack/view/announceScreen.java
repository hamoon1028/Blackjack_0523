package com.team21.blackjack.view;

public class announceScreen {


	public void firstScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t Black Jack 21\n");
		System.out.println("\t         게임 시작[Enter]\n");
		System.out.println("==================================================\n");
	}

	public void betScreen(int money) {
		System.out.println("==================================================\n");
		System.out.println("\t\t 배팅할 금액을 입력해주세요\n");
		System.out.println("\t\t 현재 "+money+"원 보유 중입니다\n");
		System.out.println("\t\t 1000원 단위로 배팅 가능합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void playScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t딜러가 카드를 돌렸습니다"); 
		System.out.println("\t\t받은 카드 확인\n"); //05.23 블랙잭 룰에 맞게 받은 카드로 바꿈
		System.out.println("\t\t   [Enter]\n");
		System.out.println("==================================================\n");
	}
	
	
	
	public void firstChoiceScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t[1] Hit [2] Stand [3] DoubleDown \n");
		System.out.println("==================================================\n");
	}
	
	public void basicChoiceScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t     [1] Hit [2] Stand \n");
		System.out.println("==================================================\n");
	}
	
	
	public void insureanceCheckScreen() {
		System.out.println("==================================================\n");
		System.out.println("        딜러가 Ace 카드를 가지고 있습니다! \n");
		System.out.println("            인슈어런스 하시겠습니까?  ");
		System.out.println("            [1] 예 [2] 아니오 \n");
		System.out.println("==================================================\n");
	}
	
	public void restartScreen(int money) {
		System.out.println("==================================================\n");
		System.out.printf("\t\t  현재 시드머니:%d\n\n",money);
		System.out.println("\t\t 게임을 재시작하겠습니까? \n");
		
		System.out.println("\t\t   [1] 예 [2] 아니오 \n");
		System.out.println("==================================================\n");
	}
	
	public void restarConfirmtScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t 게임을 다시 시작합니다 \n");
		System.out.println("==================================================\n");
		
	}
	
}
