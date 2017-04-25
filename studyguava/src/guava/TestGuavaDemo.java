	package guava;
	
	import java.util.List;
	
	import com.google.common.base.Optional;
	import com.google.common.base.Preconditions;
	
	public class TestGuavaDemo {
	
		private static List<Person> getOldestMan(List<Person> personList)
		   {
		       // If nullableReference is non-null, returns an Optional instance containing that reference; otherwise returns absent().
		       //����ǿ�Ӧ���Ƿǿյģ����طǿ��Ƶ�ʵ�������򷵻�ȱʧ
		       Optional<List<Person>> personListField= Optional.fromNullable(personList);
		        //ע�⣬falseʱ����ʾ��������Ϣ
		       Preconditions.checkState(personListField.isPresent(),"personList must not be null");
		 
		       // 1,�ҳ����е�����
		 
		       // 2,�ҳ��������
		         System.out.println("ok");
		       return null;
		   }
		 
		public static void main(String[] args)
		   {
		       getOldestMan(null);
		 
		   }
		
	
	}
	
	class Person{}
