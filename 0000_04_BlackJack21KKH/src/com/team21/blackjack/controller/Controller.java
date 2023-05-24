package com.team21.blackjack.controller;

import java.util.ArrayList;
import java.util.List;
import com.team21.blackjack.model.Card;
import com.team21.blackjack.model.Dealer;
import com.team21.blackjack.model.Player;
import com.team21.blackjack.model.Player_Split;
import com.team21.blackjack.util.Scanner_Util;
import com.team21.blackjack.view.announceScreen;
import com.team21.blackjack.view.cardScreen;
import com.team21.blackjack.view.resultSccreen;

public class Controller {
	Scanner_Util scan = new Scanner_Util();
	resultSccreen rScreen = new resultSccreen();
	cardScreen cScreen = new cardScreen();
	announceScreen aScreen = new announceScreen();
	Player player = new Player();
	Dealer dealer = new Dealer();
	Result result = new Result();
	Player_Split split = new Player_Split();
	Money money = new Money();

	private List<List<Card>> splitResults = new ArrayList<>(); // 스플릿 된 카드들의 결과를 담는 2차원 List
	List<Card> splitList = split.getSplitCard();
	
	boolean canDoubleDown = true; 		//더블다운이 가능한지 판단하는 변수
	boolean issueChk = false;			//게임루프가 돌기 전 특수한 상황이 있었는지 판단하기 위한 변수
										//특수상황이 없을 경우. 카드정보창이 2회 연속으로 뜨는 점이 어색하다
	int input = 0; 		// 게임 중 int 입력값을 저장하는 변수
	int saveFirstBet = 0; 	// 첫 배팅금액을 저장하는 변수(여러번 스플릿 할 경우 쓰임)
	int splitCnt = 0; 	// 스플릿 가능한 횟수를 저장하는 변수	
	int stageChk = 0; 	// 게임 조기 종료시 남은 과정을 건너뛰기 위한 변수
						// 0 : 완전 처음, 1 : 1회차 이후, 2: Stand 선택, 3: 게임종료 선택

	public void startGame() {

		// 게임 인트로
		if (stageChk == 0) {
			aScreen.firstScreen();
			scan.scanAnything();
			stageChk++; // 두번째 실행부터는 이 단계 건너뜀
		}

	
		// 초기 배팅, '배팅 금액을 입력해주세요' 화면
		aScreen.betScreen(money.getMoney());
		
		//배팅 금액 입력 = min 1000 / max 가진 돈
		input = scan.input(1000, money.getMoney());
		
		//money 멤버필드들에 배팅결과 반영
		money.firstBet(input);
		
		// 초기 배팅값 저장(여러번 스플릿 할 경우 초기 배팅값 필요)
		saveFirstBet = money.getBetMoney(); 

		// '카드 뽑기 위해 엔터를 입력하세요' 화면
		aScreen.playScreen();
		scan.scanAnything();

		
		// 스플릿 테스트를 위한 코드
//		if (money.getMoney() == 9000) {
//			player.drawCard();
//			dealer.drawCard();
//			 //player.drawCard();
//			player.getPlayerCard().add(player.getPlayerCard().get(0));
//			dealer.drawCard();
//		} else {
		
		// 딜러, 플레이어 한 장씩 드로우
		player.drawCard();
		dealer.drawCard();
		player.drawCard();
		dealer.drawCard();

//}
		// 카드 뽑기 결과를 반영한 카드창
		cScreen.cardScreen(player.getPlayerCard(), dealer.sortCard(), player.cardSum(player.getPlayerCard()),
				money.getMoney(), money.getBetMoney());

		// 인슈어런스 여부를 판단하고 처리하는 프로세스
		checkInsuranceProcess();

		// 블랙잭 여부를 판단하고 처리하는 프로새스
		if (stageChk <= 1) {
			checkBlackJackProcess();
		}

		// 스플릿 여부를 판단하고 처리하는 프로세스
		while (player.compareCard(player.getPlayerCard().get(0), player.getPlayerCard().get(1)) && stageChk<=1) {
			checkSplitProcess();

		}

		// 기본 게임 진행
		if(stageChk != 3) {
		gameLoop();}

		// 스플릿 게임 진행
		
			while (splitCnt > 0) { // 스플릿 가능 횟수가 남았을 때
				splitCnt--; // 스플릿가능횟수--;
				stageChk = 1; // 다시 힛 할 수 있도록
				List<Card> splitListCopy = new ArrayList<>(splitList);
				player.setPlayerCard(splitListCopy); // 스플릿카드를 플레이어카드로
				player.drawCard(); // 플레이어 카드 드로우
				splitList.clear(); // 스플릿카드는 새 걸로
				gameLoop(); // 게임 플레이

			}
		

		// 게임 재시작(변수 초기화 후 startGame 재귀호출) or 종료
		if (money.getMoney() < 1000) {
			rScreen.gameOver();
		} else {
			askRestart();
		}

	}// startGame의 끝

