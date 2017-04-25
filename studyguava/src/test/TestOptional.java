package test;

import guava.Employee;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

public class TestOptional {

	@Test
	public void test() {
		List<Employee> employees = Lists.newArrayList(new Employee("A",21),
				new Employee("B",22),
				null,
				new Employee("C",23)
				);
		int employeeAgeSum = 0;
		for(Employee e :employees){
			if(e!=null){
				employeeAgeSum+=e.getAge();
			}
		}
		System.out.println("employee age sum:"+employeeAgeSum);
		
	}
	@Test
	public void testOptional(){
		List<Employee> employees = Lists.newArrayList(new Employee("A",21),
				new Employee("B",22),
				null,
				new Employee("C",23)
				);
		int employeeAgeSum = 0;
		for(Employee e :employees){
			if(e!=null){
				employeeAgeSum+=Optional.fromNullable(e).
						or(new Employee("default",0)).getAge();
			}
		}
		System.out.println("employee age sum:"+employeeAgeSum);
	}

}
