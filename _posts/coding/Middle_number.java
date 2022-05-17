import java.util.Scanner;

public class Middle_number {
    public static void main(String[] args) {
		/* 3개의 숫자를 입력으로 받고 3개의 숫자 중에 중간값을 가지는 숫자를 출력하세요.
		 *  ex1) 2, 5, 3 => 3 ex2) 4, 6, 4 => 4
		 */
		
		System.out.print("숫자 3개를 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		String a[] = scanner.next().split(",");
		String b,c,d;
		b = a[0];
		c = a[1];
		d = a[2];
		
		System.out.print(c);		
	}

}
