package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask {
	//throws IOException??
	public static void main(String[] args) throws IOException {
//		String[] games = { "배틀그라운드", "롤", "오버워치", "로스트아크", "메이플스토리", "스타크래프트" };
//
////      배열로 파일에 출력하고 전체 내용을 가져와서 콘솔에 출력하기
////		1. 배열로 파일에 출력
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/game.txt", true));
//		for(String game : games) {
//			bufferedWriter.write(game + "\n");
//		}
//		bufferedWriter.close();

//		2. 전체 내용을 가져와서 콘솔에 출력
		//null 값을 비교하기 위해 밖에 선언
//		BufferedReader bufferedReader = null;
//		String line = null;
//		//try-catch문 쓰는 이유?
//		//입력 클래스 선언 - 출력된 game.txt 전체 내용을 가져오기 위해서 while문을 사용
//		try {
//			bufferedReader = new BufferedReader(new FileReader("src/game.txt"));
//			//null값이 아닐때 null값이면 값이 아무것도 담겨있지 않음
//			while((line = bufferedReader.readLine()) != null) {
//				//콘솔 창에 출력
//				System.out.println(line);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("잘못된 경로");
//		}finally {
//			//null값이 아닐때 while문을 빠져나와서 종료
//			if(bufferedReader != null) {
//				bufferedReader.close();
//			}
//		}

//      로스트 아크를 피파 2002로 변경
//		BufferedReader bufferedReader = null;//대입
//		String line = null, temp = "";//연결
//		final String TARGET = "로스트아크";
//		
//		try {
//			bufferedReader = new BufferedReader(new FileReader("src/game.txt"));
//			//콘솔 창에 하나씩 출력된 값을 비교하기
//			while((line = bufferedReader.readLine()) != null) {
//				//game에 담긴 값과 TARGET이 같니?
//				//line 로스트아크일때
//				if(line.equals(TARGET)) {
//					//같다면 temp에 피파2002/n 넣어줘라!
//					//ReaderLine()은 엔터값이 적용되지 않기 때문에 옆에 \n를 붙여줘야한다.
//					temp = temp + "피파2002\n";
//					//밑으로 내려가지 않고 바로 위로 올라감
//					continue;
//				}
//				//if문에 들어가지 않을때
//				//해당하지 않은 값은 line에 넣어준다.
//				temp = temp + line + "\n";
//			}
//			//출력
//			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/game.txt"));
//			//수정된 temp값을 출력한다.
//			bufferedWriter.write(temp);
//			bufferedWriter.close();
//		} catch (FileNotFoundException e) {
//			System.out.println("잘못된 경로");
//			e.printStackTrace();
//		}finally {
//			if(bufferedReader != null) {
//				bufferedReader.close();
//			}
//		}
//		피파2002 삭제
		BufferedReader bufferedReader = null;//대입
		String line = null, temp = "";//연결
		final String TARGET = "피파2002";
		
		try {
			bufferedReader = new BufferedReader(new FileReader("src/game.txt"));
			//콘솔 창에 하나씩 출력된 값을 비교하기
			while((line = bufferedReader.readLine()) != null) {
				//game에 담긴 값과 TARGET이 같니?
				//line 로스트아크일때
				if(line.equals(TARGET)) {
					//피파2002 나오면 그냥 넘어가기
					//밑으로 내려가지 않고 바로 위로 올라감
					continue;
				}
				//if문에 들어가지 않을때
				//해당하지 않은 값은 line에 넣어준다.
				temp = temp + line + "\n";
			}
			//출력
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/game.txt"));
			//수정된 temp값을 출력한다.
			bufferedWriter.write(temp);
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("잘못된 경로");
			e.printStackTrace();
		}finally {
			if(bufferedReader != null) {
				bufferedReader.close();
			}
		}
//
	}
}
