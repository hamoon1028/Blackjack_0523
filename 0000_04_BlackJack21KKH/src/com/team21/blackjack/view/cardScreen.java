package com.team21.blackjack.view;

public class cardScreen {

	public void cardScreen
	(Object pCard, Object dCard, int cardSum, int money, int betMoney) {
		System.out.println("==================================================\n");
		System.out.println("\t    딜러 카드 : " + "["+dCard+"] + ??"+"\n\n");
		System.out.printf("\t\t 배팅액 %d\n\n",betMoney);
		System.out.printf("\t %s 카드합: %d\t 보유액 : %d\n\n",pCard,cardSum,money);
		System.out.println("==================================================\n");
		
	}
	
	
	public void resultcardScreen
	(Object pCard, Object dCard, int pcardSum, int dcardSum, int money, int betMoney) {
		System.out.println("==================================================\n");
		System.out.printf("\t    딜러 카드 : %s  카드합: %d\n\n", dCard, dcardSum);
		System.out.printf("\t\t 배팅액 %d\n\n",betMoney);
		System.out.printf("\t %s 카드합: %d\t 보유액 : %d\n\n",pCard,pcardSum,money);
		System.out.println("==================================================\n");
		
	}
	
}
