package com.team21.blackjack.controller;

/**
 * 블랙잭 게임 중 가진 돈과 배팅액 연산을 담당하는 메소드를 모은 클래스
 * @author SYKim
 *
 */
public class Money {
		
	private int money = 10000;
	private int betMoney;
	
	/**
	 * 게임 시작시 입력된 배팅 금액을 처리하는 메소드
	 * 베팅 금액을 betMoney 멤버필드에 저장하고
	 * 가진 돈에서 입력된 금액만큼을 차감한다
	 * @since	23.05.22
	 * @author 	SYKim
	 * @param 	입력 받은 배팅 금액
	 */
	public void firstBet(int n) {	
		this.betMoney = n;
		this.money = money - n;
		}
	
	
	/**
	 * 사용자가 고른 더블다운 선택지의 결과를
	 * 배팅액과 가진 돈에 반영하는 메소드
	 * @since	23.05.22
	 * @author 	SYKim 
	 */
	public void doubleDown() {
		this.money = money - betMoney;
		this.betMoney = betMoney*2;
	}
	
	/**
	 * 사용자가 고른 Insurance 선택지의 결과를
	 * 배팅액과 가진 돈에 반영하는 메소드
	 * @since	23.05.22
	 * @author 	SYKim 
	 */
	public void Insurance() {
		this.betMoney = (int)(betMoney*0.5);
		}
	
	/**
	 * 게임을 이겼을 때의 결과를
	 * 배팅액과 가진 돈에 반영하는 메소드
	 * @since	23.05.22
	 * @author 	SYKim 
	 */
	public void winCase() {
		this.money += this.betMoney*2;
		
	}
	
	/**
	 * 게임을 비겼을 때의 결과를
	 * 배팅액과 가진 돈에 반영하는 메소드
	 * @since	23.05.22
	 * @author 	SYKim 
	 */
	public void pushCase() {
		this.money += this.betMoney;
		
	}
	
	/**
	 * 게임을 블랙잭으로 이겼을 때의 결과를
	 * 배팅액과 가진 돈에 반영하는 메소드
	 * @since	23.05.22
	 * @author 	SYKim 
	 */
	public void blackWinCase() {
		this.money += (int)(betMoney*2.5);
		
	}
	
	/**
	 * 게임을 졌을 때의 결과를
	 * 배팅액과 가진 돈에 반영하는 메소드
	 * @since	23.05.22
	 * @author 	SYKim 
	 */
	public void loseCase() {
		
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public int getBetMoney() {
		return betMoney;
	}


	public void setBetMoney(int betMoney) {
		this.betMoney = betMoney;
	}


	
		
		
	
	
//	// 플레이어가 처음 받은 카드 두장이 같은 숫자일경우 split을 진행
//	// 플레이어1에 초기 배팅금액을 담아두고 플레이어2에 같은 금액 추가하는 로직 구현?
//	public void cardSplit() {
//		int play1 = firstBet(); 
//		int play2 = firstBet();
//		System.out.println("split 진행카드 1 :" + play1);
//		System.out.println("split 진행카드 2 :" + play2);
//		
//	}
	
	
}
