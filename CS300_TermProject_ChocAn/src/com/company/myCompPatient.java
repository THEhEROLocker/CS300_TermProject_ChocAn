package company;

import java.util.Comparator;

/**
 * Created by hERO on 6/2/16.
 */
public class myCompPatient implements Comparator<basicPatient> {
    @Override
    public int compare(basicPatient e1, basicPatient e2){
        return e1.getName().compareTo(e2.getName());
    }
}
