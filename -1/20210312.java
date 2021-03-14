package com.company;
//有一组数，只有一个数出现一次，其他数都是两两连续出现，找出只出现一次数的下标3 3 2 1 1 4 4
public class Main {

    public static void main(String[] args) {
	// write your code here
        String res="1122933445566";
        System.out.println(helper(res,0,res.length()-1));
    }

    private static int helper(String s,int left,int right){
        if(left==right){
            return left;
        }


        int middle=(left+right)/2;

        if(s.charAt(middle)!=s.charAt(middle+1)) {
            if((middle-left+1)%2==0){
                return helper(s, middle+1,right);
            }else{
                return helper(s, left,middle);
            }
        }else{
            if((middle-left)%2==0){
                return helper(s, middle, right);
            }else{
                return helper(s, left, middle-1);
            }
        }




    }
}
