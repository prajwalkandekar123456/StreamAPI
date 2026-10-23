package com.StreamApi.StreamApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamApiApplication.class, args);
		System.out.println("Running.........");
		
		List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Yanksha", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "Francesca", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "Melanie", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new Employee(5, "Padma", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "Milad", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "Uzma", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "Ali", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "Ram", 25, 160, "M", "IT", "Blore", 2010));
        
        /*
         * Group the employees by a single field, like city or age
         */
        
        Map<String,List<Employee>> groupByCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("Group by city :-> "+groupByCity);
        
        Map<Integer,List<Employee>> groupByAge = empList.stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println("Group by Age :-> "+groupByAge);
        
        /*
         * Find the count of male and female employees present in the organization.
         */
        Map<String,Long> noOfMaleAndFemale = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println("No. of Male and Female Employees : -> "+noOfMaleAndFemale);
        
        /*
         * Find the count of male and female present in each department
         */
        Map<String,Map<String,Long>> countOfMaleFemaleDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
        		Collectors.groupingBy(Employee::getGender,Collectors.counting()))
        		);
        System.out.println("Counting male and female in each department :-> "+countOfMaleFemaleDept);
        
        /*
         * Print the names of all distinct departments in the organization.
         */
        List<String> distinctDept = empList.stream().map(e->e.getDeptName()).distinct().toList();
        System.out.println("Names of all distinct departments -> "+distinctDept);
        
        /*
         * Print employee details whose age is greater than 28 in the organisation.
         */
        List<Employee> ageGreaterThan = empList.stream().filter(e->e.getAge()>28).toList();
        System.out.println("Age greater than 28 -> "+ageGreaterThan);
        
        /*
         * Find maximum age/oldest of employee in the organisation.
         */
        Optional<Employee> oldestEmp = empList.stream().max(Comparator.comparing(Employee::getAge));
        System.out.println("Oldest employee --> "+oldestEmp);
        
        /*
         * Print Average age of Male and Female Employees in the organisation.
         */
        Map<String,Double> avgAge = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge)));
        System.out.println("Average age of male and female Employees -> "+avgAge);
        
        /*
         * Print Average age of Male and Female Employees in each department.
         */	
        Map<String,Map<String,Double>> avgAgeEachDept = empList.stream().collect(
        		Collectors.groupingBy(Employee::getDeptName,Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge))));
        System.out.println("Average age of male and Female in Each Department -> "+avgAgeEachDept);
        		
        /*
         * Print the number of employees in each department.
         */
        Map<String,Long> empCnt = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()));
        System.out.println("Number of Employees in each department -> "+empCnt);
        
        /*
         * Find the longest-serving employees in the organization
         */
        List<Employee> longestServe = empList.stream().
	}

}
