package ie.gmit.sw;

/**
 * Created by Sean on 05/01/2017.
 */
public class StablityMetric {

    private ClassList list;
    private MeasureList mList;

    private double stabilityMetric = 0;

    public StablityMetric(ClassList list, MeasureList mList){
        calculateMetric(list, mList);
    }

    public double getStabilityMetric() {
        return stabilityMetric;
    }
    public void setStabilityMetric(double stabilityMetric) {
        this.stabilityMetric = stabilityMetric;
    }

    public void calculateMetric(ClassList list, MeasureList degres){

        MeasureList mList = new MeasureList();

        for(int i = 0; i < list.size(); i++){

            Class cla = list.getMyClass(i);

            mList.get(i).getClassName();

            if(cla.getName() == mList.get(i).getClassName()){

                if(mList.get(i).getEfferentCoupling() > 0){

                    stabilityMetric  = ((double) mList.get(i).getEfferentCoupling() / ((double)mList.get(i).getAfferentCoupling()
                            + (double)mList.get(i).getEfferentCoupling()));
                    setStabilityMetric(stabilityMetric);
                }else {
                    stabilityMetric = 0;
                    setStabilityMetric(stabilityMetric);
                }

            }
            System.out.println("StablityMetric.calculateMetric for Class" + cla.getName()+"Stability" + getStabilityMetric() );
        }

    }
}
