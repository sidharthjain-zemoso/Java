package lambdas_and_streams.lambdas;

public class ArrayReferences {
    interface StringArray{
        String[] create(int size);
    }

    private void testArrayConstructorRefs(){
        StringArray stringArray = size -> new String[size];
        StringArray stringArray1 = String[]::new;
    }
}
