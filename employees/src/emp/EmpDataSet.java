package emp;

import java.util.HashMap;

public class EmpDataSet {
	public static HashMap<String, EmpVO> empList = new HashMap<String,EmpVO>();
	public EmpDataSet() {
		
	}
	
	public static void setEmpList() {
		empList.put("ȫ�浿",new EmpVO(1,"ȫ�浿","02-1234-1111","�ѹ���","����"));
		empList.put("������",new EmpVO(3,"������","02-5664-3422","��ȹ��","�븮"));
		empList.put("���·�",new EmpVO(5,"���·�","02-2423-2343","�ѹ���","���"));
		empList.put("�̼���",new EmpVO(2,"�̼���","02-3343-3332","�λ��","���"));
		empList.put("�念��",new EmpVO(4,"�念��","02-7877-6752","������","����"));
	}
}

