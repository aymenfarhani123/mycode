package com.string;

public class Demo2 {
	
	public String ajoutCharAForAString(String s){
		if(s.length()<5)
			s=s.concat("a");
		return s;
	}
	
	public boolean compareIntArrays(int[] a, int[] b){
		boolean res=false;
		for(int i=0;i<a.length;i++)
			for(int j=0;j<b.length;j++)
				if(a[i]==b[j]);
				res=true;	
					
		return res;		
	}

}
