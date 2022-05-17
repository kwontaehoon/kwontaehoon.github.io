import java.util.Arrays;
import java.util.Scanner;

public class Shortest_distance {
    public static void main(String[] args) {
        // 최단거리
		
		/* 1차원의 점들이 주어졌을 때, 그 중 가장 거리가 짧은 것의 쌍을 출력하는 함수를 작성하시오.
		 *  (단 점들의 배열은 모두 정렬되어있다고 가정한다.)
		 *	예를들어 S={1, 3, 4, 8, 13, 17, 20} 이 주어졌다면, 결과값은 (3, 4)가 될 것이다.
		 */
		
		System.out.print("숫자를 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		String a[] = scanner.next().split(",");
		
		Arrays.sort(a); // 오름차순
		int b=0;
		int temp =0;
		int result[] = new int[2];
		for(int i=0; i<a.length-1; i++) {
			int c = Integer.parseInt(a[i+1]) - Integer.parseInt(a[i]);
			if(c<b) {
				result[0] = Integer.parseInt(a[i]);
				result[1] = Integer.parseInt(a[i+1]);
				temp = c;
				
			} else if(temp<1){ 
				b=c;
			}
			}
		System.out.print("("+result[0]+","+result[1]+")"); 	 
			 }

}
