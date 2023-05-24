import java.util.ArrayList;

/**
 * The Airplane class holds basic instance variables and methods that can be
 * implemented in both the classes: PiperCub and PiperArrow. It aids in the
 * creation of an airplane object and helps to create better functionality and
 * reusability of the code. This class implements the interface TakeOff as well.
 * 
 * @author Patience Chowning
 *
 */
public class Airplane implements TakeOff {

    // *************************INSTANCE VARIABLES***************************

    /**
     * This is a string value of the type of airplane.
     */
    protected String type;

    /**
     * This is an integer value of the indicated or “real time” airspeed of the
     * airplane.
     */
    protected int airSpeed;

    /**
     * This is a double value of the total distance in which the plane will be
     * traveling.
     */
    protected double distance;

    /**
     * This is an array list of String values regarding details of the airplane.
     * This includes the type of the airplane (i.e., plane/helicopter/commuter),
     * the make of the plane (i.e, Cub, Arrow, Fighter), the airspeed, and the
     * distance in which it will travel.
     */
    protected ArrayList<Airplane> planes;

    // -_-_-_-_-_-_-_-_-_-_-_-_-_-CONSTRUCTORS_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

    /**
     * This is the default constructor for an Airplane object. It should
     * initialize the object with the type, airspeed, and distance in which it
     * desires to fly.
     */
    public Airplane() {
        System.out.println("Creating an airplane object: ");
    }

    /**
     * This constructor creates an airplane object with the given variables:
     * type, airspeed, and distance.
     * 
     * @param type     a String value holding the type of the given airplane.
     * @param airSpeed an integer value holding the indicated airspeed of the
     *                 plane.
     * @param distance a double value holding the distance the plane will fly.
     */
    public Airplane(String type, int airSpeed, double distance) {
        this.type = type;
        this.airSpeed = airSpeed;
        this.distance = distance;
    }

    /**
     * This will return a copy of the Airplane object which will help to
     * implement the clone() method later on.
     * 
     * @param another Airplane object that is created from all instance
     *                variables from the Airplane class.
     */
    public Airplane(Airplane another) {
        this(another.type, another.airSpeed, another.distance);
    }

    // ----------------------------GETTER METHODS----------------------------

    /**
     * This will return the type of the airplane as a string value.
     * 
     * @return type the String value of the type of airplane.
     */
    public String getType() {
        return this.type;
    }

    /**
     * This will return the airspeed of the plane as an integer value.
     * 
     * @return airspeed an integer value of the indicated speed of the plane.
     */
    public int getSpeed() {
        return this.airSpeed;
    }

    /**
     * This will return the total distance that the plane plans to fly as a
     * double value.
     * 
     * @return distance a double value indicating the desired distance the plane
     *         will fly.
     */
    public double getDistance() {
        return this.distance;
    }

    /**
     * This will return an array list of details.
     * 
     * @return details an ArrayList of String values.
     */
    public ArrayList<Airplane> getDetails() {
        return this.planes;
    }

    // ********************************EQUALS********************************
    /**
     * This method will demonstrate whether the TimeEnRoute (distance and
     * airspeed) is the same for two objects.
     * 
     * @param obj an object that is used for the comparison.
     * @return boolean value of true or false indicating whether two objects are
     *         equal in distance and airspeed.
     */
    public boolean equals(Object obj) {
        // Check to see if the airplane object is valid.
        if (obj == null) {
            return false; // This is not a valid object.
        }
        // Check whether the object is an instanceof the Airplane class.
        if (obj instanceof Airplane) {
            // Downcast from parent to child.
            final Airplane other = (Airplane) obj;
            // Return true if the distance and airSpeed of the object is the
            // same.
            return (distance == (other.distance)
                    && airSpeed == (other.airSpeed));
        }
        return false; // This is not an Airplane object
    }

    // ***************************INTERFACE METHODS*****************************

    /**
     * This method checks whether the pilot has checked the fuel gauge. If
     * applied to an Airplane object it will return true after prompting the
     * pilot to check the gauge.
     * 
     * @return a boolean value of true.
     */
    public boolean fuel() {
        // Ask the pilot to check the fuel gauge.
        System.out.println(
                "Please check fuel gauge. Fuel gauge should read \"full\".");
        // Once pilot has checked fuel gauge.
        return true;
    }

    /**
     * This method checks whether the pilot and passengers have their head-set
     * connected. If applied to an Airplane object it will return true after
     * prompting the pilot to connect their head-set(s).
     * 
     * @return a boolean value of true.
     */
    public boolean headset() {
        // Ask the pilot to check head-set connection.
        System.out.println("Please connect head-set before flight.");
        // Once pilot has checked head-set connection.
        return true;
    }

    /**
     * This method checks whether the pilot has ensured their head-set is
     * connected and the fuel is full. Once both of these are true the pilot can
     * take-off.
     * 
     * @param obj an object that when casted to the Airplane class will help to
     *            test whether the head-set and fuel values are true.
     * @return a boolean value of true or false.
     */
    public String flying(Object obj) {
        // Check whether head-set and fuel were checked. They must be true in
        // order to fly.
        if (((Airplane) obj).fuel() == true
                && ((Airplane) obj).headset() == true) {
            // Airplane is ready to fly.
            // Once pilot has checked head-set connection and fuel.
            return "Safe flying!";
        }
        // Return false if either head-set or fuel was not true.
        return "Please re-check gauges.";
    }

    /**
     * To string method to print all airplane objects from list of planes.
     */
    public String toString() {
        return (String.format(
                "Airplane type: %s\n"
                        + "Indicated Air Speed (mph): %d\n"
                        + "Distance to Travel: %.2f",
                type, airSpeed, distance));
    }

    /**
     * This method calculates the time en route specific to each plane.
     * 
     * @param planes   an ArrayList of Airplane objects.
     * @param iterator the index in the array to be accessed.
     * @return
     */
    public double calcTimeEnRoute(ArrayList<Airplane> planes, int iterator) {
        return (((planes.get(iterator).getDistance()
                / planes.get(iterator).getSpeed()) * 100));
    }

    /**
     * This will clone the Airplane object.
     */
    @Override
    public Airplane clone() {
        return new Airplane(this);
    }

} // End of class Airplane
