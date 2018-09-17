package cn.com.sky.lamda;

public class Testa {

    public interface OnClickListener {
        void doOnClick();
    }


    public interface OnItemClickListener {
        void doItemClickListener(int position);
    }

    public interface IMathListener {
        int doMathOperator(int start, int plusValue);
    }


    public static void main(String[] args) {
        OnClickListener mListener = () -> System.out.println("do on Click");
        mListener.doOnClick();


        OnClickListener mListener_ = () -> {
            System.out.println("插上电源");
            System.out.println("打开电视");
        };

        mListener_.doOnClick();


        OnItemClickListener mItemListener = position -> System.out.println("position = [" + position + "]");
        mItemListener.doItemClickListener(1);



        IMathListener mPlusListener = (x, y) -> x + y;
        int sum = mPlusListener.doMathOperator(10, 5);
        System.out.println(sum);


        IMathListener mMaxListener = (x, y) -> {
            if (x > y) {
                return x;
            } else {
                return y;
            }
        };

        System.out.println(mMaxListener.doMathOperator(3,2));



    }




}
