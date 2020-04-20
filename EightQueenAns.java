
public class EightQueenAns {
    //一维数组的角标代表行 value代表列
    int[] arry = new int[8];//使用回溯算法 这里使用一维数组就可以 不必使用二维数组
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        EightQueenAns eq = new EightQueenAns();
        eq.SetPos(0);
        System.out.println("一共有"+count+"种解法");
        System.out.println("一共执行了"+judgeCount+"次判断");
    }

    /*放皇后的方法
    看起来只得到了一种解法（那么说明没有理解回溯）怎样产生回溯的呢？就是因为setPos的是下一个如果下一个检测出
    来不行那么就会再次执行for循环 将当前皇后放到下一个位置 然后再去判断皇后已经移动了之后的下一个皇后for循环
    遍历位置有没有冲突*/
    private void SetPos(int n) {
        if (n == 8) {
            print();
            return;
        }
        for (int i = 0; i < 8; i++) {
            arry[n] = i;//放皇后 8个位置
            if (judge(n)) {//不冲突就进行下一个皇后的判断
                SetPos(n + 1);
            }
            //冲突就继续执行for 将当前皇后放往下一个位置
        }
    }

    //判断有没有冲突的方法
    private boolean judge(int n) {//传入第几个皇后
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //这里使用绝对值判断斜线上的重复情况，根本不用像自己写的那样左边右边复杂的判断
            //并且使用一维数组不用去判断 行 了    使用短路或||
            if (arry[i] == arry[n] || Math.abs(n - i) == Math.abs(arry[n] - arry[i])) {
                return false;
            }
        }
        return true;
    }

    //打印出正确结果的方法
    private void print() {
        count++;
        for (int i = 0; i < 8; i++) {
            System.out.print(arry[i] + "  ");
        }
        System.out.println();
    }
}
