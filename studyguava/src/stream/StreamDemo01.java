package stream;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class StreamDemo01 {

	public static void main(String[] args) {
		List<String> names=Lists.newArrayList("wu",null,"hao","heihei");
		List<String> namesAfterFilter = names.stream().filter(name->name!=null).collect(Collectors.toList());
		System.out.println(namesAfterFilter);
	}

}
