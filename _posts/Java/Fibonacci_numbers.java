import java.util.Scanner;

public class Fibonacci_numbers {
    public static void main(String[] args) {
        // 피포나치 수열
        // 13을 입력했을때 13보다 크면 break문을 통해 while문에서 벗어난다.

        /* 피보나치 수열이란, 첫 번째 항의 값이 0이고 두 번째 항의 값이 1일 때, 이후의
           항들은 이전의 두 항을 더한 값으로 이루어지는 수열을 말한다.

           예) 0, 1, 1, 2, 3, 5, 8, 13

           인풋을 정수 n으로 받았을때, n 이하까지의 피보나치 수열을 출력하는 프로그램을 작성하세요 */
        
         int fiboArr[] = {0, 1};

         Scanner keyboard = new Scanner(System.in);
         System.out.print("정수를 입력하세요 : ");
         int n = keyboard.nextInt();

         while(true){
             if (fiboArr[0] > n)
                  break;
             System.out.print(fiboArr[0]+ " ");
             int temp = fiboArr[1];
             fiboArr[1] = fiboArr[1] + fiboArr[0];
             fiboArr[0] = temp; 
         }  
       }
}
