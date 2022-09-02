import java.util.Scanner;

public class post_program {
    public static void main(String[] args) {
        // 게시물 프로그램
        
		/* A씨는 게시물의 총 건수와 한 페이지에 보여줄 게시물수를 입력으로 주었을 때
		총 페이지수를 리턴하는 프로그램이 필요하다고 한다. */
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("게시물이 몇 건인지 입력하세요. ");
		int totalCnt = scanner.nextInt();
		System.out.print("한 페이지 당 게시물을 몇 건 담을지 입력하세요. ");
		int pageCnt = scanner.nextInt();
		
		int cnt = totalCnt / pageCnt;

		cnt = totalCnt % pageCnt > 0 ? cnt + 1 : cnt;
		System.out.print("총 페이지 수 : "+cnt);
	}

    
}
