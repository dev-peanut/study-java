package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import domain.SalaryVO;

public class SalaryDAO {
//  추가
//	외부에서 모델 객체를 매개변수로 받아온다.
	public void insert(SalaryVO salaryVO) throws IOException {
		// DBConnecter에 만들어 놓은 getApend();
		BufferedWriter bufferedWriter = DBConnecter.getAppend();
		// getAppend()를 써야지 마지막 줄에 salaryVO.toString이 추가 된다.
		// 맨 마지막 문자가 \n인지 아닌지 검사해야함.
		// reader는 가져올때 \n을 제외하고 가져오기 때문에 쓰면X
		// Files.readAllBytes(Paths.get(DBConnecter.PATH))
		// 내가 전달한 경로의 모든 내용을 Bytes로 가져옴 Bytes를 문자열로 바꿀때 String 생성자 사용
		// content에 담아줌 : 중요한건 전체 문자이며 \n까지 가져온다.
		String content = new String(Files.readAllBytes(Paths.get(DBConnecter.PATH)));
		String temp = null;// 대입이기 때문에 null값
		// content.charAt(content.length() - 1) 마지막 문자의 길이가 \n이면 그대로 출력
		// 아니면 \n을 붙여서 출력해준다.
		temp = content.charAt(content.length() - 1) == '\n' ? "" : "\n";
		// temp = temp + salaryVO.toString();
		// 마지막 \n을 붙여준 문자를 toString에 넣어준다.
		temp += salaryVO.toString();
		// temp를 출력해준다.
		bufferedWriter.write(temp);
		bufferedWriter.close();
	}

//   수정(소득세)
	//이미 수정한 모델값
	public void update(SalaryVO salaryVO) throws IOException {
		BufferedReader bufferedReader = DBConnecter.getReader();
		String line = null, temp = "";

		while ((line = bufferedReader.readLine()) != null) {
			//split 공백과 비교
			//[0]번째 방 : 연봉과 사용자가 입력한 값이 동일한지 비교 전달받은게 수정 대상이기 때문
			if (line.split("   ")[0].equals(insertComma(salaryVO.getSalary()) + "만원")) {
				//0번째 방부터 "   "까지
				String data = line.substring(0, line.lastIndexOf("   "));
				//data.substring(0, data.lastIndexOf("   ")) : 소득세 전까지 데이터
				
				temp += data.substring(0, data.lastIndexOf("   ")) + "   "
						+ insertComma(salaryVO.getIncomeTax()) + "   "
						+ insertComma(salaryVO.getLocalTax()) + "\n";
				continue;
			}
			//소득세가 아닌 다른 값은 temp에 담아줌
			temp += line + "\n";
		}
		
		//덮어쓸꺼니까 BufferWriter써줘야함.
		BufferedWriter bufferedWriter = DBConnecter.getWriter();
		bufferedWriter.write(temp);

		bufferedWriter.close();
		bufferedReader.close();
	}
//   삭제
	public void delete(SalaryVO salaryVO) throws IOException {
		BufferedReader bufferedReader = DBConnecter.getReader();
		String line = null, temp = "";

		while ((line = bufferedReader.readLine()) != null) {
			if (line.split("   ")[0].equals(insertComma(salaryVO.getSalary()) + "만원")) {
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

//   연봉 조회
	public void lookUp(int salary) throws IOException {
		BufferedReader bufferedReader = DBConnecter.getReader();
		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			if (line.split("   ")[0].equals(insertComma(salary) + "만원")) {
				System.out.println(line);
				break;
			}
		}

	}

//  조회
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
  
//  목록
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
