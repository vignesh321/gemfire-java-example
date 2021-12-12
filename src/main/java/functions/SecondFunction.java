package functions;

import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;

import java.util.Date;

public class SecondFunction implements Function {

    public void execute(FunctionContext functionContext) {
        System.out.println("Second Function executed at " + new Date());
    }

    public String getId() {
        return getClass().getName();
    }
}
