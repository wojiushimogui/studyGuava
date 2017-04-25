package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class StreamDemo02 {

	public static void main(String[] args) {
		List<String> names=Lists.newArrayList("wu","hao","heihei","hao");
		List<String> distinctNames=names.stream().distinct().collect(Collectors.toList());
		System.out.println(distinctNames);
	}

}
