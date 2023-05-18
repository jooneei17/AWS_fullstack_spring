package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Collection {
	public static void main(String[] args) throws IOException {
		// 배열 > list 
		
		List<String> list = new ArrayList<>();
		list.add("가");
		list.add("나");
		list.add("다");
		list.add("나");
		
		Set<String> strings = new LinkedHashSet<>(list);
//		strings.addAll(list); //set으로 이동
//		list.removeAll(list); //기존 list 삭제
//		list.addAll(strings); //다시 list에 추가
//		System.out.println(list);
		list = new ArrayList<>(strings);
		System.out.println(list);
		
		String[] arr = new String[list.size()];
		list.toArray(arr);
		List<String> list2 = new ArrayList<String>(Arrays.asList(arr)); //clone과 동일한 작업. (자구에서는 clone이 없기 때문에)
		
		System.out.println(list2);
		
		
		//entry 쌍
		// {a:10, b:20} //두 개의 entry를 가진다.
		// Map의 키가 Set이다. = 중복이 불가능하다. 
		//갖고 있는 entry를 Set으로 한다. 
		
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("a", 10);
		map.put("b", 10);
		map.put("c", 10);
		map.put("b", 20);
		System.out.println(map);
		
		Set<String> keys = map.keySet(); 
		System.out.println(keys); //출력값이 {} (Map 형태)
		
		Set<Map.Entry<String, Integer>> entries = map.entrySet(); //출력값이 [](Set 형태)
		System.out.println(entries);
		
		entries.forEach(entry -> {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		});
//		Set<Integer> values = new HashList<Integer>(map.values());
		List<Integer> values2 = new ArrayList<Integer>(map.values());
		System.out.println(values2);
		
		//List : ArrayList >> legacy class는 Vector
		//Set : HashSet >> legacy class는 없음
		//Map : HashMap >> legacy class는 HashTable
		
		//iterator >> enumeration
		
		Hashtable<String, String> hashtable = new Hashtable<>();
		hashtable.put("a", "가");
		hashtable.put("b", "나");
		System.out.println(hashtable);
		
		//Properties는 hashTable의 한 종류. key와 value가 모두 String으로 고정
		Properties properties = new Properties();
		properties = System.getProperties();
		properties.forEach((k, v) -> {
			System.out.println(k + ":: "+ v);
		});
		
		
		properties = new Properties();
		properties.put("a", "10");
		properties.put("b", "20");
		System.out.println(properties);
	
//		properties.list(System.out);
//		properties.list(new PrintStream(new File("abcd.properties")));
		properties.load(new FileInputStream(new File("abcd.properties")));
		System.out.println(properties);
		
	}
}
