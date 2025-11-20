class Solution {
    public int singleNonDuplicate(int[] nums) {
        int size = nums.length;
        if(size==1){ // handling single element 
            return nums[0];
        }
        if(nums[0]!=nums[1]){ // handle lower boundry case 
            return nums[0];
        }
        if(nums[size-1]!=nums[size-2]){ // handle upper boundry case
            return nums[size-1];
        }
        int low = 1; //1 handled the lower boundry case above
        int high = size - 2; //n-2 handled the upper boundry case above
        //binary search
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){ // unique element
                return nums[mid];
            }
            if((mid%2==1 && nums[mid-1]==nums[mid]) || (mid%2==0 && nums[mid+1]==nums[mid])){
                low = mid + 1; //Element present in right side of the index
            }else{
                high = mid - 1; //Element preent in the left of the index
            }
        }
        return -1; // No unique  element found 
    }
}