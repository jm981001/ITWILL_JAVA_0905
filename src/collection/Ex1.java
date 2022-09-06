package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 반복자(Iterator)
		 * - Set 과 List 객체를 차례대로 접근하기 위한 객체
		 * - Set 또는 List 객체의 iterator() 메서드를 호출하여 Iterator 타입 객체를 리턴받고
		 *   hasNext() 메서드로 다음요소 존재 여부를 판별한 뒤
		 *   next() 메서드로 요소가 존재할 경우 해당 요소를 꺼내올 수 있다.
		 * - Set 과 List 객체에 대한 통일된 접근 방법을 제공함  
		 * 	 => 단, Iterator 대신 향상된 for문 사용도 가능함
		 * */
		List list = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
		Set set = new HashSet(list);
		
		// Iterator 활용
		// 1. Set 또는 List 객체의 iterator() 메서드를 호출하여 Iterator 객체 리턴 받기
		Iterator iterator = set.iterator();
		
		// 2. while() 문의 조건식으로 Iterator 객체의 hasNext() 메서드 결과를 전달
		// => 다음 요소가 존재할 경우 true 리턴되므로, 다음요소가 존재할 동안 반복
		while(iterator.hasNext()) {
			Object o = iterator.next();
			System.out.println(o);
		}
		
		// => Set 또는 List 객체 접근 방법이 완전히 동일하며
		//    iterator() 메서드 호출 주체만 달라지므로 통일된 접근 방법이 제공됨
		printElement(list);
		System.out.println("-------------------------");
		printElement(set);
		
	}
	
	public static void printElement(Collection c) {
		Iterator iterator = c.iterator();
		while(iterator.hasNext()) {
			Object o = iterator.next();
			System.out.println(o);
		}
	}
	

}
