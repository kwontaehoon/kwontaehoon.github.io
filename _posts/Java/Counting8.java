public class Counting8 {
    public static void main(String[] args) {
        // 문자열 뽑기로 8의 갯수를 구한다.
		
		/* 1부터 10,000까지 8이라는 숫자가 총 몇번 나오는가?
		   8이 포함되어 있는 숫자의 갯수를 카운팅 하는 것이 아니라 8이라는 숫자를 모두 카운팅 해야 한다.
		   (※ 예를들어 8808은 3, 8888은 4로 카운팅 해야 함)
		*/
		
		int count=0;
		try {
		for(int i=1; i<=10000; i++) {
			String b = String.valueOf(i); // 15가 들어가면 b.length는 2
			for(int j=0; j<b.length(); j++) {
				String num = b.substring(j, j+1);
				if(Integer.parseInt(num) == 8) {
					count++;
				}
				}
			}
		System.out.print(count);
		}catch(StringIndexOutOfBoundsException e){
			System.out.print("에러");
}
	}
}
