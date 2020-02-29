package com.string;

public class Demo {
	
	public boolean equalsString(String a,String b){
		boolean r=false;
		if(a.equals(b))
			r=true;
		return r;
	}
	
	public boolean equlasInteger(int a, int b){
		boolean rs=false;
		if(a==b)
			rs=true;
		return rs;
	}
	
	
	public boolean equlasBoolean(boolean a, boolean b){
		boolean rs=false;
		if(a==b)
			rs=true;
		return rs;
	}
	
	
	public int maxInt(int[] tab){
		int max=0;
		for(int i=0;i<tab.length; i++)
			if(tab[i]>=max)
				max=tab[i];
		return max;
	}
}
