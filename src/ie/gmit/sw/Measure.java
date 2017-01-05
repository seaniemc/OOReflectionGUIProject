package ie.gmit.sw;

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
}
