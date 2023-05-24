import java.util.ArrayList;

/**
 * This class is a "child" class to Airplane. In this class there are methods
 * that are specific to the Piper Cub which help the user to understand more
 * about the details regarding a Piper Cub.
 * 
 * @author Patience Chowning
 *
 */
public class PiperCub extends Airplane {

    // *************************INSTANCE VARIABLES***************************

    /**
     * This is the integer value of the average speed of the Piper Cub. This
     * number should be 65 knots which is equivalent to ~75mph. *This is not to
     * be confused with the variable airSpeed which indicates the current speed
     * of the plane.
     */
    protected int averageSpeed;

    /**
     * This is an integer value of the number of seats in the Piper Cub. This
     * number should be 2.
     */
    protected int numSeat;

    /**
     * This is the average fuel range for a Piper Cub. This value is 460 miles
     * on a full tank.
     */
    protected int fuelRange;

    // -_-_-_-_-_-_-_-_-_-_-_-_-_-CONSTRUCTORS_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

    /**
     * This will create a PiperCub object using inheritance from the Airplane
     * class and will add the constant variables: averageSpeed, numSeat, and
     * fuelRange.
     * 
     * @param type the type of the plane.
     * @param airSpeed the integer value of the indicated airspeed. 
     * @param distance the double value of the indicated distance.
     * @param avaerageSpeed the integer value of the average speed.
     * @param numSeat the integer value of the number of seats. 
     * @param fuelRange the integer value of the fuel range.
     * 
     */
    public PiperCub(String type, int airSpeed, double distance,
            int averageSpeed, int numSeat, int fuelRange) {
        super(type, airSpeed, distance);
        this.averageSpeed = 75;
        this.numSeat = 2;
        this.fuelRange = 460;
    }

    /**
     * This will return a copy of the PiperCub object which will help to
     * implement the clone() method later on.
     * 
     * @param another PiperCub object that is created from all instance
     *                variables from the Airplane class and PiperCub class.
     */
    public PiperCub(PiperCub another) {
        this(another.type, another.airSpeed, another.distance,
                another.averageSpeed, another.numSeat, another.fuelRange);
    }

    // ----------------------------GETTER METHODS----------------------------

    /**
     * This will return the average speed of the Piper Cub.
     * 
     * @return averageSpeed an integer value of the average speed of the Piper
     *         Cub.
     */
    public int getAverageSpeed() {
        return this.averageSpeed;
    }

    /**
     * This will return the number of seats in the Piper Cub.
     * 
     * @return numSeat an integer value of the number of seats in the Piper Cub.
     */
    public int getNumSeat() {
        return this.numSeat;
    }

    /**
     * This will return the fuel range for the Piper Cub.
     * 
     * @return fuelRange an integer value of the maximum amount of fuel a Piper
     *         Cub can hold.
     */
    public int getFuelRange() {
        return this.fuelRange;
    }

    // ***************************OTHER METHODS*****************************

    /**
     * This method will calculate the fuel reserve left after a PiperCub flies a
     * certain distance by subtracting fuelRange from the indicated distance.
     * 
     * @return fuelReserve a double value of the leftover fuel.
     */
    public double calcFuelReserve() {
        return (double) (fuelRange - distance);
    }

    /**
     * This is a method that helps the pilot know that they will need someone to
     * manually "prop" the plane in order to fly.
     * 
     * @return a String value indicating the details of the piper cub.
     */
    public String needProp() {
        return "The Piper Cub needs to be manually propped.";
    }

    /**
     * This will calculate the estimated average TimeEnRoute by 
     * dividing distance by airspeed an integer value for the pilot.
     * 
     * @param planes an ArrayList of Airplane objects.
     * @return an integer value of the estimated TimeEnRoute.
     */
    public int calcAverageTimeEnRoute(ArrayList<Airplane> planes) {

        for (int i = 0; i < planes.size(); i++) {
            if (planes.get(i).getType().equals("PiperCub ")) {
                break;
            }
        }
        return (int) ((fuelRange / averageSpeed) * 100) / 60;
    }

    /**
     * This will return a string representation of the PiperCub object.
     */
    public String toString() {
        return (String.format(
                "\nAirplane type: %s\n"
                        + "Indicated Air Speed (mph): %d\n"
                        + "Distance to Travel: %.2f\n"
                        + "Average Airspeed for a Piper Cub (mph): %d\n"
                        + "Number of Seats: %d\n"
                        + "Fuel Range (miles): %d\n",
                type, airSpeed, distance, 75, 2, 460));
    }

    /**
     * This will clone the PiperCub object.
     */
    @Override
    public PiperCub clone() {
        return new PiperCub(this);
    }

}
