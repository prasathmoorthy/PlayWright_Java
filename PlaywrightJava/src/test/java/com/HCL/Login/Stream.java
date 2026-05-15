package com.HCL.Login;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		String a[]=new String[n];
		ArrayList<String> names= new ArrayList<String>();
		for(int i=0;i<n;i++) {
			a[i]=scanner.next();
		}
		for(int i=0;i<a.length;i++)
		{
			names.add(a[i]);
		}
		System.out.println("-----------filter----------------");
		names.stream()
			.filter(name->name.startsWith("a"))
			.forEach(System.out::println);
	System.out.println("----------ToUppercase-----------------");
	names.stream()
		.map(String::toUpperCase)
		.forEach(System.out::println);
		
		System.out.println("-------------Sorted--------------");	
		names.stream()
		.sorted()
		.forEach(System.out::println);
		
		System.out.println("-----------Distinct----------------");
		names.stream()
		.distinct()
		.forEach(System.out::println);
		
		System.out.println("-----------collect ----------------");
		ArrayList<String> collect=(ArrayList<String>) names.stream().collect(Collectors.toList());
		System.out.println(collect);
		
		System.out.println("-------------Count--------------");
		long cc=collect.stream().count();
		System.out.println(cc);
		
		System.out.println("-------------Reduce--------------");
		ArrayList<Integer> ii=new ArrayList<Integer>();
		int num[]= {10,11,12,13,14,15};
		for(int i=0;i<num.length;i++)
		{
			ii.add(num[i]);
		}
		int sum=ii.stream().reduce(0,Integer::sum);
		System.out.println(sum);
	}
	
		

}
