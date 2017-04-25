package guava.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;

public class TestGuavaDemo01 {

	public static void main(String[] args) {
		List<Integer> list = Lists.newArrayList();		
		Set<Integer> set = Sets.newHashSet();
		Integer[] arrs = ObjectArrays.newArray(Integer.class, 100);
		
		Map<Integer,String> map = Maps.newHashMap();
		//¸ü¸´ÔÓµÄ
		Map<String,Map<String,List<Integer>>> map2 = Maps.newHashMap();
	}

}
