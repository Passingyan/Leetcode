package Test;

/**
 * @author yongzh
 * @date 2020/4/8
 */
public class Son extends Father {
    public void say() {
        System.out.println("Son");
    }
}


interface Test1 {

}

interface Test2 {

}

interface Test3 extends Test1, Test2 {

}