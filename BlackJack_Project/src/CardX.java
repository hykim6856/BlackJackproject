
public class CardX {

	public static void main(String[] args) {
		String[] cards = new String[52];
int i = 0;
		for (int shps = 0; shps < 4; shps++) {
			cards [i++]= cards [i++]+(Integer.toString(shps+1));
			System.out.println(cards[i++]);
			for (int nums = 0; nums < 13; nums++) {
				cards [i++]= (Integer.toString(nums+1));
				System.out.println(cards[i++]);

			}
		}

	}
}
//=============여기는 버리기
