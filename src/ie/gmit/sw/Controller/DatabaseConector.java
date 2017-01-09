package ie.gmit.sw.Controller;

/**
 * Created by Sean on 09/01/2017.
 *
 */
import ie.gmit.sw.Model.Measurement;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

 public class DatabaseConector
{
    private ObjectContainer db;

    public void openDB()
    {

        db = Db4oEmbedded.openFile("db");

    }

    public ObjectSet<Measurement> retrieveAll()
    {

        // Get data from database and store in record
        ObjectSet<Measurement> measureRecord = db.query(Measurement.class);

        return measureRecord;

    }// End method retrieveAll

}// End class DatabaseOperations
/* {


}*/
