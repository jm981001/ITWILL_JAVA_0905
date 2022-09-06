package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 3. Map 계열 (= DTO)
		 * - 데이터 키(Key)와 값(Value) 한쌍의 형태로 관리하는 자료구조
		 * - 키는 중복이 불가능하며, 값은 중복이 가능함 
		 *   => 키 관리 객체 : Set(중복 제거에 효과적)
		 * - 구현체 클래스 : HashMap, Properties 등  
		 * */
		
		Map map = new HashMap();
		
		map.put(1, "Java");
		map.put(2, "JSP");
		map.put(3, "Android");
		
		System.out.println("map 객체의 모든 키와 값 출력: " + map);
		
		// 중복되는 키를 사용하여 다른 값을 저장하는 경우
		// => 기존에 3번키가 존재하므로 "Android" 값을 제거하고, "Oracle" 값 저장 (덮어쓰기)
		//    이때, 제거되는 값 "Android" 가 Object 타입으로 리턴됨
//		map.put(3, "Oracle");
		System.out.println("3번 키에 Oracle 문자열 저장 : " + map.put(3, "Oracle"));
		System.out.println("map 객체의 모든 키와 값 출력: " + map);
		
		// 새로운 키에 중복된 값을 저장하는 경우
		map.put(4, "JSP");
		System.out.println("map 객체의 모든 키와 값 출력: " + map);
		
		// Object get(Object key) : key에 해당하는 value 리턴
		// => key 가 존재하지 않으면 null 값 리턴됨
		System.out.println("정수 2에 해당하는 키의 데이터: " + map.get(2));
		System.out.println("정수 6에 해당하는 키의 데이터: " + map.get(6));
		
		// Set keySet() : Map 객체 내의 모든 키 리턴
		Set keySet = map.keySet();
		System.out.println("map 객체 내의 모든 키 : " + keySet);
		
		// Collection values() : Map 객체 내의 모든 값 리턴
		// => Set 타입 또는 List 타입 등의 변수에 할당 불가능(다운캐스팅도 불가능!)
		System.out.println("map 객체 내의 모든 값 : " + map.values());
		
//		Set values = (Set)map.values();
//		List values = (List)map.values();
		
		// Set 또는 List 계열 객체 생성 시 파라미터로 전달하여 객체 변환 가능
//		Set values = new HashSet(map.values());
		// => 만약, 중복된 값이 존재할 경우 Set 타입으로 관리하면 중복이 제거되므로 주의!
