package sort;

/**
 * Created by painsolace on 2017/4/25.
 *
 * 要求：不使用现有方法，实现对给定的任意值开平方根，精度在0.0001之内，例如 输入 100 输出 10 （精度之内）
 */
public class KaiGenHao {

        public double kai(int n){
            double mid = n/2;
            while(true){
                if(mid*mid > n && mid*mid -n > 0.0001){
                    mid = mid/2;
                }else if(mid*mid < n && n-mid*mid > 0.0001){
                    mid = mid * 1.5;
                }else{
                    break;
                }

            }
            return mid;
        }

}
