import java.util.Scanner;

public class Circle3n1 {
        
	public static void main(String[] args) {
        // 3n+1 사이클
        // count를 사용해서 증감시키고 1이 나오는순간 증감시킨 count를 출력한다.
		
		/* 어떤 정수 n에서 시작해, n이 짝수면 2로 나누고, 홀수면 3을 곱한 다음 1을 더한다.
		 *  ex) 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
		 *  이렇게 해서 새로 만들어진 숫자를 n으로 놓고, n=1 이 될때까지 같은 작업을 계속 반복한다.
		 *  예를 들어, n=22이면 다음과 같은 수열이 만들어진다. n이라는 값이 입력되었을때
		 *   1이 나올때까지 만들어진 수의 개수(1을 포함)를 n의 사이클 길이라고 한다.
		 *  위에 있는 수열을 예로 들면 22의 사이클 길이는 16이다.
		 */

		System.out.print("숫자를 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int count=0;
		
		while(true) {
			if(a%2==0) {
				a = a/2;
				count++;
			}
			else {
				a = a*3+1;
				count++;
			}
			System.out.println(a+" ");
			if(a==1) {
				count++;
				System.out.print("사이클 길이는 : " +count);
				break;
			}
	}	
    }
}
