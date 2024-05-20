package latihan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionList {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();

        // menambah data collection
        names.add("Ciello");
        names.add("Belleza");
        names.addAll(Arrays.asList("Zukhrufi", "Susilantoro"));
        
        // menghapus data collection
        names.remove("Susilantoro");

        //mengecek data collection
        System.out.println(names.contains("Ciello"));
        
        for(var name: names) {
            System.out.println(name);
        }
    }
}
