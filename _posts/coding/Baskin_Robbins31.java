import java.util.Scanner;

public class Baskin_Robbins31 {
    public static void main(String[] args) {
        // 베스킨라빈스31
		
		/* 게임의 참여자들은 차례를 정해 1부터 31까지의 수를 순차적으로 부른다. 한번에 1~3개까지 수를 연달아 부를 수 있으며,
		 *  마지막 31을 부른 사람이 진다. */
		
		Scanner scanner = new Scanner(System.in);
		
		int count = 0;
		
		System.out.println("게임을 시작합니다.");
		
		while(true) {
			System.out.println("사용자 턴");
			
			System.out.print("갯수를 입력하세요 : ");
			
			int a = scanner.nextInt();
			
			for(int i=1; i<=a; i++) {
				count++;
				System.out.println(count);
				
				if(count == 31) {
					System.out.println("패배");
					break;
				}
			}
			System.out.println("컴퓨터 턴");
			int b = (int)(Math.random()*3);
			for(int i=1; i<a; i++) {
				count++;
				System.out.println(count);
				
				if(count == 31) {
					System.out.println("승리");
					break;
			}
		}
			if (count >= 31) {
				break;
			}
}
}
}
