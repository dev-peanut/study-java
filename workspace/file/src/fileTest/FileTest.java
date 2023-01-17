package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {

//      절대 경로: 어디에서 작성해도 찾아갈 수 있는 경로, C:/a/b
//      상대 경로: 현재 위치에 따라 변경되는 경로, ../a/b
		
//		writer 출력 클래스
//		fileWriter 전달한 경로의 파일을 출력하기 위한 목적/전달한 경로에 파일이 없다면 새롭게 만든 후 열어준다.
//		출력 클래스를 선언해 준다. fileWriter로 파일을 출력해주는데 없다면 새롭게 만들어 진다.
//		FileWriter 뒤에 boolean이 오는 이유? true일때 이어쓰기 false 덮어쓰기(안써도 됨)
//		close 하는 이유? 닫아줘야 저장되기 때문! 문법임!
//		./src/test.txt : 상대클래스 ./은 생략가능
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test.txt", true));
//		bufferedWriter.write("안녕");
//		bufferedWriter.close();

//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test.txt", false));
//		bufferedWriter.write("안녕");
//		bufferedWriter.close();
		
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test.txt"));
//		bufferedWriter.write("안녕");
//		bufferedWriter.close();

		//BufferdReader : 입력클래스 - 출력된 데이터를 가져온다고 생각하면 됨
		//try-catch문 다시 공부하기
		//왜 밖에 null값을 정했을까? null값을 비교하기 위해
		//null값은 입력을 받기 위해 "" 빈문자열은 이어주기 위해
		BufferedReader bufferedReader = null;
		try {
			//src/test.txt에 쓰여진걸 읽어서 콘솔창에 뜨게 해줌
			bufferedReader = new BufferedReader(new FileReader("src/test.txt"));
			String line = null;
			// 줄바꿈은 가져오지 않는다. 다시 가져올때 \n을 써줘야함
			//readLine() : 텍스트 한줄을 읽는 것
			//while문으로 하는 이유? test파일에 있는 출력된 데이터 횟수가 정해져 있지 않기 때문 
			while ((line = bufferedReader.readLine()) != null) {
				//println이 줄바꿈이라서 줄바꿈되어 가져옴
				//만약 print라면 쭉 이어서 가져오기 때문에 \n를 입력해줘야함
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			//경로를 찾지 못했다면 출력
			System.out.println("잘못된 경로");
		} finally {
			//bufferedReader값이 null이 아니라면(즉, null값이면 콘솔 창 출력 후 닫아주기)
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}

//      성능 저하 및 다양한 결함이 발생하여, 9버전 이후 부터는 사용하지 말고 close()를 쓰자!
//      System.gc();
//      System.runFinalization();

//      File file = new File("src/test.txt");
//      if (file.exists()) {
//         file.delete();
//      }
	}
}
