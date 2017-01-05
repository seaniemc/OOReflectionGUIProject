package ie.gmit.sw;

/**
 * Created by Sean on 05/01/2017.
 */
public class StablityMetric {

    public double getStabilityMetric() {
        return stabilityMetric;
    }

    private double stabilityMetric = 0;

    public void calculateMetric(ClassList list, Measure degres){

        Measure measure = new Measure();

        if(measure.getEfferentCoupling() > 0){

            stabilityMetric = ((double) measure.getEfferentCoupling() / ((double)measure.getAfferentCoupling() + (double)measure.getEfferentCoupling()));
        }else {
            stabilityMetric = 0;
        }


    }
}
