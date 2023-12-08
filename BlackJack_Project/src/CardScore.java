
public class CardScore {

	//매개변수로 str(카드문양+숫자 혹은 알파벡) 이 나오면 문양 떼고 숫자는 숫자로 변환, 영어는 값으로 치환.(a와 나머지)
	
	public int cardScore (String str) {
		// 문양을 제외 하는 명령어
		String result = str.substring(1);
		int score = 0;
		try {
			score = (Integer.valueOf(result));
			
		} catch (Exception e) {
			if (result.equalsIgnoreCase("A")) {
				return 1;
				
				
			}else {
				return 10;
				
			}
		}
		return score;
	}
}