	/**
	 * 게임 내에서 반복되는 구간(카드를 뽑고 숫자를 비교하는 순서)
	 */
	private void gameLoop() {

		
		if (issueChk = true) {
			aScreen.issueChk();
		}
		
		while (stageChk == 1) {
			 cScreen.cardScreen(player.getPlayerCard(), dealer.sortCard(),
					 player.cardSum(player.getPlayerCard()), money.getMoney(),
					 money.getBetMoney());
			// 첫 턴이면 선택지 3개, n턴 이라면 선택지 2개인 화면 출력
			if (canDoubleDown == true) {
				aScreen.firstChoiceScreen(); // 선택지 3개
				input = scan.input(1, 3);
			} else {
				aScreen.basicChoiceScreen(); // 선택지 2개
				input = scan.input(1, 2);
			}

			// 선택지에 따른 동작 처리
			switch (input) {
			case 1: // Hit
				player.drawCard();
				if (dealer.cardSum(dealer.getDealerCard()) < 17) {
					dealer.drawCard();
				}
				canDoubleDown = false;
				cScreen.cardScreen(player.getPlayerCard(), dealer.sortCard(), player.cardSum(player.getPlayerCard()),
						money.getMoney(), money.getBetMoney());

				break;
			case 2: // Stand
				stageChk = 2;
				break;
			case 3: // DoubleDown
				player.drawCard();
				if (dealer.cardSum(dealer.getDealerCard()) < 17) {
					dealer.drawCard();
				}
				money.doubleDown(); // money 관련 돈 처리
				stageChk = 2;
				break;
			default:
				break;

			}

			// 플레이어나 딜러가 버스트하면 힛 못하도록 함
			if (player.cardSum(player.getPlayerCard()) > 21 || dealer.cardSum(dealer.getDealerCard()) > 21) {
				stageChk = 2;
			}
			if (stageChk >= 2) {
				break;
			}

			
		}
		
		if (dealer.cardSum(dealer.getDealerCard()) < 17) {
			dealer.drawCard();
			cScreen.cardScreen(player.getPlayerCard(), dealer.sortCard(), player.cardSum(player.getPlayerCard()),
					money.getMoney(), money.getBetMoney());
		}

		// 숫자 비교 -- split 된 상태라면 숫자비교 ㄴㄴ 아니라면 숫자비교 ㄱㄱ
		if (splitCnt > 0) {
			splitResults.add(player.getPlayerCard());
		} else {
			scoreCompare(player.getPlayerCard(), dealer.getDealerCard(), player.cardSum(player.getPlayerCard()),
					dealer.cardSum(dealer.getDealerCard()), money.getMoney(), money.getBetMoney());
		}

		// 숫자 비교
		// splitResults에 항목이 있는 경우 각각의 조합에 대해 scoreCompare 호출
		if (splitResults.size() > 0 && splitCnt < 1) {
		    for (List<Card> cards : splitResults) {
		    	stageChk = 2;
		        scoreCompare(cards, dealer.getDealerCard(), player.cardSum(cards),
		                dealer.cardSum(dealer.getDealerCard()), money.getMoney(), money.getBetMoney());
		    }
		}
	}

