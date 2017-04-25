package test;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class PreconditionsTest {
	@Test
	public void testPreconditions(){
		try{
			checkPersonByPrecondtions(null,23);//name Ϊ null
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			checkPersonByPrecondtions("",23);//name Ϊ ""
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			checkPersonByPrecondtions("wu",-10);//ageС��0
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			checkPersonByPrecondtions("wu",23);//����
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		List<Integer> list = Lists.newArrayList();
		int len = 10;
		for(int i=0;i<len;i++){
			checkState(list,len);
			list.add(i);
		}
		
	}
	private void checkState(List<Integer> list, int len) {
		Preconditions.checkState(list.size()<len);
	}
	//����Precondtions�����name��age����Ч��
	private void checkPersonByPrecondtions(String name, int age) {
		
		Preconditions.checkNotNull(name, "name Ϊ null");
		Preconditions.checkArgument(name.length()>0, "name Ϊ\"\"");
		Preconditions.checkArgument(age>0, "age С���� ");
		System.out.println("name:"+name+",age:"+age);
	}
	
	public void CheckUseIf(String name,int age){
		if(name==null||name.length()==0||age<0||age>100){
			System.out.println("�����������");
		}
		//do something ....
	}
}
