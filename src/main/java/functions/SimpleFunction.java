package functions;

import org.apache.geode.cache.execute.FunctionAdapter;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.security.ResourcePermission;

import java.util.Collection;
import java.util.Date;

// Simple Function adapter
public class SimpleFunction extends FunctionAdapter {
    @Override
    public boolean hasResult() {
        return super.hasResult();
    }

    @Override
    public void execute(FunctionContext functionContext) {
        System.out.println("Function executed at " + new Date());
    }

    @Override
    public String getId() {
        return SimpleFunction.class.getCanonicalName();
    }

    @Override
    public boolean optimizeForWrite() {
        return super.optimizeForWrite();
    }

    @Override
    public boolean isHA() {
        return super.isHA();
    }

    @Override
    public Collection<ResourcePermission> getRequiredPermissions(String regionName) {
        return super.getRequiredPermissions(regionName);
    }

    @Override
    public Collection<ResourcePermission> getRequiredPermissions(String regionName, Object args) {
        return super.getRequiredPermissions(regionName, args);
    }
}
