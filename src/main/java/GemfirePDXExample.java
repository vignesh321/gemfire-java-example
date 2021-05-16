import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.pdx.PdxInstance;

import java.util.Arrays;
import java.util.List;

public class GemfirePDXExample {

    public static final String REGION = "ObjectMapping";

    public static void main(String[] args) {

        ClientCache clientCache = new ClientCacheFactory()
                .addPoolLocator("localhost", 10334)
                .setPdxSerializer(new SerializerClass())
                .create();

        clientCache.createClientRegionFactory(ClientRegionShortcut.PROXY).create(REGION);
        Region<Integer, PdxInstance> region = clientCache.getRegion(REGION);

        Person p = new Person("alpha", 14, 1);
//        region.put(1, p.toData());


    }

    private List<Person> getPersonList(){

        Person p1 = new Person("alpha", 14, 1);
        Person p2 = new Person("beta", 19, 2);
        Person p3 = new Person("gamma", 150, 3);
        Person p4 = new Person("john", 55, 4);
        Person p5 = new Person("sarah", 33, 5);
        Person p6 = new Person("Jones", 90, 6);
        Person p7 = new Person("Williams", 75, 7);
        Person p8 = new Person("Emma", 10, 8);
        Person p9 = new Person("Robert", 10, 9);
        Person p10 = new Person("Ruby", 21, 10);
        Person p11 = new Person("Sophia", 18, 11);
        Person p12 = new Person("Rick", 7, 12);
        Person p13 = new Person("Charles", 47, 13);
        Person p14 = new Person("Olivia", 45, 14);
        Person p15 = new Person("Mia", 11, 15);
        Person p16 = new Person("Anthony", 22, 16);
        Person p17 = new Person("Donald", 17, 17);
        Person p18 = new Person("Sandra", 39, 18);
        Person p19 = new Person("Mike", 29, 19);
        Person p20 = new Person("Donna", 35, 20);

        return Arrays.asList(p1, p2,p3,p4,p5, p6, p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20);
    }
}
