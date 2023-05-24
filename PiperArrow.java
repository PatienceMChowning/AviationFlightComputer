import java.util.ArrayList;

/**
 * This class is a "child" class to Airplane. In this class there are methods
 * that are specific to the Piper Arrow which help the user to understand more
 * about the details regarding a Piper Arrow.
 * 
 * @author Patience Chowning
 *
 */
public class PiperArrow extends Airplane {

    // *************************INSTANCE VARIABLES***************************

    /**
     * This is the integer value of the average speed of the Piper Arrow. This
     * number should be 131 knots which is equivalent to 151mph.
     */
    protected int averageSpeed;

    /**
     * This is an integer value of the number of seats in the Piper Arrow. This
     * number should be 4.
     */
    protected int numSeat;

    /**
     * This is the average fuel range for a Piper Arrow. This value is 900 miles
     * on a full tank.
     */
    protected int fuelRange;

    // -_-_-_-_-_-_-_-_-_-_-_-_-_-CONSTRUCTORS_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

    /**
     * This will create a PiperArrow object using inheritance from the Airplane
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
    public PiperArrow(String type, int airSpeed, double distance,
            int averageSpeed, int numSeat, int fuelRange) {
        super(type, airSpeed, distance);
        this.averageSpeed = 151;
        this.numSeat = 4;
        this.fuelRange = 900;
    }

    /**
     * This will return a copy of the PiperArrow object which will help to
     * implement the clone() method later on.
     * 
     * @param another PiperArrow object that is created from all instance
     *                variables from the Airplane class and PiperArrow class.
     */
    public PiperArrow(PiperArrow another) {
        this(another.type, another.airSpeed, another.distance,
                another.averageSpeed, another.numSeat, another.fuelRange);
    }

    // ----------------------------GETTER METHODS----------------------------

    /**
     * This will return the average speed of the Piper Arrow.
     * 
     * @return averageSpeed an integer value of the average speed of the Piper
     *         Arrow.
     *         
     */
    public int getAverageSpeed() {
        return this.averageSpeed;
    }

    /**
     * This will return the number of seats in the Piper Arrow.
     * 
     * @return numSeat an integer value of the number of seats in the Piper
     *         Arrow.
     *         
     */
    public int getNumSeat() {
        return this.numSeat;
    }

    /**
     * This will return the fuel range for the Piper Arrow.
     * 
     * @return fuelRange an integer value of the maximum amount of fuel a Piper
     *         Arrow can hold.
     *         
     */
    public int getFuelRange() {
        return this.fuelRange;
    }

    // ***************************OTHER METHODS*****************************

    /**
     * This method will calculate the fuel reserve left after a PiperArrow flies
     * a certain distance by subtracting fuelRange from the indicated distance.
     * 
     * @return fuelReserve a double value of the leftover fuel.
     * 
     */
    public double calcFuelReserve() {
        return (double) (fuelRange - distance);
    }

    /**
     * This is a method that helps the pilot know that the Piper Arrow is a long
     * wing airplane.
     * 
     * @return a String value indicated details of the piper arrow.
     * 
     */
    public String lowWing() {
        return "The Piper Arrow is a low-Winged plane.";
    }

    /**
     * This will calculate the estimated TimeEnRoute by dividing
     * distance by airspeed and return a double value for the pilot.
     * 
     * @param planes an ArrayList of Airplane objects.
     * @return an integer value of the estimated TimeEnRoute.
     * 
     */
    public int calcAverageTimeEnRoute(ArrayList<Airplane> planes) {

        for (int i = 0; i < planes.size(); i++) {
            if (planes.get(i).getType().equals("PiperArrow ")) {
                break;
            }
        }
        return (int) ((fuelRange / averageSpeed) * 100) / 60;
    }

    /**
     * This will return a string representation of the PiperArrow object.
     */
    public String toString() {
        return (String.format(
                "\nAirplane type: %s\n"
                        + "Indicated Air Speed (mph): %d\n"
                        + "Distance to Travel: %.2f\n"
                        + "Average Airspeed for a Piper Arrow (mph): %d\n"
                        + "Number of Seats: %d\n"
                        + "Fuel Range (miles): %d\n",
                type, airSpeed, distance, 151, 4, 900));
    }

    /**
     * This will clone the PiperArrow object.
     */
    @Override
    public PiperArrow clone() {
        return new PiperArrow(this);
    }
}
