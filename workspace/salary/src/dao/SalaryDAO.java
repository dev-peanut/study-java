package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import domain.SalaryVO;

public class SalaryDAO {
//  �߰�
//	�ܺο��� �� ��ü�� �Ű������� �޾ƿ´�.
	public void insert(SalaryVO salaryVO) throws IOException {
		// DBConnecter�� ����� ���� getApend();
		BufferedWriter bufferedWriter = DBConnecter.getAppend();
		// getAppend()�� ����� ������ �ٿ� salaryVO.toString�� �߰� �ȴ�.
		// �� ������ ���ڰ� \n���� �ƴ��� �˻��ؾ���.
		// reader�� �����ö� \n�� �����ϰ� �������� ������ ����X
		// Files.readAllBytes(Paths.get(DBConnecter.PATH))
		// ���� ������ ����� ��� ������ Bytes�� ������ Bytes�� ���ڿ��� �ٲܶ� String ������ ���
		// content�� ����� : �߿��Ѱ� ��ü �����̸� \n���� �����´�.
		String content = new String(Files.readAllBytes(Paths.get(DBConnecter.PATH)));
		String temp = null;// �����̱� ������ null��
		// content.charAt(content.length() - 1) ������ ������ ���̰� \n�̸� �״�� ���
		// �ƴϸ� \n�� �ٿ��� ������ش�.
		temp = content.charAt(content.length() - 1) == '\n' ? "" : "\n";
		// temp = temp + salaryVO.toString();
		// ������ \n�� �ٿ��� ���ڸ� toString�� �־��ش�.
		temp += salaryVO.toString();
		// temp�� ������ش�.
		bufferedWriter.write(temp);
		bufferedWriter.close();
	}

//   ����(�ҵ漼)
	//�̹� ������ �𵨰�
	public void update(SalaryVO salaryVO) throws IOException {
		BufferedReader bufferedReader = DBConnecter.getReader();
		String line = null, temp = "";

		while ((line = bufferedReader.readLine()) != null) {
			//split ����� ��
			//[0]��° �� : ������ ����ڰ� �Է��� ���� �������� �� ���޹����� ���� ����̱� ����
			if (line.split("   ")[0].equals(insertComma(salaryVO.getSalary()) + "����")) {
				//0��° ����� "   "����
				String data = line.substring(0, line.lastIndexOf("   "));
				//data.substring(0, data.lastIndexOf("   ")) : �ҵ漼 ������ ������
				
				temp += data.substring(0, data.lastIndexOf("   ")) + "   "
						+ insertComma(salaryVO.getIncomeTax()) + "   "
						+ insertComma(salaryVO.getLocalTax()) + "\n";
				continue;
			}
			//�ҵ漼�� �ƴ� �ٸ� ���� temp�� �����
			temp += line + "\n";
		}
		
		//������ϱ� BufferWriter�������.
		BufferedWriter bufferedWriter = DBConnecter.getWriter();
		bufferedWriter.write(temp);

		bufferedWriter.close();
		bufferedReader.close();
	}
//   ����
	public void delete(SalaryVO salaryVO) throws IOException {
		BufferedReader bufferedReader = DBConnecter.getReader();
		String line = null, temp = "";

		while ((line = bufferedReader.readLine()) != null) {
			if (line.split("   ")[0].equals(insertComma(salaryVO.getSalary()) + "����")) {
//				String data = line.substring(0, line.lastIndexOf("   "));
//
//				temp += data.substring(0, data.lastIndexOf("   ")) + "   " + insertComma(salaryVO.getIncomeTax())
//						+ "   " + insertComma(salaryVO.getLocalTax()) + "\n";
				continue;
			}
			temp += line + "\n";
		}
		BufferedWriter bufferedWriter = DBConnecter.getWriter();
		bufferedWriter.write(temp);

		bufferedWriter.close();
		bufferedReader.close();
	}

//   ���� ��ȸ
	public void lookUp(int salary) throws IOException {
		BufferedReader bufferedReader = DBConnecter.getReader();
		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			if (line.split("   ")[0].equals(insertComma(salary) + "����")) {
				System.out.println(line);
				break;
			}
		}

	}

//  ��ȸ
  public SalaryVO select(int salary) throws IOException {
     BufferedReader bufferedReader = DBConnecter.getReader();
     String line = null;
     SalaryVO salaryVO = new SalaryVO();
     
     while((line = bufferedReader.readLine()) != null) {
        String[] stringDatas = line.split("   ");
        int[] datas = new int[stringDatas.length];
        
        for (int i = 0; i < stringDatas.length; i++) {
           datas[i] = Integer.parseInt(stringDatas[i].replaceAll(",", ""));
        }
        
        if(stringDatas[0].equals(insertComma(salary))) {
           salaryVO.setSalary(datas[0]);
              salaryVO.setNetPay(datas[1]);
              salaryVO.setTaxDeductionAmount(datas[2]);
              salaryVO.setPension(datas[3]);
              salaryVO.setHealthInsurance(datas[4]);
              salaryVO.setLongTermCarePay(datas[5]);
              salaryVO.setEmploymentInsurance(datas[6]);
              salaryVO.setIncomeTax(datas[7]);
              salaryVO.setLocalTax(datas[8]);
              break;
        }
     }
     return salaryVO;
  }
  
//  ���
  public ArrayList<SalaryVO> selectAll() throws IOException {
     BufferedReader bufferedReader = DBConnecter.getReader();
     String line = null;
     ArrayList<SalaryVO> salaries = new ArrayList<SalaryVO>();
     
     while((line = bufferedReader.readLine()) != null) {
        SalaryVO salaryVO = new SalaryVO();
        String[] stringDatas = line.split("   ");
        int[] datas = new int[stringDatas.length];
        
        for (int i = 0; i < stringDatas.length; i++) {
           datas[i] = Integer.parseInt(stringDatas[i].replaceAll(",", ""));
        }
        
        salaryVO.setSalary(datas[0]);
           salaryVO.setNetPay(datas[1]);
           salaryVO.setTaxDeductionAmount(datas[2]);
           salaryVO.setPension(datas[3]);
           salaryVO.setHealthInsurance(datas[4]);
           salaryVO.setLongTermCarePay(datas[5]);
           salaryVO.setEmploymentInsurance(datas[6]);
           salaryVO.setIncomeTax(datas[7]);
           salaryVO.setLocalTax(datas[8]);
           
           salaries.add(salaryVO);
     }
     return salaries;
  }
  
  public static String insertComma(int number) {
     String temp = String.valueOf(number);
     String result = "";
     
     for (int i = 0; i < temp.length(); i++) {
        if(i != 0 && i % 3 == 0) {
           result = "," + result;
        }
        result = temp.charAt(temp.length() - 1 - i) + result;
     }
     return result;
  }
  
}
