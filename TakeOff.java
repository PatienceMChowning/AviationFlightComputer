/**
 * This is a simple interface that is implemented by the Airplane class.
 * Airplane objects essentially can be verified for take-off through the methods
 * listed in this class.
 * 
 * @author Patience Chowning
 *
 */
public interface TakeOff {

    /**
     * This method will tell the pilot whether they have sufficient fuel in the
     * airplane by returning a boolean value of true or false, this must be true
     * before flying.
     */
    public boolean fuel();

    /**
     * This will check whether the pilot has their head-set connected, this must
     * be true before flying.
     */
    public boolean headset();

    /**
     * This will indicate whether the plane is flying. In order to be flying,
     * both head-set and fuel need to be true.
     * 
     * @param obj the object to be used for this method. 
     */
    public String flying(Object obj);

}
