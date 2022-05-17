import java.util.Scanner;

public class String_delete {
    public static void main(String[] args) {
        // 문자열 제거
        // 문자를 a배열에 담아서 String 비교함수 equals를 사용하여 비교했다.
        
		/* ex: xxx : 1627000000 > xxx : 1w627r00o00p00 만 (특수문자제외)
		 *
		 */
		
		System.out.print("숫자를 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		String num[] = scanner.next().split("");
		
		String a[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
						"n","o","p","q","r","s","t","u","v","w","x","y","z"};
		
		for(int i=0; i<num.length; i++) {
			for(int j=0; j<a.length; j++) {
				if(num[i].equals(a[j])) {
				num[i] = "";
		}else continue;
		}
		}
		for(int i=0; i<num.length; i++)
		System.out.print(num[i]);
	}

}
