import java.util.Scanner;

public class NumberService {

	Scanner scan = null;

	public NumberService() {
		scan = new Scanner(System.in);

	}

	public boolean StopY() {
		while(true) {
		System.out.print("멈추시겠습니까?(YES/NO) 입력 >>");

		String str = scan.nextLine();
		
		//입력 부분 밖으로 꺼내고나서 값만 매개변수로 데리고 오는게 나을듯
		
		if (str=="YES") {
			return true;
		}else if (str =="NO" ) {
			break;
		}else {
			System.out.println("**문자를 대소문자 정확히 입력해주세요.**");
			continue;
		}

		//int num = 0;
		/*try {
			num = Integer.valueOf(str);
		} catch (Exception e) {
			System.out.println("정수를 정확히 입력해주세요.");
		}*/}
	return false;
	}


}
