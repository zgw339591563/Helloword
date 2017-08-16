package com.atguigu.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class AA1 {

	public static void main(String[] args) {
		//去重复数值+数值大于4+升序排列后只返回前3个元素
		List<Integer> list = Arrays.asList(1,2,3,3,3,4,0,-11,5,6,7,8,9);
		/*HashSet<Integer> set = new HashSet<>(list);
		ArrayList<Integer> arrayList = new ArrayList<>();
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext()){
			Integer next = iterator.next();
			if(next>4){
				arrayList.add(next);
			}
		}
		arrayList.sort(null);
		System.out.println(arrayList.subList(0, 3));*/
		list.stream().distinct().sorted().filter(p -> p>4).limit(3).forEach(System.out::println);
		
	}
}
