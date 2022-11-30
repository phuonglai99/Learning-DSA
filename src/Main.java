import java.util.*;

public class Main {
    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int sum=0;

        List<Integer> sumOfHourglass = new ArrayList<>();
        int sizeOfArray = arr.get(0).size();
        for(int i=0;i<=sizeOfArray-3;i++){
            for(int j=0;j<sizeOfArray-3;j++){
                sum = arr.get(i).get(j) +arr.get(i+1).get(j)+arr.get(i+2).get(j)+arr.get(i+1).get(j+1)+arr.get(i).get(j+2)+arr.get(i+1).get(j+2)+arr.get(i+2).get(j+2);
                sumOfHourglass.add(sum);
            }
        }
        System.out.println(sumOfHourglass);
        return Collections.max(sumOfHourglass);

    }
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<Integer> ret = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();
        int last = 0;

        for(int i=0;i<n;i++){
            arr.add(new ArrayList<>());
        }
        System.out.println(arr.get(0));
        for(List query:queries){
            int x = (int) query.get(1);
            int y = (int) query.get(2);
            if(query.get(0).equals(1)){

                int idx = (x ^ last) % n;
                arr.get(idx).add((Integer) query.get(2));
            }
            else {
                int idx = (x ^ last) % n;
                int size = arr.get(idx).size();
                last = arr.get(idx).get(y%size);
                ret.add(last);
            }


        }
        return ret;
    }

   public static int getMod(int a, int b){
        int ret = 0;
        if(a>=0) ret = a%b;
        else {
            int x = Math.abs(a);
            int y = (int) Math.ceil((double)x/b);
            System.out.println("so y la " + y);
            ret = y*b + a;
        }
        return ret;
   }
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        List<Integer> ret = new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            ret.add(0);
        }
        for(int i=0;i<arr.size();i++){
            System.out.println("chay den phan tu i"+i);
            System.out.println(getMod(i-d,arr.size()));
            ret.set(getMod(i-d,arr.size()),arr.get(i));
        }
        return ret;
    }
    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        // Write your code here
        List<Integer> ret = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String string : stringList){
            map.put(string, map.getOrDefault(string,0)+1);
        }
        for(String query:queries){
            ret.add(map.get(query));
        }
            return ret;
    }

    public static Boolean checkExpression(String expression) {
        Stack<Character> s1 = new Stack<>();
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='{'||expression.charAt(i)=='('||expression.charAt(i)=='[')
            s1.push(expression.charAt(i));
            else if(expression.charAt(i)==')'){
                if(s1.isEmpty()) return false;
                if(s1.pop()!='(') return false;
            }
            else if(expression.charAt(i)=='}'){
                if(s1.isEmpty()) return false;
                if(s1.pop()!='{') return false;
            }
            else if(expression.charAt(i)==']'){
                if(s1.isEmpty()) return false;
                if(s1.pop()!='[') return false;
            }
        }
        return s1.isEmpty();

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String in = input.nextLine();
            System.out.println(checkExpression(in));
        }

    }
}