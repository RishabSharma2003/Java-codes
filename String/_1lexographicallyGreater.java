public class _1lexographicallyGreater{
    public static void main(String[] args) {
        int arr[]={600,68,9,54};
        String number[]=new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            number[i] = Integer.toString(arr[i]);
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(number[j].compareTo(number[j+1])>0){
                    String temp=number[j];
                    number[j]=number[j+1];
                    number[j+1]=temp;
                }
            }
        }
        for(String i:number)System.out.println(i+" ");
    }
}