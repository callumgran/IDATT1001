import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

/**
 * The type Long jump result register.
 * @Author 10071
 */
public class LongJumpResultRegister implements Iterable<LongJumpResult> {
    //I use ArrayList with an equals method here as I feel that is what suits the task best.
    //I could have used a hashmap with the start number as an ID, but as a jumper has multiple jumps
    //this would make using a hashmap not optimal as it would simply override the start number for each entry.
    private ArrayList<LongJumpResult> jumpRegister;

    /**
     * Instantiates a new Long jump result register.
     */
    public LongJumpResultRegister() {
        jumpRegister = new ArrayList<>();
    }

    /**
     * Adds a new long jump result to the register as a boolean for the user to know if it was accepted or not.
     *
     * @param startNumber the start number
     * @param jumperName  the athletes name
     * @param result      how long the jump was
     * @param legalJump   if the jump was legal or not
     * @param timeOfJump  the time of when the result was measured
     * @return boolean true if successful, false if unsuccessful
     */
    public boolean addNewLongJump(int startNumber, String jumperName, float result, boolean legalJump, LocalTime timeOfJump) {
        LongJumpResult newJump = new LongJumpResult(startNumber, jumperName, result, legalJump, timeOfJump);
        if(jumpRegister.contains(newJump)) return false;
        return jumpRegister.add(newJump);
    }

    /**
     * Method that sorts arraylists for easier viewing.
     *
     * @param jumps the ArrayList of results that shall be sorted
     * @return the ArrayList sorted by result
     */
    private ArrayList<LongJumpResult> sortByLongestJump(ArrayList<LongJumpResult> jumps) {
        //Here I just use collections and comparator to sort the results by the result as it makes more sense.
        //I'd also like to note that I use getResult so that it doesn't directly get the start number variable for looser coupling.
        //I have this as its own method as it will give me better cohesion.
        Collections.sort(jumps, Comparator.comparing(LongJumpResult::getResult));
        return jumps;
    }

    @Override
    //Here I use iterator() and implements iterable to have the ability to iterate through the classes iterator in the main file
    //no matter what the "jumpRegister" is. Although this is outside what we are supposed to know, this is in fact something
    //I have used on multiple occasions previously as it gives looser coupling. This is because the main file will not need to change if I
    //were to for example change from ArrayList to Hashmap as it would still receive an iterator. I have also written in the main file why I use Iterable.
    /**
     * Gets all results as an iterator.
     *
     * @return an iterator with a sorted deepcopy of the Arraylist jumpRegister.
     */
    public Iterator<LongJumpResult> iterator() {
        ArrayList<LongJumpResult> jumpRegisterCopy = new ArrayList<>();
        for (LongJumpResult jump: jumpRegister) {
            jumpRegisterCopy.add(new LongJumpResult(jump));
        }
        jumpRegisterCopy = sortByLongestJump(jumpRegisterCopy);
        return jumpRegisterCopy.iterator();
    }

    /**
     * Find all the results of the athlete that has been inputted.
     *
     * @param startNumber the start number of the athlete to search.
     * @return the sorted ArrayList containing all the results of the athlete.
     * @throws IllegalArgumentException if the start number is a negative integer, it throws an exception.
     */
    public ArrayList<LongJumpResult> findAllUserResults(int startNumber) throws IllegalArgumentException {
        if(startNumber < 0) throw new IllegalArgumentException("You have entered a negative number");
        ArrayList<LongJumpResult> jumpRegisterForJumper = new ArrayList<>();
        for (LongJumpResult jump: jumpRegister) {
            if(jump.getStartNumber() == startNumber) jumpRegisterForJumper.add(jump);
        }
        jumpRegisterForJumper = sortByLongestJump(jumpRegisterForJumper);
        return jumpRegisterForJumper;
    }

    /**
     * Finds the longest jump of all results as a copy of the object.
     *
     * @return a copy of the longest jump results.
     */
    public LongJumpResult longestJump() {
        float max = 0;
        LongJumpResult longestJump = null;
        for(LongJumpResult jump: jumpRegister) {
            if(jump.getResult() > max) {
                max = jump.getResult();
                longestJump = new LongJumpResult(jump);
            }
        }
        return longestJump;
    }

    /**
     * Finds the average jump length as a double.
     *
     * @return the average jump length
     */
    public double findAverageJumpLength() {
        double total = 0;
        for (LongJumpResult jump: jumpRegister) total += jump.getResult();
        double average = total/jumpRegister.size();
        return average;
    }
}
