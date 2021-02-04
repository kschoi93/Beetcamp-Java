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
			//Excel 파일 읽어오기
			File f = new File("d://javaIO/member.xls");
			FileInputStream fis = new FileInputStream(f);
			
			//1. POI객체를 가져오기
			POIFSFileSystem poi = new POIFSFileSystem(fis);
			//2. workbook 가져오기
			HSSFWorkbook workbook= new HSSFWorkbook(poi);
			//3. sheet 가져오기
			//시트수 구하기
			int sheetCount =workbook.getNumberOfSheets();
			System.out.println("시트수 : "+sheetCount);
			
			HSSFSheet sheet = workbook.getSheet("회원목록"); // workbook.getSheetAt(0)
			//행의 수 구하기
			int rowCount = sheet.getPhysicalNumberOfRows();
			
			for(int row=0; row<rowCount; row++) {
				//4. row 가져오기
				HSSFRow memRow = sheet.getRow(row);
				
				// 칸수 구하기
				int colCount = memRow.getPhysicalNumberOfCells();
				for(int col = 0; col <colCount; col++) {
					//5. cell 가져오기
					HSSFCell cell= memRow.getCell(col);
					//숫자, 문자
					if(row>0 && col==0) {// 숫자로 읽기
						int data = (int)cell.getNumericCellValue();
						System.out.print(data+"\t");
					}else { // 문자로 읽기
						String data = cell.getStringCellValue();
						System.out.print(data+"\t");
					}
				}
				System.out.println();
			}
			fis.close();
			poi.close();
		} catch(Exception e) {
			System.out.println("파일 오류 발생...");
		}
	}

	public static void main(String[] args) {
		new ReadExcel();
	}

}
