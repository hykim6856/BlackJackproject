
public class Win {
	public int whoWinner (int scoreP, int scoreD) {
	
		if (scoreP == 21 & scoreD == 21) {
			return 0;

		} else if (scoreP == 21) {			
			return 1;
			
		} else if (scoreD == 21) {		
			return 2;
			
		} else if (scoreP > 21 & scoreD > 21) {		
			return 3;

		} else if (scoreP > 21) {		
			return 4;
			
		} else if (scoreD > 21) {
			return 5;
			
		} else if (scoreD < 17) {
		return 6;
		
		}
		return 7;
		
	}
/*
	public void printWin (int wNum) {
		if (wNum==0) {
		
				System.out.println("플레이어와 딜러 모두 블랙잭");
				System.out.println("아쉽게도 무승부입니다.");
				break;

			} else if (wNum==1) {
				System.out.println("블랙잭");
				System.out.println("축하합니다. 승리하셨습니다.");
				break;
			} else if (wNum==2) {
				System.out.println("딜러의 블랙잭");
				System.out.println("아쉽지만 패배하셨습니다.");
				break;
			} else if (wNum==3) {

				System.out.println("아쉽게도 무승부입니다.");
				break;

			} else if (wNum==4) {
				System.out.println("burst");
				System.out.println("아쉽지만 21을 초과하여 플레이어의 패배입니다.");
				break;
			} else if (wNum==5) {
				System.out.println("burst");
				System.out.println("축하합니다. 딜러가 21을 초과하여 플레이어의 승리입니다.");
				break;
			} else if (wNum==6) {
				System.out.println("딜러의 패가 16이하 이므로 딜러가 패를 하나 더 가져갑니다.");
				//scoreD += CardScore.cardScore(cards[cardNum]);
				//cardNum++;
				continue;
			}else {
				continue;
			}
	}*/
}