//		List values = new ArrayList(map.values());
//		System.out.println("map 객체 내의 모든 값 : " + values);
		
		// Set entrySet() : 키와 값을 한쌍으로 갖는 Map.Entry 객체의 모임
		// => 키와 값의 한쌍이 다른 키와 값의 한쌍과 중복될 수 없으므로 Set 타입으로 관리됨
		Set entrySet = map.entrySet();
		System.out.println(entrySet);
		
		System.out.println("map 객체가 비어있는가? " + map.isEmpty());
		System.out.println("map 객체에 저장된 요소 갯수 : " + map.size());
		
		// 요소를 제거하는 remove() 메서드는 2가지로 제공됨
		// Object remove(Object key) : key 에 해당하는 요소 제거
		System.out.println("4번 key에 해당하는 요소 제거 : " + map.remove(4));
		System.out.println("map 객체 내의 모든 값 : " + map);
		// 만약, 존재하지 않는 키를 지정할 경우 null 값 리턴됨
		System.out.println("4번 key에 해당하는 요소 제거 : " + map.remove(4));
		
		// boolean remove(Object key, Object value) : key와 value 모두 일치하는 요소 제거
		System.out.println("3번 key의 Oracle 값에 해당하는 요소 제거 : " + map.remove(3, "Oracle"));
		System.out.println("map 객체 내의 모든 값 : " + map);
		
		// 만약, 키와 값이 일치하지 않거나 존재하지 않는 키를 지정할 경우 false 리턴됨
		System.out.println("3번 key의 Oracle 값에 해당하는 요소 제거 : " + map.remove(3, "Oracle"));
		System.out.println("2번 key의 JAVA 값에 해당하는 요소 제거 : " + map.remove(2, "JAVA"));
		System.out.println("map 객체 내의 모든 값 : " + map);
		
		System.out.println("===========================");
		
		// HashMap 객체 (map2) 생성 후 다음 요소 추가
		// 		KEY			VALUE
		// "010-1234-5678"	"홍길동"
		// "010-2222-3333"	"이순신"
		// "010-4444-5555"	"강감찬"
		Map map2 = new HashMap();
		map2.put("010-1234-5678", "홍길동");
		map2.put("010-2222-3333", "이순신");
		map2.put("010-4444-5555", "강감찬");
		System.out.println(map2);
		System.out.println("===============================");
		// map2 객체 내의 모든 key와 value를 다음 형식으로 출력
		// 이름: XXX, 전화번호: XXX
		
		// Map 객체 반복하는 방법
		// 1. Iterator(반복자) 사용 시
		// => Map 객체의 keySet() 메서드를 호출하여 모든 키를 꺼낸 다음
		//    해당 Key가 저장된 Set 객체의 iterator() 메서드를 호출하여
		//    Iterator 객체 리턴 받아 사용
	 	Set keySet2 = map2.keySet();
	 	Iterator keyIterator = keySet2.iterator();
	 	
	 	while(keyIterator.hasNext()) { // 다음 요소 (키) 가 존재할 동안 반복
	 		// 1) 키를 꺼내기 위해서 next() 메서드로 반복자의 키 하나씩 접근
	 		// => 이때, next() 메서드 리턴타입이 Object 이므로 상황에 따라 형변환 필요
	 		String phone = keyIterator.next().toString();
	 		String name = map2.get(phone).toString();
	 		
	 		System.out.println("이름: " + name + ", 전화번호: " + phone);
	 	}
	 	
	 	System.out.println("-----------------------------------");
	 	// Key를 사용하여 반복하지 않고 Map.Entry 객체를 통한 반복
	 	Set entrySet2 = map2.entrySet();
	 	Iterator entryInterator = entrySet2.iterator();
	 	
	 	while(entryInterator.hasNext()) {
	 		Map.Entry entry = (Map.Entry)entryInterator.next();
	 		
	 		String phone = entry.getKey().toString();
	 		String name = entry.getValue().toString();
	 		System.out.println("이름: " + name + ", 전화번호: " + phone);
	 	}
		
		System.out.println("-----------------------------------");
		
		// 2. 향상된 for문 사용하여 접근
		for(Object phone : map2.keySet()) {
			Object name = map2.get(phone);
			System.out.println("이름: " + name + ", 전화번호: " + phone);
		}
		
		Map<String, String> map3 = new HashMap(map2);
		for(Map.Entry<String, String> entry : map3.entrySet()) {
			System.out.println("이름: " + entry.getValue() + ", 전화번호: " + entry.getKey());
		}
		
		// ===========================================================
		
		// boolean containsKey(Object key) : 해당 key의 존재 여부 리턴
		System.out.println("010-1234-5678 전화번호(key)가 존재하는가? " +
						map2.containsKey("010-1234-5678"));
		System.out.println("010-1234-9999 전화번호(key)가 존재하는가? " +
				map2.containsKey("010-1234-9999"));
		
		// boolean containsValue(Object value) : 해당 value의 존재여부 리턴
		System.out.println("홍길동 이름(값)이 존재하는가? " + map2.containsValue("홍길동"));
		System.out.println("김태희 이름(값)이 존재하는가? " + map2.containsValue("김태희"));
		
		// void clear() : 모든 키와 값을 초기화
		map2.clear();
		System.out.println(map2);
		
	}

}

