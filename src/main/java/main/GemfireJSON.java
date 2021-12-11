package main;

import models.Person;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.cache.query.SelectResults;
import org.apache.geode.pdx.JSONFormatter;
import org.apache.geode.pdx.PdxInstance;
import org.json.JSONObject;
import utils.SerializerClass;

import java.util.concurrent.ThreadLocalRandom;

public class GemfireJSON{

    public static final String REGION = "jsonRegion";

    public static void main(String[] args) throws  Exception{

        ClientCache clientCache = new ClientCacheFactory()
                .addPoolLocator("localhost", 10334)
                .setPdxSerializer(new SerializerClass())
                .create();

        clientCache.createClientRegionFactory(ClientRegionShortcut.PROXY).create(REGION);
        Region<String, PdxInstance> jsonRegion = clientCache.getRegion(REGION);


        for ( int i=1; i< 100; i++) {

            JSONObject obj = new JSONObject(new Person("person-"+i, getRandomAge(), i));
            System.out.println("json object - " + obj.toString());
            jsonRegion.put(String.valueOf(i), JSONFormatter.fromJSON(obj.toString()));
        }

        // corresponding gfsh query - query --query="select * from /jsonRegion j where j.age <30"
        //SelectResults<PdxInstance> searchResults = jsonRegion.query("age < 30");
        SelectResults<PdxInstance> searchResults = jsonRegion.query("name = 'person-99'");

        System.out.println("Total matched size for the search query " + searchResults.size() );

        searchResults
                .asList()
                .forEach(s -> System.out.println("name: " + s.getField("name")));


        clientCache.close();
    }

    /**
     * Function to return a random integer back as age
     * @return - int
     */
    private static int getRandomAge(){
        return ThreadLocalRandom.current().nextInt(6, 80 + 1);
    }
}
