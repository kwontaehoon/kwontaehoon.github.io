import java.util.ArrayList;
import java.util.Arrays;

public class Interview_test {
    
	public static void main(String[] args) {
        // 면접 문제
        // split을 이용해 문자열을 자르고 ArrayList를 사용하여 startWith 연산자를 통해 문자열에서 "김", "이"를 찾아서 카운트올려준다.

		/* 주어진 문자열(공백 없이 쉼표로 구분되어 있음)을 가지고
		 아래 문제에 대한 프로그램을 작성하세요.

		  이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,
		  박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌
		
		 1. 김씨와 이씨는 각각 몇명인가요?
		 2. "이재영"이란 이름이 몇번 박복되나요?
		 3. 중복을 제거한 이름을 출력하세요.
		 4. 중복을 제거한 ㄴ이름을 오름차순으로 정렬하여 출력하세요. */
		
		String input = "이유덕, 이재영, 권종표, 이재영, 박민호, 김상희, 이재영, 김지완, 최승혁, 이성연, 박영서, 박민호, 전경헌, 송정환,김재성, 이유덕, 전경헌";
		String[] names = input.split(",");
		
		int count_kim = 0;
		int count_lee = 0;
		int count_ljy= 0;
		ArrayList<String> name_list = new ArrayList<String>();
		
		for(int i=0; i<names.length; i++) {
			if(names[i].startsWith("김"))
				count_kim++;
			if(names[i].startsWith("이"))
				count_lee++;
			if(names[i].equals("이재영"))
				count_ljy++;
			if(!name_list.contains(names[i]))
				name_list.add(names[i]);
		}
		String[] name_arr = name_list.toArray(new String[name_list.size()]);
		
		System.out.println("김 씨 : "+ count_kim);
		System.out.println("이 씨 : "+ count_lee);
		
		System.out.println("이재영 씨 : "+ count_ljy);
		
		System.out.println("중복을 제거한 이름 :");
		for(int i = 0; i<name_arr.length; i++)
			System.out.print(name_arr[i] + ((name_arr.length == i+1)?"\n":", "));
		Arrays.sort(name_arr);
		System.out.println("중복을 제거한 이름을 오름차순으로 : ");
		for(int i=0; i<name_arr.length; i++)
			System.out.print(name_arr[i]+((name_arr.length == i+1)?"\n":","));
	}
}
