import java.util.Scanner;

public class Perfect_number {
    // 완전수
    public static void main(String[] args) {
		/* 자기 자신을 제외한 모든 양의 약수들의 합이 자기 자신이 되는 자연수를
		 * 완전수라고 한다. 예를 들면, 6과 28은 완전수이다. 6=1+2+3
		 * 1,2,3은 각각 6의 약수 28=1+2+4+7+14
		 * 1,2,4,7,14는 각각 28의 약수
		   입력으로 자연수 N을 받고, 출력으로 N 이하의 모든 완전수를 출력하는
		   코드를 작성하라.*/
		
		System.out.print("숫자를 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		for(int i=1; i<=num; i++) {
			int sum = 0;
			for(int j=1; j<i; j++) {
				if(i%j==0) {
					sum += j;
				}
				}
			if(i==sum) {
				System.out.println(i);
			}
		}
	}
}
