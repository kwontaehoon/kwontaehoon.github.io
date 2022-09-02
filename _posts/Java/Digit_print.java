import java.util.Scanner;

public class Digit_print {
	public static void main(String[] args) {
        // 자릿수 출력
        // 문자열은 substring과 chatAt 메서드로 자릿수를 구할 수 있고 int형은 Math 클래스로 자릿수를 구할 수 있다.
        
		/* 양의 정수만 입력으로 받고 그 수의 자릿수를 출력해보자.
		 *  ex1) 3 > 1자리수, ex2) 649 > 3자리수 ....
		 */
		
		System.out.print("양의 정수만 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int length = (int)(Math.log10(n)+1);
		
		System.out.print(length+"자릿수");
	}

}
