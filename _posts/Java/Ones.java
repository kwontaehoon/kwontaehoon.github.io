
import java.util.Scanner;

public class Ones {

	public static void main(String[] args) {
        // 두 수의 차가 음수가 나올 수 있으므로 절댓값으로 변환했고 정렬을 사용해서 n-1의 값이 모두 존재하는지 따로 변수에 저장했다.
        // n-1 값이 모두 존재하는지 검사하는 코드에서 시간을 많이 소모했다. 결국 정렬을 사용하여 구현했다.
		
		/* 2나 5로 나눌 수 없는 0 이상 10,000 이하의 정수 n이 주어졌는데,
		 *  n의 배수 중에는 10진수로 표기했을 때 모든 자리 숫자가 1인 것이 있다.
		 *   그러한 n의 배수 중에서 가장 작은 것은 몇 자리 수일까?
		 */
		
		System.out.print("숫자를 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		int c[] = { 1, 11, 111, 1111 };
		int a = scanner.nextInt();
		int sum = 0;
		
		if(a%2==0 || a%5==0) {
			System.out.print("2와 5로 나눌수 있습니다.");
			return;

		} else for(int i=0; i<c.length; i++) {
			if(c[i]%a!=0) {
				System.out.println(c[i] +"일때 모든 자리 숫자 1의 배수가 아닙니다.");
			}else {
				sum = (int)(Math.log10(a)+1);
				break;
				}
		}
		System.out.print("n의 배수 중 가장 작은 수의 자릿수 : "+sum);
		}
	}