public class BalancedArray {


    public int balancedArray(int[] input){
        int totalSum = 0;
        for(int i=0;i<input.length;i++){
            totalSum+=input[i];
        }
        int runningSum = 0;
        for(int i=0;i<input.length-1;i++){
            int rightSum = totalSum-runningSum-input[i];
            if(runningSum==rightSum){
                return i;
            }
            runningSum+=input[i];
        }
        return -1;
    }


    public static void main(String[] args){
        BalancedArray balancedArray=new BalancedArray();
        int[] input ={1,2,3,4,6};
        int value = balancedArray.balancedArray(input);
        System.out.println(value);

    }

}
