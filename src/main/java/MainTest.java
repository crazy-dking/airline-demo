import io.airlift.airline.Cli;
import io.airlift.airline.Help;
import io.airlift.airline.ParseArgumentsUnexpectedException;

import java.util.Arrays;

/**
 * @description:
 * @author: wangdakai
 * @date: 2021/2/22
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println("===> " + Arrays.asList(args));
        Cli.CliBuilder<Runnable> builder = Cli.<Runnable>builder("MyCommand:Builder")
                .withDescription("MyCommand:Description")
                .withDefaultCommand(Help.class)
                .withCommands(Help.class, MyCommand.class);

        Cli<Runnable> cliParser = builder.build();
        System.out.println("getMetadata().getName()="+cliParser.getMetadata().getName());
        System.out.println("getMetadata().getDescription()="+cliParser.getMetadata().getDescription());
        System.out.println("getMetadata().getCommandGroups()="+Arrays.asList(cliParser.getMetadata().getCommandGroups()));
        System.out.println("getMetadata().getOptions()="+cliParser.getMetadata().getOptions());
        System.out.println("getMetadata().getDefaultCommand().getName()="+cliParser.getMetadata().getDefaultCommand().getName());
        try {
            cliParser.parse(args).run();
        } catch (ParseArgumentsUnexpectedException e) {
            System.out.println("Invalid command:"+e.toString());
        }
    }

}
