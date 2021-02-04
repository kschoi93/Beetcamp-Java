import java.util.Arrays;
import java.util.Collections;

public class ArraysTest {
	public static void main(String[] args) {
int data[] = {34,67,77,49,28,43,69,47,21,32,54,67,98,9,65};
//배열객체의 데이터를 크기순으로 정렬
//Arrays.sort(data); // 오름차순으로 정렬
Arrays.sort(data, 0, 5); // 오름차순 정렬 < -- 0~4 까지 정렬된다 즉, 5 앞 까지만...
System.out.println("정렬후->" + Arrays.toString(data));

int data2[] = Arrays.copyOfRange(data,1,5); // 1~ 5까지 카피해라
System.out.println("copy->"+Arrays.toString(data2));

int data3[] = Arrays.copyOf(data,5); // 5까지 카피해라
System.out.println("copy->"+ Arrays.toString(data3));

//data 배열의 index 5인 위치의 값부터 data4의 index 3의 위치에 6개를 복사하라.
int data4[] = new int[20];
System.arraycopy(data, 5, data4,3,6);
System.out.println("copy->"+ Arrays.toString(data4));
	}
}
