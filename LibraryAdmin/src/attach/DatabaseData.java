package attach;

import java.util.HashMap;

public class DatabaseData{
	public static HashMap<Integer, DatabaseVO> hm = new HashMap<Integer, DatabaseVO>();
	public DatabaseData() {}

	public static void setDbList() {
		hm.put(1,new DatabaseVO(1,"이루다","010-8912-2286","서울특별시 영등포구","960000-0000000"));
		hm.put(2,new DatabaseVO(2,"이지은","010-7835-2346","서울특별시 용산구","930000-0000000"));
		hm.put(3,new DatabaseVO(3,"남주혁","010-9273-1190","서울특별시 강서구","950000-0000000"));
		hm.put(4,new DatabaseVO(4,"유인나","010-5302-1119","서울특별시 강남구","880000-0000000"));
		hm.put(5,new DatabaseVO(5,"황제성","010-3300-8974","서울특별시 마포구","900000-0000000"));
		hm.put(6,new DatabaseVO(6,"아이유","010-0302-1236","서울특별시 강남구","790000-0000000"));
		hm.put(7,new DatabaseVO(7,"이재용","010-2783-5567","서울특별시 강동구","980000-0000000"));
		hm.put(8,new DatabaseVO(8,"정약용","010-7726-1798","서울특별시 금천구","900000-0000000"));
		hm.put(9,new DatabaseVO(9,"신혜성","010-6762-7921","서울특별시 서초구","760000-0000000"));
		hm.put(10,new DatabaseVO(10,"박나래","011-111-9999","경기도 수원시","990000-0000000"));
		hm.put(11,new DatabaseVO(11,"Mike","010-8783-7626","러시아 블라디보스톡","780000-0000000"));
		hm.put(12,new DatabaseVO(12,"이지은","010-7135-6736","서울특별시 서대문구","980000-0000000"));
		hm.put(13,new DatabaseVO(13,"남주혁","010-1577-1577","광주광역시 서구","690000-0000000"));
		hm.put(14,new DatabaseVO(14,"유인나","010-3782-7863","인천광역시 부평구","000000-0000000"));
		hm.put(15,new DatabaseVO(15,"황제성","010-8261-9732","일본 간사이","980000-0000000"));
	}
}
