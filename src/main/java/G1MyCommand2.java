import io.airlift.airline.Arguments;
import io.airlift.airline.Command;

/**
 * @description:
 * @author: wangdakai
 * @date: 2021/2/22
 */
@Command(name="G1MyCommand2",description="This is G1MyCommand2")

public class G1MyCommand2 implements Runnable{
    @Arguments
    private String command;

    @Override
    public void run() {
        System.out.println("G1MyCommand2=" + command);
    }
}
