package com.HCL.Login;

public class TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Execution e=new Execution();
		e.reverse("Hello World");
		e.Frequency("abcdefgabc");	
		int a[]= {5,7,6,9,2,8,4,3};
		e.SecondLargestNumber(a);
		e.Countvowel("Hello World");
		int b[]= {1,1,2,1,3,4,5,5,6,7,8,9,9};
		e.RemoveDuplicate(b);
		e.Sorting(a);
		e.Palindrome("Madam");
		e.primeNumber(29);
		int c[]={2,7,8,10,4,8,7,10};
		e.SecondLargestNumber(c);
		e.swapNumber(10,20);
		int rev =e.ReverseInteger(12345);
		System.out.println(rev);
	}

}
