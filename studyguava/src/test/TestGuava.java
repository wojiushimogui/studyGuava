package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;

public class TestGuava {

	@Test
	public void test() {

	}
	@Test
    public void testCotyOf(){
        ImmutableSet<String> imSet=ImmutableSet.of("peida","jerry","harry","lisa");
        System.out.println("imSet："+imSet);
        ImmutableList<String> imlist=ImmutableList.copyOf(imSet);
        System.out.println("imlist："+imlist);
        ImmutableSortedSet<String> imSortSet=ImmutableSortedSet.copyOf(imSet);
        System.out.println("imSortSet："+imSortSet);
        
        List<String> list=new ArrayList<String>();
        for(int i=0;i<20;i++){
            list.add(i+"x");
        }
        System.out.println("list："+list);
        ImmutableList<String> imInfolist=ImmutableList.copyOf(list.subList(2, 18));
        System.out.println("imInfolist："+imInfolist);
        int imInfolistSize=imInfolist.size();
        System.out.println("imInfolistSize："+imInfolistSize);
        ImmutableSet<String> imInfoSet=ImmutableSet.copyOf(imInfolist.subList(2, imInfolistSize-3));
        System.out.println("imInfoSet："+imInfoSet);
    }
	@Test
	public void testUnmodifiableCollection(){
		List<String> list = Lists.newArrayList("a","b","c");
		List<String> unmodifyList = Collections.unmodifiableList(list);
		System.out.println(unmodifyList);
		
		//unmodifyList.add("d"); //抛异常
		
		list.add("e");
		
		System.out.println(unmodifyList);
	}
	@Test 
	public void testImmutable(){
		List<String> list = Lists.newArrayList("a","b","c");
		ImmutableList<String> imList = ImmutableList.copyOf(list);
		System.out.println(imList);
		list.add("d");
		System.out.println("修改原始集合之后，imList的内容为："+imList);
		
		ImmutableList<String> imOfList = ImmutableList.of("wo", "jiu","shi","mogui");
		System.out.println(imOfList);
		
		ImmutableSet<String> imBuildSet = ImmutableSet.<String>builder().add("hello")
				.add("world").build();
		
		System.out.println(imBuildSet);
	}
	@Test
	public void testMultiSet(){
		Set<String> set = Sets.newHashSet("a","b","c");
		Multiset<String> multiset =  HashMultiset.create();
		multiset.addAll(set);
		multiset.add("a");
		System.out.println(multiset);
		Set<String> keys = multiset.elementSet();
		for(String key:keys){
			System.out.println(key+", count:" +multiset.count(key));
		}
	}
	@Test
	public void testMultimap(){
		Multimap<String,Integer> multimap = ArrayListMultimap.create();
		multimap.put("a", 1);
		multimap.put("a", 2);
		multimap.put("b", 3);
		multimap.put("c", 4);
		System.out.println(multimap);
		System.out.println(multimap.size());//所有元素的个数
		System.out.println(multimap.keySet().size());//不同的key的个数
		//检查multimap是否有"x"这个键
		String key ="x";
		//这个检查就说明了即使multimap中不含key，也不是返回null，而是返回的是一个空集合
		if(multimap.get(key)!=null){
			System.out.println("multimap中含有key:"+key);
		}
		//asMap的使用
		Map<String,Collection<Integer>> map = multimap.asMap();
		
		if(map.get(key)==null){//这里可以直接用 map.containsKey(key)
			System.out.println("multimap中不含有key:"+key);
		}
	}
	@Test
	public void testOption(){
		Optional<Integer> possible=Optional.of(10);
        Optional<Integer> absentOpt=Optional.absent();
        Optional<Integer> NullableOpt=Optional.fromNullable(null);
        Optional<Integer> NoNullableOpt=Optional.fromNullable(10);
        if(possible.isPresent()){
            System.out.println("possible isPresent:"+possible.isPresent());
            System.out.println("possible value:"+possible.get());
        }
        if(absentOpt.isPresent()){
            System.out.println("absentOpt isPresent:"+absentOpt.isPresent()); ;
        }
        if(NullableOpt.isPresent()){
            System.out.println("fromNullableOpt isPresent:"+NullableOpt.isPresent()); ;
        }
        if(NoNullableOpt.isPresent()){
            System.out.println("NoNullableOpt isPresent:"+NoNullableOpt.isPresent()); ;
        }
	}
	@Test
    public void testMethodReturn() {
        Optional<Long> value = method();
        if(value.isPresent()){
            System.out.println("获得返回值: " + value.get());
        }
        else{//如果Optional实例中包含的Long对象实例为null
                
            System.out.println("获得返回值: " + value.or(-12L));   // -12  
        }
        
        System.out.println("获得返回值 orNull: " + value.orNull()); // null
        
        Optional<Long> valueNoNull = methodNoNull();
        if(valueNoNull.isPresent()){
            Set<Long> set=valueNoNull.asSet();
            System.out.println("获得返回值 set 的 size : " + set.size()); // 1   
            System.out.println("获得返回值: " + valueNoNull.get());     //15
            System.out.println("获得返回值：" + valueNoNull.or(100L));
        }
        else{
            System.out.println("获得返回值: " + valueNoNull.or(-12L));    
        }
        
        System.out.println("获得返回值 orNull: " + valueNoNull.orNull());
    }

    private Optional<Long> method() {
        return Optional.fromNullable(null);
    }
    private Optional<Long> methodNoNull() {
        return Optional.fromNullable(15L);
    }

}
