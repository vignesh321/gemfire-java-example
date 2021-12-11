package models;

public class Person /*implements PdxSerializable*/ {

    private int id;

    private String name;

    private int age;

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Person(){
        /**
         * Empty constructor for serialization
         */
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "models.Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

   /* @Override
    public void toData(PdxWriter pdxWriter) {
        pdxWriter.writeInt("id", id);
        pdxWriter.markIdentityField("id");
        pdxWriter.writeString("name", name);
        pdxWriter.writeInt("age", age);
    }

    @Override
    public void fromData(PdxReader pdxReader) {
        id = pdxReader.readInt("id");
        name = pdxReader.readString("name");
        age = pdxReader.readInt("age");
    }*/
}
