package com.HCL.Login;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

public class Execution {
	
	public void name() {
		
	}
	
	public void Palindrome(String str) {
		String name="";
		for(int i=0;i<str.length();i++) {
			name=name+str.charAt(i);
		}
		name.toLowerCase();
		str.toLowerCase();
		if(name.equals(str))
		{
			System.out.println("Palindrome");
		}
		 else
		 {
			 System.out.println("Not Palindrome");
		 }
	}
	
	
	public void Sorting(int arr[]) {
		System.out.println();
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int num:arr)
		{
			System.out.print(num+" ");
		}
		System.out.println();
	}
	
	public int RemoveDuplicate(int arr[]) {
		HashSet<Integer> set=new HashSet<>();
		for(int num:arr)
		{
			set.add(num);
		}
		for(int num:set)
		{
			System.out.print(num);
		}
		return 0;
		
	}

	public void reverse(String str)
	{
		String rev="";
		for(int i=str.length()-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
		}
		System.out.println("Reverse of the string is: "+rev);
		
	}
	
	public void Frequency(String str) {
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(map.containsKey(c))
			{
				map.put(c, map.get(c)+1);
			}	
			else
			{
				map.put(c, 1);
			}
		}
		for(Entry<Character, Integer> entry:map.entrySet())
		{
			System.out.println(entry.getKey()+"->"+entry.getValue());
		}
		
	}
	
	public void SecondLargestNumber(int arr[]) {
		Arrays.sort(arr);
		System.out.println(arr[arr.length-2]);
		
	}
	
	public void Countvowel(String str) {
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
			{
				if(map.containsKey(c))
				{
					map.put(c, map.get(c)+1);
				}
				else 
				{
					map.put(c, 1);
				}
			}
		}
		System.out.println("Vowel count in the string is: "+map);
	}

	public void primeNumber(int n) {
		boolean flag=true;
		if(n<=1)
		{
			flag=false;
		}
		else{
			for(int i=2;i<Math.sqrt(n);i++)
			{
				if(n%i==0)
				{
					flag=false;
					break;
				}
			}
		}
		if(flag){
			System.out.println(n+" Prime number");
		}
		else{
			System.out.println(n+" Not Prime number");
		}
	}


	public static int SecondLargestNumberInarray(int a[]){
		int l=a[0];
		for(int i=1;i<a.length;i++){
			if(a[i]>l){
				l=a[i];
			}
		}
		return l;
	}
	public void swapNumber(int a,int b){
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println(a+" swap number is: "+a);
		System.out.println(b+" swap number is: "+b);
	}

	public static int ReverseInteger(int a){
		int rev=0;
		while(a!=0){
			int digit=a%10;
			rev=rev*10+digit;
			a=a/10;
		}
		return rev;
	}

}

