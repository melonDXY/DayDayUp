package codes.Baidu0412;

import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(source);
        String road = scanner.nextLine();
        int x = 0;
        int y = 0;
        for(int i = 0; i < road.length(); i++) {
            switch (road.charAt(i)) {
                case 'L':
                    x -= 1;
                    break;
                
                case 'R':
                    x += 1;
                    break;

                case 'U':
                    y += 1;
                    break;
                // case 'D':
                //     y -= 1;
                default:
                    y -= 1;
                    break;
            }
        }
        System.out.println( "(" + x + "," + y + ")" );
    }
    
}
