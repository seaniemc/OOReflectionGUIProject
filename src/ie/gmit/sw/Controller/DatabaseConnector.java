package ie.gmit.sw.Controller;

/**
 * Created by Sean on 09/01/2017.
 *
 */
import ie.gmit.sw.Model.AdjacencyList;
import ie.gmit.sw.Model.Measurement;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

 public class DatabaseConnector
{
    private ObjectContainer db;

    public void openDB()
    {

        db = Db4oEmbedded.openFile("db");

    }

    public ObjectSet<Measurement> retrieveAll()
    {

        // Store db data in Measurement
        ObjectSet<Measurement> measureRecord = db.query(Measurement.class);
        //ObjectSet<AdjacencyList> adList = db.query(AdjacencyList.class);

        return measureRecord;

    }//end method

    /*public ObjectSet <AdjacencyList> retrieveAll(){

    }*/

}// end class
