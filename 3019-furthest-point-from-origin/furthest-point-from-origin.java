class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int leftCount = 0;
        int rightCount = 0;
        int underCount = 0;
        for(int i=0;i<moves.length();i++){
            char s = moves.charAt(i);
            if(s=='L'){
                leftCount++;
            }else if(s=='R'){
                rightCount++;
            }else{
                underCount++;
            }
        }
        if(leftCount>=rightCount){
            return leftCount+underCount-rightCount;
        }else{
            return rightCount+underCount-leftCount;
        }
    }
}