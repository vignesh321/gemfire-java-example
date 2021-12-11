package main;

import org.apache.commons.collections.map.HashedMap;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GemfireAppMain {

    public static final String REGION = "Sample01";

    public static void main(String[] args){

        System.out.println("Insert records into cache");
        System.out.println("Start time : " + Instant.now());
        ClientCache clientCache = new ClientCacheFactory()
                .addPoolLocator("localhost", 10334)
                .create();

        clientCache.createClientRegionFactory(ClientRegionShortcut.PROXY).create(REGION);
        Region<Integer, String> putRegion = clientCache.getRegion(REGION);

        List<String> keys = new ArrayList<>();
        HashedMap map = new HashedMap();
        for (int i = 2; i<100 ; i++){
            map.put(String.valueOf(i), "Hello-World" + i);
            keys.add(String.valueOf(i));
        }
        Instant startInsert = Instant.now();

        System.out.println("Begin Insert Time : " + Instant.now());
        putRegion.putAll(map);
        Instant endInsert = Instant.now();
        System.out.println("Time for Insert : " + Duration.between(startInsert, endInsert).toMillis() + " ms");
        System.out.println("Inserted successfully");


        System.out.println("Printing records in Gemfire");
        Region<String, String> getRegion = clientCache.getRegion("Sample01");

        getRegion.getAll(keys)
                .forEach( (k,v) ->
                        System.out.println("value = " + v));

        clientCache.close();
    }
}
