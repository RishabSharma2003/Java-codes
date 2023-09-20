public class _1positiveNoAtStartAndNegativeNoAtEnd {
    public static void main(String[] args) {
        int arr[]={1,-1,3,2,-5,-7,11};
        for(int i=0,j=0;j<arr.length;){

            if(arr[i]>0&&i<=j){
                i++;
            }
            else if(i==j||j<i){
                j++;
            }
            else if(arr[j]>0&&arr[i]<0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            else j++;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
