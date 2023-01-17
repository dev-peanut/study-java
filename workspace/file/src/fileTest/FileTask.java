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
//		String[] games = { "��Ʋ�׶���", "��", "������ġ", "�ν�Ʈ��ũ", "�����ý��丮", "��Ÿũ����Ʈ" };
//
////      �迭�� ���Ͽ� ����ϰ� ��ü ������ �����ͼ� �ֿܼ� ����ϱ�
////		1. �迭�� ���Ͽ� ���
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/game.txt", true));
//		for(String game : games) {
//			bufferedWriter.write(game + "\n");
//		}
//		bufferedWriter.close();

//		2. ��ü ������ �����ͼ� �ֿܼ� ���
		//null ���� ���ϱ� ���� �ۿ� ����
//		BufferedReader bufferedReader = null;
//		String line = null;
//		//try-catch�� ���� ����?
//		//�Է� Ŭ���� ���� - ��µ� game.txt ��ü ������ �������� ���ؼ� while���� ���
//		try {
//			bufferedReader = new BufferedReader(new FileReader("src/game.txt"));
//			//null���� �ƴҶ� null���̸� ���� �ƹ��͵� ������� ����
//			while((line = bufferedReader.readLine()) != null) {
//				//�ܼ� â�� ���
//				System.out.println(line);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("�߸��� ���");
//		}finally {
//			//null���� �ƴҶ� while���� �������ͼ� ����
//			if(bufferedReader != null) {
//				bufferedReader.close();
//			}
//		}

//      �ν�Ʈ ��ũ�� ���� 2002�� ����
//		BufferedReader bufferedReader = null;//����
//		String line = null, temp = "";//����
//		final String TARGET = "�ν�Ʈ��ũ";
//		
//		try {
//			bufferedReader = new BufferedReader(new FileReader("src/game.txt"));
//			//�ܼ� â�� �ϳ��� ��µ� ���� ���ϱ�
//			while((line = bufferedReader.readLine()) != null) {
//				//game�� ��� ���� TARGET�� ����?
//				//line �ν�Ʈ��ũ�϶�
//				if(line.equals(TARGET)) {
//					//���ٸ� temp�� ����2002/n �־����!
//					//ReaderLine()�� ���Ͱ��� ������� �ʱ� ������ ���� \n�� �ٿ�����Ѵ�.
//					temp = temp + "����2002\n";
//					//������ �������� �ʰ� �ٷ� ���� �ö�
//					continue;
//				}
//				//if���� ���� ������
//				//�ش����� ���� ���� line�� �־��ش�.
//				temp = temp + line + "\n";
//			}
//			//���
//			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/game.txt"));
//			//������ temp���� ����Ѵ�.
//			bufferedWriter.write(temp);
//			bufferedWriter.close();
//		} catch (FileNotFoundException e) {
//			System.out.println("�߸��� ���");
//			e.printStackTrace();
//		}finally {
//			if(bufferedReader != null) {
//				bufferedReader.close();
//			}
//		}
//		����2002 ����
		BufferedReader bufferedReader = null;//����
		String line = null, temp = "";//����
		final String TARGET = "����2002";
		
		try {
			bufferedReader = new BufferedReader(new FileReader("src/game.txt"));
			//�ܼ� â�� �ϳ��� ��µ� ���� ���ϱ�
			while((line = bufferedReader.readLine()) != null) {
				//game�� ��� ���� TARGET�� ����?
				//line �ν�Ʈ��ũ�϶�
				if(line.equals(TARGET)) {
					//����2002 ������ �׳� �Ѿ��
					//������ �������� �ʰ� �ٷ� ���� �ö�
					continue;
				}
				//if���� ���� ������
				//�ش����� ���� ���� line�� �־��ش�.
				temp = temp + line + "\n";
			}
			//���
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/game.txt"));
			//������ temp���� ����Ѵ�.
			bufferedWriter.write(temp);
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("�߸��� ���");
			e.printStackTrace();
		}finally {
			if(bufferedReader != null) {
				bufferedReader.close();
			}
		}
//
	}
}
