import java.util.Scanner;

public class NumberService {

	Scanner scan = null;

	public NumberService() {
		scan = new Scanner(System.in);

	}

	public String inputStop() {
		System.out.print("멈추시겠습니까?\n(멈추려면 YES 입력/ 계속하려면 아무거나 입력) >>");

		String str = scan.nextLine();
		
		return str;
	}

	/*
	 * public void StopY(String str) {
	 * 
	 * 
	 * if (str=="YES") { //break; }else if (str =="NO" ) { //break; }else {
	 * System.out.println("**문자를 대소문자 정확히 입력해주세요.**"); //continue; }
	 * 
	 * //int num = 0; /*try { num = Integer.valueOf(str); } catch (Exception e) {
	 * System.out.println("정수를 정확히 입력해주세요."); }}
	 */

/*	if(str.equalsIgnoreCase("yes"))

	{
		break;// while문 빠져나가서 총점계산
	}else if(str.equalsIgnoreCase("no"))
	{
		continue; // while문 다시반복
	}else
	{
		while (true) {
			if (str.equalsIgnoreCase("yes")) {
				break;// while문 빠져나가서 총점계산
			} else if (str.equalsIgnoreCase("no")) {
				continue; // while문 다시반복
			} else {
				System.out.println("**문자를 대소문자 정확히 입력해주세요.**");
				// continue;
			}
		}
	}
}*/

}
