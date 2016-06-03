package company;

import java.util.Comparator;

/**
 * Created by eynis on 6/3/16.
 */
public class myCompProvider implements Comparator<Provider>{
    public int compare(Provider e1, Provider e2){
        return e1.getName().compareTo(e2.getName());
    }
}
