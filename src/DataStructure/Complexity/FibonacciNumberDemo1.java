package DataStructure.Complexity;

public class FibonacciNumberDemo1 {
    public static void main(String[] args) {
        System.out.println(fib1(10));
        System.out.println(fib2(64));
    }
    public static int fib1(int n){
        if(n<=1){
            return n;
        }
        return fib1(n-1)+fib1(n-2);//递归
    }//缺点:n越大,花费时间越长,对内存占用越大
    //复杂度估计:2^n-1-->O(2^n)
    public static int fib2(int n){
        if(n<=1){
            return n;
        }
        int first=0;
        int second=1;
        for(int i=0;i<n-1;i++){
            int sum=first+second;
            first=second;
            second=sum;
        }

        return second;//循环
    }//改进后处理快,内存占用小
    //复杂度估计:1+1+n-1+n-1->O(n)
}
