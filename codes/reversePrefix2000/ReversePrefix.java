package codes.DayDayUp.codes.reversePrefix2000;

public class ReversePrefix{

    public static void main(String[] args) {
        String word = "sadfawef";
        char goal = 'f';
        char[] arr = word.toCharArray();
        int idx = -1;

        for(int i=0; i<word.length(); i++){
            if(arr[i] == goal){
                idx = i;
                break;
            }
        }

        if(idx == -1){
            System.out.println(word);
        }
        else{
            int l = 0;
            int r = idx;
            char temp= arr[idx];
            while(l<r){
                temp = arr[r];
                arr[r--] = arr[l];
                arr[l++] = temp;
                
            }
            word = String.valueOf(arr);
            System.out.println(word);
        }
    }
}