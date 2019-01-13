import com.zhijieketang.CoffeeTask;
import com.zhijieketang.TaskTemplate;
import com.zhijieketang.TeaTask;

public class Main {

    public static void main(String[] args) {

        System.out.println("------喝茶任务------");
        TaskTemplate template = new TeaTask();
        template.任务();

        System.out.println("------喝咖啡任务------");
        template = new CoffeeTask();
        template.任务();
    }
}
