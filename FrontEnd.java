import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is responsible for running the Flight Computer. It implements all
 * of the classes in order to create a user friendly outcome.
 * 
 * @author Patience Chowning
 *
 */
public class FrontEnd {

    /**
     * A simple string that contains the prompt for the menu used in this
     * program.
     */
    private static final String Menu = "What would you like to do:\n"
            + "1. Display details of all planes in the file.\n"
            + "2. Get fuel reserve and average time it takes\n   "
            + "for your Piper Cub "
            + "and Piper Arrow to run out of fuel.\n"
            + "3. Check to see if the pilot is ready to fly.\n"
            + "4. Get important information "
            + "regarding the Piper Cub and Piper Arrow.\n"
            + "5. Exit Flight Computer and export data to file.\n"
            + "Enter choice: ";

    /**
     * This method reads the objects from the given file and creates plane
     * objects to store into the ArrayList planes.
     * 
     * @param fileName a string value of the file entered by the user.
     * @param planes   an ArrayList of Airplane objects.
     * @return planes (the updated version of the ArrayList).
     * @throws FileNotFoundException if the file could not be found.
     */
    private static ArrayList<Airplane> readPlanes(final String fileName,
            ArrayList<Airplane> planes) throws FileNotFoundException {
        // Creating a scanner to read data from the file.
        Scanner fileReader = new Scanner(new File(fileName));
        // Need to read from plane_info.txt file and convert to plane objects
        // to new list.
        // ArrayList<Airplane> planes = new ArrayList<>();
        // Loop to read each thing in the file
        while (fileReader.hasNext()) {
            String type = fileReader.next();
            int airSpeed = fileReader.nextInt();
            double distance = fileReader.nextDouble();
            // Now create the airplane object to add to the details.
            Airplane plane = new Airplane(type, airSpeed, distance);
            // Now add to the list of details.
            planes.add(plane);
        }
        fileReader.close(); // Closing scanner object.
        return planes;
    }

    /**
     * This method finds the specific objects in the array. By doing this it
     * helps to iterate through the array, and shorten other methods. It will
     * then calculate the estimated TimeEnRoute for each Airplane object.
     * 
     * @param planes   an ArrayList of Airplane objects.
     * @param fileName a string value of the file entered by the user.
     * @param iterator the index in the array to be accessed.
     * @throws FileNotFoundException if the file could not be found.
     */
    private static void findObjects(ArrayList<Airplane> planes,
            final String fileName, int iterator)
            throws FileNotFoundException {
        readPlanes(fileName, planes);
        // planes.get(iterator);
        System.out.print(planes.get(iterator).toString());
        System.out.printf("\n%s%.2f%s", "Time En Route: ",
                planes.get(iterator).calcTimeEnRoute(planes, iterator),
                " minutes.\n\n");
    }

    /**
     * This method is for if the user picks choice number one. It loops through
     * the array of planes and calls on the method findObject() in order to
     * print out the results for the user.
     * 
     * @param planes   an ArrayList of Airplane objects.
     * @param fileName a string value of the file entered by the user.
     * @throws FileNotFoundException if the file could not be found.
     */
    private static void choice1(ArrayList<Airplane> planes,
            final String fileName) throws FileNotFoundException {
        System.out.println(
                "\nDisplaying details for the planes...\n");
        // A for loop to iterate through the list of planes.
        for (int iterator = 0; iterator < 5; iterator++) {
            findObjects(planes, fileName, iterator);
        }
        System.out.println();
    }

    /**
     * This method is for if the user picks choice number two. It will then
     * calculate the fuel reserve and average TimeEnRoute for a PiperCub and
     * PiperArrow object. This method can only be used for PiperCub and
     * PiperArrow objects.
     * 
     * @param planes   an ArrayList of Airplane objects.
     * @param fileName a string value of the file entered by the user.
     * @throws FileNotFoundException if the file could not be found.
     */
    private static void choice2(ArrayList<Airplane> planes,
            final String fileName) throws FileNotFoundException {
        readPlanes(fileName, planes);
        // Calculating fuel reserve and other details for the pipers.
        System.out.printf(
                "\nThe Piper "
                        + "Cub will run out of fuel in: "
                        + "%.2f%s\n",
                piperObject(planes, fileName, 0).calcFuelReserve(), " miles\n");
        System.out.printf("Average time it takes for a Piper Cub "
                + "to run out of fuel on a full tank: "
                + "%d%s\n",
                piperObject(planes, fileName, 0).calcAverageTimeEnRoute(planes),
                " hours\n");
        System.out.printf(
                "\nThe Piper "
                        + "Arrow will run out of fuel in: "
                        + "%.2f%s\n",
                arrowObject(planes, fileName, 0).calcFuelReserve(), " miles\n");
        System.out.printf("Average time it takes for a Piper Arrow "
                + "to run out of fuel on a full tank: "
                + "%d%s\n",
                arrowObject(planes, fileName, 0).calcAverageTimeEnRoute(planes),
                " hours\n");
    }

