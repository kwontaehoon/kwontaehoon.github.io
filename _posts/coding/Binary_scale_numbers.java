import java.util.Scanner;

public class Binary_scale_numbers {
    public static void main(String[] args) {
        // 이진법으로 자연수 나타내기
        // 객체 타입 클래스 StringBuffer를 사용하여 이진수를 구했다.
        
		/* 2진법이란, 어떤 자연수를 0과 1로만 나타내는 것이다.
		 *  예를 들어 73은 64(2^6)+8(2^3)+1(2^0)이기 때문에 1001001으로 표현한다.
		 *   어떤 숫자를 입력받았을 때 그 숫자를 2진법으로 출력하는 프로그램을 작성하시오.
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		
		int n = scanner.nextInt();
		
		StringBuffer m = new StringBuffer();
		
		while(n>0) {
			m.append(n%2);
			n /= 2;
		}
		System.out.print(m.reverse());
        }

    
}
