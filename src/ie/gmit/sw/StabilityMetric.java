package ie.gmit.sw;

/**
 * Created by Sean on 05/01/2017.
 */
public class StabilityMetric {

    private StabilityList sList = new StabilityList();

    private double stabilityMetric = 0;
    private String className;

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }


    public StabilityMetric(){
        super();

    }

    public StabilityMetric(ClassList list, MeasureList mList){
        calculateMetric(list, mList);
    }

    public double getStabilityMetric() {
        return stabilityMetric;
    }

    public void setStabilityMetric(double stabilityMetric) {
        this.stabilityMetric = stabilityMetric;
    }

    public StabilityList calculateMetric(ClassList list, MeasureList mList){

        StabilityMetric stab = new StabilityMetric();

        for(int i = 0; i < list.size(); i++){

            Class cla = list.getMyClass(i);

            mList.get(i).getClassName();

            if(cla.getName() == mList.get(i).getClassName()){

                if(mList.get(i).getEfferentCoupling() > 0){

                    stabilityMetric  = ((double) mList.get(i).getEfferentCoupling() / ((double)mList.get(i).getAfferentCoupling()
                            + (double)mList.get(i).getEfferentCoupling()));
                    stab.setStabilityMetric(stabilityMetric);
                    stab.setClassName(cla.getName());
                    sList.add(stab);
                }else {
                    stabilityMetric = 0;

                    stab.setStabilityMetric(stabilityMetric);
                    stab.setClassName(cla.getName());

                    sList.add(stab);
                }

            }
            System.out.println("StabilityMetric.calculateMetric Stability for" + getStabilityMetric() );
            System.out.println("Stability list" + sList.size());

        }
        return sList;
    }
}
