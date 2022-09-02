import java.util.Arrays;
import java.util.Scanner;

public class Jolly_Jumper {
    public static void main(String[] args) {
        // 두 수의 차가 음수가 나올 수 있으므로 절댓값으로 변환했고 정렬을 사용해서 n-1의 값이 모두 존재하는지 따로 변수에 저장했다.
        //n-1 값이 모두 존재하는지 검사하는 코드에서 시간을 많이 소모했다. 결국 정렬을 사용하여 구현했다.
		
		/* n개의 정수(n>0)로 이루어진 수열에 대해 서로 인접해 있는 두 수의 차가 1에서 n-1까지의
		 * 값을 모두 가지면 그 수열을 유쾌한 점퍼(jolly jumper)라고 부른다. 예를 들어 다음과 같은 수열에서
		 * 1 4 2 3
         * 앞 뒤에 있는 숫자 차의 절대 값이 각각 3,2,1이므로 이 수열은 유쾌한 점퍼가 된다.
         *  어떤 수열이 유쾌한 점퍼인지 판단할 수 있는 프로그램을 작성하라. 
         */

		// ex) 수열을 만들어서 차이가 가장큰 값을 n-1의 숫자가 수열의 차에있는지
		System.out.print("양의 정수를 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		String a[] = scanner.next().split(",");
		int temp[] = new int[a.length-1];
		int e[] = new int[a.length-1];
		int b=0, c=0;
		
		for(int i=0; i<a.length-1; i++) {
			int d = Integer.parseInt(a[i+1]) - Integer.parseInt(a[i]); // 두수의차
			c = Math.abs(d); // 절댓값
			temp[i] = c;
			if(b<c){
				b=c;
			}
		}
		for(int i=0; i<temp.length; i++) {
			System.out.println(temp[i]);
		}
		System.out.println("n개의 정수 : "+a.length); // 두수의차중 최댓값 즉, c-1까지의 수가 두수의 차에 다있어야함
		for(int i=0; i<temp.length-1; i++) {
			for(int j=1; j<a.length; j++) {
				if(temp[i] == j) {
					break;
		}
		}
		}
		for(int i=0; i<temp.length; i++) {
			e[i] = i+1;
		}
		Arrays.sort(temp);
		System.out.println("정렬한 e : "+Arrays.toString(e));
		System.out.println("정렬한 temp : "+Arrays.toString(temp));
		if(Arrays.equals(temp, e)) {
			System.out.print("유쾌한 점퍼입니다.");
		}else System.out.print("유쾌한 점퍼가 아닙니다.");

	}

}
