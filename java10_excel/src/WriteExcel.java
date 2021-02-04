import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 * 자바에서 엑셀로 쓰기 읽기
 * 
 * jakarta.apache.org에서 poi를 다운로드 받는다
 * poi-5.0.0.jar, commons=math3-3.6.1.jar를 
 * 
 * buildPath 설정 - > project에서 마우스 오른쪽 buildPath 선택
 * workbook 생성 -> sheet 생성 -> row 생성 -> cell 생성
 */
public class WriteExcel {

	public WriteExcel() {
		//엑셀로 쓰기
		
		//1. workbook 객체 만들기
		HSSFWorkbook workbook= new HSSFWorkbook();
		//2. sheet 객체 생성
		HSSFSheet sheet1 = workbook.createSheet("회원목록");
		HSSFSheet sheet2 = workbook.createSheet();
		
		//3. row 객체 생성
		HSSFRow row1 = sheet1.createRow(0);
		
		//4. cell 객체 생성
		HSSFCell cell1 = row1.createCell(0);
		
		//5. Value 셋팅
		cell1.setCellValue("번호");
		row1.createCell(1).setCellValue("이름");
		row1.createCell(2).setCellValue("연락처");
		row1.createCell(3).setCellValue("이메일");
		
		/////////////////////////////////////
		String data[][] = {
				{"1","홍길동","010-1234-5678","aaaa@nate.com"},
				{"2","김길동","010-1111-2222","bbbb@nate.com"},
				{"3","박길동","010-7777-8888","cccc@nate.com"},
				{"4","이길동","010-3333-4444","dddd@nate.com"},
				{"5","최길동","010-5555-6666","eeee@nate.com"}
		};
		
		for(int r=0; r<data.length; r++) {
			HSSFRow cRow = sheet1.createRow(r+1);
			for(int c=0; c<data[r].length; c++) {
				if(c==0) {
					//번호를 숫자로 변경하여 저장
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
		System.out.println("엑셀로 쓰기 완료");
	}
	public static void main(String[] args) {
		new WriteExcel();
	}

}
