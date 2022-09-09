import java.util.Random;

import static java.lang.Integer.parseInt;

public class Guess {//猜数字算法类

    public int[] randNumber(int []randnum) {//开始游戏后，产生一个没有重复数字的4位随机数
        Random random=new Random();//定义随机类
        for(int i=0;i<randnum.length;) {
            int number=random.nextInt(10);//产生一个0-9的随机数
            boolean isin=true;
            for(int j=0;j<i;j++) {
                if(number==randnum[j]) {
                    isin=false;
                }
            }
            if(isin) {
                randnum[i]=number;
                i++;
            }
        }
        return randnum;

    }
    public int[] guess(String str) {//将用户输入的字符串转成数组进行比对
        int gs=parseInt(str);
        int[] guessnum=new int[4];
        for(int i=3;i>=0;i--) {
            guessnum[i]=gs%10;
            gs=gs/10;
        }
        return guessnum;
    }
    public Result compare(int[]randnum,int[]guessnum,Client user) {
        int count1=0;int count2=0;//count1统计有几个正确数字+位置,count2统计有几个数字不在正确位置
        Result r=new Result();
        for(int i=0;i<randnum.length;i++) {
            if(randnum[i]==guessnum[i]) {
                count1++;
            }else {
                for(int j=0;j<randnum.length;j++) {
                    if(guessnum[i]==randnum[j]) {
                        count2++;
                        break;
                    }
                }

            }
        }
        String result=null;
        if(count1==randnum.length) {
            result="恭喜您!答对了";
            r.ir=true;
            r.sr=result;




        }else {
            r.ir=false;
            result="本次结果为:"+count1+"A"+count2+"B"+",请您再试一次!";
            r.sr=result;
        }

    return r;
    }
    public String correctnum(int[] randnum) {//输出正确答案
        String str="答案是:";
        for(int i=0;i<randnum.length;i++) {
            str=str+randnum[i];
        }
        return str;
    }
}
