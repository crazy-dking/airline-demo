import io.airlift.airline.Command;

/**
 * @description:
 * @author: wangdakai
 * @date: 2021/2/22
 */
@Command(
        name = "zip",
        description = "Generate zipped data"
)
public class MyCommand implements Runnable{
    @Override
    public void run() {
        System.out.println("自定义的命令执行");
    }
}
