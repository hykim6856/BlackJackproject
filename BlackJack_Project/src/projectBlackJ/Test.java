package projectBlackJ;

public class Test {
	public static void main(String[] args) {

		int j = 0;
		int i = 0;
		while (j < 3) {
			j++;
			System.out.println("첫번째 화일");
			while (true) {
				System.out.println("두번째 화일");
				i++;
				if (i == 2) {
					System.out.println("이프문 트루");
					continue;
				} else {
					System.out.println("이프문 펄스");
					break;
				}
				//System.out.println("두번째 화일 이프 밖");
			}
			System.out.println("첫번째 화일 마지막번째");

		}
	}
}
