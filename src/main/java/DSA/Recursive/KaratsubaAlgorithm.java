package main.java.DSA.Recursive;

public class KaratsubaAlgorithm {
    public static int maxNum(int a, int b){
        return a>b?a:b;
    }
    public static int numberOfDigits(int a,int count){
        //int count = 0;
        if(a==0) return count;
        else {
            return numberOfDigits(a/10,count+1);
        }
    }
    public static long calculate(int x,int y){
        int a,b,c,d;
        long step1, step2,step3;
        int n = numberOfDigits(maxNum(x,y),0);
        if(n/2==0) return (long) x*y;
        //System.out.println("debug 1:"+(int) Math.pow(10,n/2));
        a = x/(int) Math.pow(10,n/2);
        b = x - a*(int) Math.pow(10,n/2);
        c = y/(int) Math.pow(10,n/2);
        d = y - c*(int) Math.pow(10,n/2);
        step1 = calculate(a,c);
        step2 = calculate(a+b,c+d);
        step3 = calculate(b,d);
        //System.out.println(n+" "+a+" "+b+" "+c+" "+d);
        return (long) (step1*Math.pow(10,n)+(step2 -step1 -step3)*Math.pow(10,n/2)+step3);
    }

    public static void main(String[] args) {
        int a = 1000;
        int b = 123;
        //System.out.println(numberOfDigits(a,0));
        System.out.println(calculate(a,b));
    }
}
