package company;

import java.util.Comparator;

/**
 * Created by hERO on 6/3/16.
 */
public class myCompService implements Comparator<basicService> {

    public myCompService(){

    }
    @Override
    public int compare(basicService e1, basicService e2){
        return e1.getProviderName().compareTo(e2.getProviderName());
    }
}
