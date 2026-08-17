class Solution {
    public boolean isPalindrome(int x) {
        int temp=x;
        int rev=0;
        if(temp<0){
            return false;
        }
        else if(temp>=0 && temp<=9)
        {
            return true;
        }
        else{
        while(temp>0){
            int ld = temp%10;
            rev = rev*10+ld;
            temp=temp/10;
        }
        if(rev==x){
            return true;
        }
        else{
            return false;
        }
    }
    }
}