	/**
	 * 딜러가 첫 카드에 Ace카드를 들고 있을 경우,
	 * 인슈어런스를 할 지 플레이어에게 묻고
	 * 그 선택을 int 값으로 저장하는 메소드
	 * @since 23.05.22
	 * @author KHKim
	 * @param dCrd 딜러의 카드 정보
	 * @return 인슈어런스 여부 정보 int
	 */
	private void insuranceCheck(List<Card> dCard) {
		input = 0;

		if (hasAceCard(dCard)) {//05.23 GameController 메소드를 여기로
			aScreen.insureanceCheckScreen();
			input = scan.input(1,2);
		}
	}
	
	private boolean hasAceCard(List<Card> dCard) { //05.23 GameController 메소드를 여기로.
		Card idx = dCard.get(0);
		String cardNumber2 = idx.getNumber().toString();
		return cardNumber2.equals("A");
	}

	/**
	 * 플레이어가 Insurance를 선택했을 경우의 프로세스
	 * @since 23.05.22
	 * @author KHKim
	 * 딜러의 카드 합이 21(블랙잭)이 아니라면 ->
	 */
	private void checkInsuranceProcess() {
		
		issueChk = true;
		insuranceCheck(dealer.getDealerCard());
		if (input == 1 && dealer.cardSum(dealer.getDealerCard()) != 21) {
			money.Insurance();
			rScreen.insuranceFScreen();
		} else if (input == 1 && dealer.cardSum(dealer.getDealerCard()) == 21) {
			money.Insurance();
			money.winCase();
			cScreen.resultcardScreen(player.getPlayerCard(), dealer.getDealerCard(),
					player.cardSum(player.getPlayerCard()), dealer.cardSum(dealer.getDealerCard()), money.getMoney(),
					money.getBetMoney());
			rScreen.insuranceSScreen();
			stageChk = 3;

		}
	}

	/**
	 * 스플릿 가능할 경우, 플레이어에게 스플릿 여부를 묻고
	 * 플레이어 선택의 결과를 반환하는 메소드
	 * @since 23.05.22
	 * @author KHKim
	 * @return 플레이어의 선택 	1 -> 스플릿 실행
	 * 						2 -> 스플릿 미실행
	 */
	private int splitCheck() {
		int input = 0;
		rScreen.splitCheckScreen();
		input = scan.input(1,2);
		return input;
	}

	/**
	 * 사용자가 스플릿 하기를 선택했을 경우의 프로세스
	 * @since 23.05.22
	 * @author KHKim
	 * 스플릿 배팅액 처리
	 * 스플릿 가능횟수 ++
	 * 두 장의 카드를 플레이어 카드와 스플릿 카드로 각각 한 장씩 분리
	 * 플레이어카드 드로우
	 * 결과화면 출력
	 */
	private void checkSplitProcess() {
		issueChk = true;

		if (splitCheck() == 1) {
			money.firstBet(saveFirstBet);
			splitCnt++;
			player.makeSplitCard();
			splitList = player.getSplitCardStart();
			
			player.drawCard();
			cScreen.cardScreen(player.getPlayerCard(), dealer.sortCard(), player.cardSum(player.getPlayerCard()),
					money.getMoney(), money.getBetMoney());

		}

	}

	/**
	 * 딜러나 플레이어의처음 뽑은 두 장의 카드가 블랙잭인 경우의 프로세스
	 * @since	23.05.22
	 * @author KHKim
	 * 플레이어가 블랙잭일 경우 	-> 딜러 역시 블랙잭이라면 push
	 * 						-> 딜러가 블랙잭이 아니라면 플레이어 승리
	 * 플레이어가 블랙잭일 경우 이외 -> 딜러가 블랙잭이라면 플레이어 패배
	 */
	private void checkBlackJackProcess() {
		issueChk = true;
		if (result.checkBlackJack(player.cardSum(player.getPlayerCard()))) {
			if (splitCnt > 0) {

			} else if (result.checkBlackJack(dealer.cardSum(dealer.getDealerCard()))) {
				money.pushCase();
				cScreen.resultcardScreen(player.getPlayerCard(), dealer.getDealerCard(),
						player.cardSum(player.getPlayerCard()), dealer.cardSum(dealer.getDealerCard()),
						money.getMoney(), money.getBetMoney());
				rScreen.blackPush();
				stageChk = 3;
			} else {
				money.blackWinCase();
				cScreen.resultcardScreen(player.getPlayerCard(), dealer.getDealerCard(),
						player.cardSum(player.getPlayerCard()), dealer.cardSum(dealer.getDealerCard()),
						money.getMoney(), money.getBetMoney());
				rScreen.winBlackJackScreen();
				stageChk = 3;
			}

		}
	}
	
