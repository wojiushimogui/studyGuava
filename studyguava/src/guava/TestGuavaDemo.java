	package guava;
	
	import java.util.List;
	
	import com.google.common.base.Optional;
	import com.google.common.base.Preconditions;
	
	public class TestGuavaDemo {
	
		private static List<Person> getOldestMan(List<Person> personList)
		   {
		       // If nullableReference is non-null, returns an Optional instance containing that reference; otherwise returns absent().
		       //如果非空应用是非空的，返回非控制的实例，否则返回缺失
		       Optional<List<Person>> personListField= Optional.fromNullable(personList);
		        //注意，false时候，显示出调试信息
		       Preconditions.checkState(personListField.isPresent(),"personList must not be null");
		 
		       // 1,找出所有的男人
		 
		       // 2,找出年纪最大的
		         System.out.println("ok");
		       return null;
		   }
		 
		public static void main(String[] args)
		   {
		       getOldestMan(null);
		 
		   }
		
	
	}
	
	class Person{}
