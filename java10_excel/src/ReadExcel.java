import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadExcel {

	public ReadExcel() {
		try {
			//Excel ���� �о����
			File f = new File("d://javaIO/member.xls");
			FileInputStream fis = new FileInputStream(f);
			
			//1. POI��ü�� ��������
			POIFSFileSystem poi = new POIFSFileSystem(fis);
			//2. workbook ��������
			HSSFWorkbook workbook= new HSSFWorkbook(poi);
			//3. sheet ��������
			//��Ʈ�� ���ϱ�
			int sheetCount =workbook.getNumberOfSheets();
			System.out.println("��Ʈ�� : "+sheetCount);
			
			HSSFSheet sheet = workbook.getSheet("ȸ�����"); // workbook.getSheetAt(0)
			//���� �� ���ϱ�
			int rowCount = sheet.getPhysicalNumberOfRows();
			
			for(int row=0; row<rowCount; row++) {
				//4. row ��������
				HSSFRow memRow = sheet.getRow(row);
				
				// ĭ�� ���ϱ�
				int colCount = memRow.getPhysicalNumberOfCells();
				for(int col = 0; col <colCount; col++) {
					//5. cell ��������
					HSSFCell cell= memRow.getCell(col);
					//����, ����
					if(row>0 && col==0) {// ���ڷ� �б�
						int data = (int)cell.getNumericCellValue();
						System.out.print(data+"\t");
					}else { // ���ڷ� �б�
						String data = cell.getStringCellValue();
						System.out.print(data+"\t");
					}
				}
				System.out.println();
			}
			fis.close();
			poi.close();
		} catch(Exception e) {
			System.out.println("���� ���� �߻�...");
		}
	}

	public static void main(String[] args) {
		new ReadExcel();
	}

}
