import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 * �ڹٿ��� ������ ���� �б�
 * 
 * jakarta.apache.org���� poi�� �ٿ�ε� �޴´�
 * poi-5.0.0.jar, commons=math3-3.6.1.jar�� 
 * 
 * buildPath ���� - > project���� ���콺 ������ buildPath ����
 * workbook ���� -> sheet ���� -> row ���� -> cell ����
 */
public class WriteExcel {

	public WriteExcel() {
		//������ ����
		
		//1. workbook ��ü �����
		HSSFWorkbook workbook= new HSSFWorkbook();
		//2. sheet ��ü ����
		HSSFSheet sheet1 = workbook.createSheet("ȸ�����");
		HSSFSheet sheet2 = workbook.createSheet();
		
		//3. row ��ü ����
		HSSFRow row1 = sheet1.createRow(0);
		
		//4. cell ��ü ����
		HSSFCell cell1 = row1.createCell(0);
		
		//5. Value ����
		cell1.setCellValue("��ȣ");
		row1.createCell(1).setCellValue("�̸�");
		row1.createCell(2).setCellValue("����ó");
		row1.createCell(3).setCellValue("�̸���");
		
		/////////////////////////////////////
		String data[][] = {
				{"1","ȫ�浿","010-1234-5678","aaaa@nate.com"},
				{"2","��浿","010-1111-2222","bbbb@nate.com"},
				{"3","�ڱ浿","010-7777-8888","cccc@nate.com"},
				{"4","�̱浿","010-3333-4444","dddd@nate.com"},
				{"5","�ֱ浿","010-5555-6666","eeee@nate.com"}
		};
		
		for(int r=0; r<data.length; r++) {
			HSSFRow cRow = sheet1.createRow(r+1);
			for(int c=0; c<data[r].length; c++) {
				if(c==0) {
					//��ȣ�� ���ڷ� �����Ͽ� ����
					cRow.createCell(c).setCellValue(Integer.parseInt(data[r][c]));
				} else{
					cRow.createCell(c).setCellValue(data[r][c]);;
				}
			}
		}
		//
		File f = new File("d://javaIO/member.xls");
		try {
			FileOutputStream fos = new FileOutputStream(f);
			workbook.write(fos);
			workbook.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("������ ���� �Ϸ�");
	}
	public static void main(String[] args) {
		new WriteExcel();
	}

}
