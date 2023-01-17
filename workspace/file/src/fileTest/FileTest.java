package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {

//      ���� ���: ��𿡼� �ۼ��ص� ã�ư� �� �ִ� ���, C:/a/b
//      ��� ���: ���� ��ġ�� ���� ����Ǵ� ���, ../a/b
		
//		writer ��� Ŭ����
//		fileWriter ������ ����� ������ ����ϱ� ���� ����/������ ��ο� ������ ���ٸ� ���Ӱ� ���� �� �����ش�.
//		��� Ŭ������ ������ �ش�. fileWriter�� ������ ������ִµ� ���ٸ� ���Ӱ� ����� ����.
//		FileWriter �ڿ� boolean�� ���� ����? true�϶� �̾�� false �����(�Ƚᵵ ��)
//		close �ϴ� ����? �ݾ���� ����Ǳ� ����! ������!
//		./src/test.txt : ���Ŭ���� ./�� ��������
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test.txt", true));
//		bufferedWriter.write("�ȳ�");
//		bufferedWriter.close();

//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test.txt", false));
//		bufferedWriter.write("�ȳ�");
//		bufferedWriter.close();
		
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test.txt"));
//		bufferedWriter.write("�ȳ�");
//		bufferedWriter.close();

		//BufferdReader : �Է�Ŭ���� - ��µ� �����͸� �����´ٰ� �����ϸ� ��
		//try-catch�� �ٽ� �����ϱ�
		//�� �ۿ� null���� ��������? null���� ���ϱ� ����
		//null���� �Է��� �ޱ� ���� "" ���ڿ��� �̾��ֱ� ����
		BufferedReader bufferedReader = null;
		try {
			//src/test.txt�� �������� �о �ܼ�â�� �߰� ����
			bufferedReader = new BufferedReader(new FileReader("src/test.txt"));
			String line = null;
			// �ٹٲ��� �������� �ʴ´�. �ٽ� �����ö� \n�� �������
			//readLine() : �ؽ�Ʈ ������ �д� ��
			//while������ �ϴ� ����? test���Ͽ� �ִ� ��µ� ������ Ƚ���� ������ ���� �ʱ� ���� 
			while ((line = bufferedReader.readLine()) != null) {
				//println�� �ٹٲ��̶� �ٹٲ޵Ǿ� ������
				//���� print��� �� �̾ �������� ������ \n�� �Է��������
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			//��θ� ã�� ���ߴٸ� ���
			System.out.println("�߸��� ���");
		} finally {
			//bufferedReader���� null�� �ƴ϶��(��, null���̸� �ܼ� â ��� �� �ݾ��ֱ�)
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}

//      ���� ���� �� �پ��� ������ �߻��Ͽ�, 9���� ���� ���ʹ� ������� ���� close()�� ����!
//      System.gc();
//      System.runFinalization();

//      File file = new File("src/test.txt");
//      if (file.exists()) {
//         file.delete();
//      }
	}
}
