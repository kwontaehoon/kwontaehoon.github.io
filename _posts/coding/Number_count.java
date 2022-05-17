public class Number_count {
    static int[] count = new int[10];
	public static void main(String[] args) {
        // 숫자 갯수 구하기
        // 나누기, 나머지연산자를 사용해서 각 자릿수를 구했다.
		
		/* 1~1000에서 각 숫자의 갯수 구하기
		  예로 10 ~ 15 까지의 각 숫자의 개수를 구해보자

		10 = 1, 0
		11 = 1, 1
		12 = 1, 2
		13 = 1, 3
		14 = 1, 4
		15 = 1, 5

		그러므로 이 경우의 답은 0:1개, 1:7개, 2:1개, 3:1개, 4:1개, 5:1개 */
		
		int a, b, c, d;
		for(int i=1; i<10; i++) {
			a = i%10;
			t(a);
		}
		for(int i=10; i<100; i++) {
			a = i/10;
			b = i%10;
			t(a);
			t(b);
		}
		for(int z=100;z<1000;z++) {
            c = z/100;
            a = (z-(100*c))/10;
            b = (z-(100*c))%10;
            t(c);
            t(a);
            t(b);
        }
        for(int x=1000;x<1001;x++) {
            d = x/1000;
            c = (x-(1000*d))/100;
            a = (x-(100*c))/10;
            b = (x-(100*c))%10;
            t(d);
            t(c);
            t(a);
            t(b);
        }
        
		for(int i=0; i<count.length; i++) {
			System.out.println(count[i]);
			}
	}
		public static void t(int z) {
			switch(z) {
			case 0 : count[0] += 1; break;
			case 1 : count[1] += 1; break;
			case 2 : count[2] += 1; break;
			case 3 : count[3] += 1; break;
			case 4 : count[4] += 1; break;
			case 5 : count[5] += 1; break;
			case 6 : count[6] += 1; break;
			case 7 : count[7] += 1; break;
			case 8 : count[8] += 1; break;
			case 9 : count[9] += 1; break;
			}
		}
}
