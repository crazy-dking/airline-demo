import io.airlift.airline.Cli;
import io.airlift.airline.Help;
import io.airlift.airline.ParseArgumentsUnexpectedException;

import java.util.Arrays;

/**
 * @description:
 * @author: wangdakai
 * @date: 2021/2/22
 */
public class MainGroupTest {
    public static void main(String[] args) {
        System.out.println("===> " + Arrays.asList(args));
        Cli.CliBuilder<Runnable> builder = Cli.<Runnable>builder("MyCommand:Builder");

        builder.withGroup("g1")
                .withDescription("g1:Description")
                .withDefaultCommand(Help.class)
                .withCommands(Help.class, G1MyCommand.class, G1MyCommand2.class);

        builder.withGroup("g2")
                .withDescription("g2:Description")
                .withDefaultCommand(Help.class)
                .withCommands(Help.class, G2MyCommand.class);

        Cli<Runnable> cliParser = builder.build();
        try {
            cliParser.parse(args).run();
        } catch (ParseArgumentsUnexpectedException e) {
            System.out.println("Invalid command:"+e.toString());
        }
    }
}
