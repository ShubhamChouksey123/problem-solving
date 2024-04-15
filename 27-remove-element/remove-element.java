class Solution {

     public void swapArrayElement(int[] nums, int index1, int index2){

        int n = nums.length;

        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;


    }
    public int removeElement(int[] nums, int val) {
        

         int n = nums.length;
        int sortedTil = 0;
        int index = 0;


        while(index < n){
            System.out.println("sorted array : " + Arrays.toString(nums));
            System.out.println("sortedTil : " + sortedTil + " and index : " + index);

            if(sortedTil > index){
                index = sortedTil;
                continue;
            }

            if(nums[index] == val){
                index++;
                continue;
            }
            if(nums[sortedTil] != val){
                sortedTil++;
                continue;
            }

            if(sortedTil == index){
                index++;
                continue;
            }

            System.out.println("nums[sortedTil] : " + nums[sortedTil] + " and nums[index] : " + nums[index]);

            if(nums[sortedTil] == val && nums[index] != val){
                swapArrayElement(nums,sortedTil ,index);
                index++;
                sortedTil++;
            }

        }

        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != val)
                count++;
        }
        return count;
    }
}