	/**
	 * 사용자가 게임을 다시 시작하는 선택지를 골랐을 때,
	 * 사용했던 변수들을 초기화하고
	 * startGame을 재귀호출하는 메소드
	 * @since	23.05.22
	 * @author 	KHKim
	 */
	private void restartGame() {

		aScreen.restarConfirmtScreen();
		input = 0;
		saveFirstBet = 0;
		player.getPlayerCard().clear();
		dealer.getDealerCard().clear();
		splitResults.clear();
		splitCnt = 0;
		canDoubleDown = true;
		stageChk = 1;
		startGame(); // 게임을 다시 시작
	}

	/**
	 * 한 번의 게임이 끝났을 때,
	 * 게임을 종료할 지 더 할지 재시작 여부를 확인하고
	 * 확인한 결과값을 int 값으로 반환하는 메소드
	 * @since 23.05.22
	 * @author KHKim
	 */
	private void askRestart() {
		// 게임 종료 후 재시작 여부 확인
		aScreen.restartScreen(money.getMoney());
		input = scan.input(1, 2);
		if (input == 1) {
			restartGame();
		} else if (input == 2) {
			rScreen.endScreen();
		}
	}
	
	/**
	 * 게임의 결과를 받아 와서 출력하는 메소드
	 * @since 			23.05.22
	 * @author 			KHKim
	 * @param pCard		플레이어의 카드 정보
	 * @param dCard		딜러의 카드 정보
	 * @param pSum		플레이어 카드의 점수
	 * @param dSum		딜러 카드의 점수
	 * @param mmoney	가진 돈
	 * @param betMoney	배팅액
	 */
	private void scoreCompare(Object pCard, Object dCard, int pSum, int dSum, int mmoney, int betMoney) {

		if (stageChk == 2) {
			input = result.gameResult(pSum, dSum);
			switch (input) {
			case 0:
				if (splitCnt > 0) {

					break;
				} else {
					stageChk = 3;
					money.pushCase();
					cScreen.resultcardScreen(pCard, dCard, pSum, dSum, mmoney, betMoney);
					rScreen.pushScreen();
					break;
				}
			case 1:
				if (splitCnt > 0) {

					break;
				} else {

					stageChk = 3;
					money.winCase();
					cScreen.resultcardScreen(pCard, dCard, pSum, dSum, mmoney, betMoney);
					rScreen.winScreen();
					break;
				}
			case 2:
				if (splitCnt > 0) {

					break;
				} else {
					stageChk = 3;
					money.loseCase();
					cScreen.resultcardScreen(pCard, dCard, pSum, dSum, mmoney, betMoney);
					rScreen.loseScreen();
					break;
				}

			case 3:
				if (splitCnt > 0) {

					break;
				} else {
					stageChk = 3;
					money.loseCase();
					cScreen.resultcardScreen(player.getPlayerCard(), dealer.getDealerCard(),
							player.cardSum(player.getPlayerCard()), dealer.cardSum(dealer.getDealerCard()),
							money.getMoney(), money.getBetMoney());
					rScreen.bustLoseScreen();
					break;
				}
			case 4:
				if (splitCnt > 0) {

					break;
				} else {
					stageChk = 3;
					money.winCase();
					cScreen.resultcardScreen(player.getPlayerCard(), dealer.getDealerCard(),
							player.cardSum(player.getPlayerCard()), dealer.cardSum(dealer.getDealerCard()),
							money.getMoney(), money.getBetMoney());
					rScreen.winDBustScreen();
				}
			}

		}

	}

}
