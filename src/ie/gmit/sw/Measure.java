package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sean on 05/01/2017.
 */
public class Measure {

    private int efferentCoupling;
    private int afferentCoupling;
    private String className;


    public int getEfferentCoupling() {
        return efferentCoupling;
    }

    public void setEfferentCoupling(int efferentCoupling) {
        this.efferentCoupling = efferentCoupling;
    }

    public int getAfferentCoupling() {
        return afferentCoupling;
    }

    public void setAfferentCoupling(int afferentCoupling) {
        this.afferentCoupling = afferentCoupling;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getStability(){

        double stabilityMetric = 0.0;

        if(getEfferentCoupling() > 0){

            stabilityMetric  = ((double) getEfferentCoupling() / ((double)getAfferentCoupling()
                    + (double)getEfferentCoupling()));
        }

        return stabilityMetric;
    }
}
