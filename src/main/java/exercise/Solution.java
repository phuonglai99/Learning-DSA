package exercise;

import exercise.ReadFile;

import java.io.IOException;
import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game, int position, boolean[] flag) {
        int n = game.length;
        if(position >= n ) return true;
        else if (position < 0) return false;
        else if (flag[position] == true) return false;
        else if(game[position] == 1) return false;
        else {
            flag [position] = true;
            return canWin(leap, game, position - 1, flag) || canWin(leap, game, position+1, flag) || canWin(leap,game, position+leap, flag);
        }

    }
    public static boolean canWin(int leap, int[] game){
        int start = 0;
        int n = game.length;
        boolean flag[] = new boolean[n];
        while(start < n && start + leap <n){
            if(flag[start] == true) return false;
            if(game[start] == 1) return false;

        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        String file = "data/dataofmoving";
        List<String> ac = new ArrayList<>();
        List<String> ex = ReadFile.readByJava8(file);
        List<List<Integer>> data = new ArrayList<>();

        while (q-- > 0) {
            List<Integer> temp = new ArrayList<>();
            int n = scan.nextInt();
            int leap = scan.nextInt();
            temp.add(n);
            temp.add(leap);
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
                temp.add(game[i]);
            }
            data.add(temp);
            String ret = (canWin(leap, game, 0, new boolean[n])) ? "YES" : "NO";
            ac.add(ret);
        }
        scan.close();
        for(int i=0;i<ex.size();i++){
            if(!ac.get(i).equals(ex.get(i)))
                System.out.println(i + " ac " + ac.get(i) + " ex "+ ex.get(i) + " data "+data.get(i));
        }
    }
}