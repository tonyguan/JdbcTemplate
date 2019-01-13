import com.zhijieketang.TaskTemplate;

public class Main2 {

    public static void main(String[] args) {

        System.out.println("------喝茶任务------");
        TaskTemplate template = new TaskTemplate() {

            @Override
            protected void 冲泡() {
                System.out.println("来壶铁观音。");
            }
        };
        template.任务();

        System.out.println("------喝咖啡任务------");
        template = new TaskTemplate() {
            @Override
            protected void 冲泡() {
                System.out.println("冲卡布奇诺咖啡+糖+奶。");
            }
        };
        template.任务();

    }
}
