import org.apache.commons.collections.map.HashedMap;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;

import java.util.*;

public class GemfireAppMain {

    public static final String REGION = "Sample01";

    public static void main(String[] args){

        System.out.println("Insert records into cache");

        ClientCache clientCache = new ClientCacheFactory()
                .addPoolLocator("localhost", 10334)
                .create();

        clientCache.createClientRegionFactory(ClientRegionShortcut.PROXY).create(REGION);
        Region<Integer, String> putRegion = clientCache.getRegion(REGION);

        List<String> keys = new ArrayList<>();
        Map map = new HashedMap();
        for (int i = 2; i<100 ; i++){
            map.put(String.valueOf(i), "Hello-World" + i);
            keys.add(String.valueOf(i));
        }

        putRegion.putAll(map);
        System.out.println("Inserted successfully");
        System.out.println("Printing records in Gemfire");
        Region<String, String> getRegion = clientCache.getRegion("Sample01");

        getRegion.getAll(keys)
                .forEach( (k,v) ->
                        System.out.println("value = " + v));

        clientCache.close();
    }
}
