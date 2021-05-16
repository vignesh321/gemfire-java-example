import org.apache.geode.cache.Declarable;
import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializer;
import org.apache.geode.pdx.PdxWriter;

public class SerializerClass implements PdxSerializer, Declarable {

    @Override
    public boolean toData(Object o, PdxWriter pdxWriter) {
        return false;
    }

    @Override
    public Object fromData(Class<?> aClass, PdxReader pdxReader) {
        return null;
    }
}
