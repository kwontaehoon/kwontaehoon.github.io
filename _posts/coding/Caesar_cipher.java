import java.util.Scanner;

public class Caesar_cipher {
    public static void main(String[] args) {
        // 시저 암호
        // 알파벳을 입력한 갯수만큼 더해서 이동한다.
        
		/* 시저 암호는, 고대 로마의 황제 줄리어스 시저가 만들어 낸 암호인데,
		예를 들어 알파벳 A를 입력했을 때, 그 알파벳의 n개 뒤에 오는(여기서는 예를 들 때 3으로 지정하였다)
		알파벳이 출력되는 것이다. 예를 들어 바꾸려는 단어가 'CAT"고, n을 5로 지정하였을 때 "HFY"가 되는 것이다.
		어떠한 암호를 만들 문장과 n을 입력했을 때 암호를 만들어 출력하는 프로그램을 작성해라. */
		
		
		Scanner scanner = new Scanner(System.in);
		
		
		String num[] = {"A","B","C","D","E","F","G","H","I","J","K","N","M",
						"L","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; // length = 26
		
		System.out.print("단어를 입력하세요 : ");
		String d[] = scanner.next().split(""); //  d[] 입력받은 값
		
		System.out.print("n개 : ");
		int a = scanner.nextInt(); 
		
		String cc[] = new String[d.length]; 
		
		try{
			for(int i=0; i<d.length; i++) {
			for(int j=0; j<num.length; j++) {
			if(d[i].equals(num[j])) {
			cc[i] =	num[(j+a)%26];
			}
		}
			}
			
		for(int i=0; i<d.length; i++) {
			System.out.print(cc[i]);
		}
	}catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("에러");
	}
		}
}