    /**
     * This method is for if the user picks choice number three. It will then
     * let the user know to check there fuel, head-set, and then indicate that
     * the plane is ready for flight.
     * 
     * @param planes   an ArrayList of Airplane objects.
     * @param fileName a string value of the file entered by the user.
     * @throws FileNotFoundException if the file could not be found.
     */
    private static void choice3(ArrayList<Airplane> planes,
            final String fileName) throws FileNotFoundException {
        readPlanes(fileName, planes);
        System.out.println();
        // Printing the method flying() for a single plane.
        System.out.printf("%s\n", planes.get(0).flying(planes.get(0)));
        System.out.println();
    }

    /**
     * This method is used to take an Airplane object in the array list and
     * effectively create a PiperCub object with it. This method is specific to
     * PiperCub objects.
     * 
     * @param planes   an ArrayList of Airplane objects.
     * @param fileName a string value of the file entered by the user.
     * @param iterator the index in the array to be accessed.
     * @return piper a PiperCub object to be used to calculate extra details.
     * @throws FileNotFoundException if the file could not be found.
     */
    private static PiperCub piperObject(ArrayList<Airplane> planes,
            final String fileName, int iterator) throws FileNotFoundException {
        readPlanes(fileName, planes);
        // Creating the variables to create the piper cub object.
        String type = planes.get(iterator).getType();
        int airSpeed = planes.get(iterator).getSpeed();
        double distance = planes.get(iterator).getDistance();
        PiperCub piper = new PiperCub(type, airSpeed, distance, 0, 0, 0);
        return piper;
    }

    /**
     * This method is used to take an Airplane object in the array 
     * list and effectively create a PiperArrow object with it.
     * This method is specific to PiperArrow objects.
     * 
     * @param planes   an ArrayList of Airplane objects.
     * @param fileName a string value of the file entered by the user.
     * @param iterator the index in the array to be accessed.
     * @return arrow a PiperArrow object to be used to calculate extra details.
     * @throws FileNotFoundException if the file could not be found.
     */
    private static PiperArrow arrowObject(ArrayList<Airplane> planes,
            final String fileName, int iterator) throws FileNotFoundException {
        readPlanes(fileName, planes);
        // Creating the variables to create the piper arrow object.
        String type = planes.get(iterator).getType();
        int airSpeed = planes.get(iterator).getSpeed();
        double distance = planes.get(iterator).getDistance();
        PiperArrow arrow = new PiperArrow(type, airSpeed, distance, 0, 0, 0);
        return arrow;
    }

    /**
     * This method is for if the user picks choice number 4. It will then use
     * the PiperCub and PiperArrow objects to calculate extra details regarding
     * these two airplanes.
     * 
     * @param planes   an ArrayList of Airplane objects.
     * @param fileName a string value of the file entered by the user.
     * @throws FileNotFoundException if the file could not be found.
     */
    private static void choice4(ArrayList<Airplane> planes,
            final String fileName) throws FileNotFoundException {
        // Printing out PiperCub objects by calling piperObject.
        System.out.print(piperObject(planes, fileName, 0).toString());
        System.out.println(piperObject(planes, fileName, 0).needProp());
        System.out.print(arrowObject(planes, fileName, 0).toString());
        System.out.println(arrowObject(planes, fileName, 0).lowWing());
        System.out.println();
    }

    /**
     * This method is responsible for calling on all of the methods listed
     * above.
     * 
     * @throws FileNotFoundException if the file could not be found.
     */
    private static void menu() throws FileNotFoundException {
        // Creating an arrayList of planes to use in the methods.
        ArrayList<Airplane> planes = new ArrayList<>();
        // Creating a scanner object to read the users fileName and choice.
        Scanner keyboard = new Scanner(System.in);
        // Creating a string to hold the filename.
        System.out.print("Please enter file name: ");
        String fileName = keyboard.next();
        // Creating a for loop to act on the choice.
        for (int choice = 1; choice != 5;) {
            System.out.print(Menu);
            choice = keyboard.nextInt();
            if (choice == 1) {
                choice1(planes, fileName);
            } else if (choice == 2) {
                choice2(planes, fileName);
            } else if (choice == 3) {
                choice3(planes, fileName);
            } else if (choice == 4) {
                choice4(planes, fileName);
            } else {
                output(planes, fileName); // Exporting the new data.
            }
        }

    } // End of method menu

    /**
     * This method is used to export the Airplane objects in the array to
     * "plane_details.txt" a new file.
     * 
     * @param planes   an ArrayList of Airplane objects.
     * @param fileName a string value of the file entered by the user.
     * @throws FileNotFoundException if the file could not be found.
     */
    private static void output(ArrayList<Airplane> planes,
            final String fileName) throws FileNotFoundException {
        PrintWriter output = null; // Creating printWriter to increase scope.
        String file = "plane_details.txt"; // The new file to be created.
        try {
            output = new PrintWriter(file); // Giving the writer the file.
            // Calling this method to ensure the ArrayList planes is not empty.
            readPlanes(fileName, planes);
            // Cloning the objects to ensure they aren't effected in the
            // original.
            planes.clone();
            // For loop to iterate through the list and display the objects.
            for (int iterator = 0; iterator < 5; iterator++) {
                output.println(planes.get(iterator).toString());
                output.printf("%s%.2f%s", "Time En Route: ",
                        planes.get(iterator).calcTimeEnRoute(planes, iterator),
                        " minutes.\n\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        output.close(); // Closing the writer.
    } // End of method output

    // Main method
    public static void main(String[] args) throws Exception {
        menu();
    }
} // End of class FrontEnd
