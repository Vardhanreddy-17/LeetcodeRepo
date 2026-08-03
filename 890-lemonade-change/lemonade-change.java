class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        boolean isChange = true;
        for(int i=0;i<bills.length;i++){
            int bill = bills[i];
            if(bill==5){
                five++;
            }else if(bill==10){
                if(five>0){
                    five--;
                    ten++;
                }else{
                    isChange = false;
                    break;
                }
            }else if(bill==20){
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }else if(five>2){
                    five = five - 3;
                }else{
                    isChange = false;
                    break;
                }
            }
        }
        return isChange;
    }
}