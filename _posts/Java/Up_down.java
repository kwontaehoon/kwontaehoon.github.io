import java.util.Scanner;

public class Up_down {
    public static void main(String[] args) {
        // up&down
		
		/* 컴퓨터가 1~100 숫자(정수 범위) 중 하나를 랜덤으로 정합니다. (이를 알려주지 않습니다.)
		사용자는 이 숫자를 맞추어야 합니다.
		입력한 숫자보다 정답이 크면 → "UP" 출력,
		입력한 숫자보다 정답이 작으면 → "DOWN" 출력.
		정답을 맞추면 → "정답"을 출력하고, 지금까지 숫자를 입력한 횟수를 알려줍니다. */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("게임을 시작합니다.");
		
		int a = (int)(Math.random()*100);
		int count = 0;
		
		while(true) {
			System.out.print("숫자 한개를 입력하세요 : ");
			int b = scanner.nextInt();
			if(a>b) {
				System.out.println("UP");
				count++;
			}
			if(a<b) {
				System.out.println("DOWN");
				count++;
			}
			if(a==b) {
				System.out.println("정답");
				System.out.print("입력한 횟수 : "+count);
				break;
			}
			if(count>100) break;
		}
	}

}
