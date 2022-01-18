import java.time.LocalTime;
import java.util.Objects;

/**
 * The type Long jump result.
 * @Author 10071
 */
public class LongJumpResult {
    //How I understand the task, you could either choose a start number with a name, String. Or you could choose a start number with a number, int.
    //Therefore, why I chose the latter.
    private final int startNumber;
    private final String jumperName;
    private final float result;
    private final boolean legalJump;
    private final LocalTime timeOfJump;

    /**
     * Instantiates a new Long jump result.
     *
     * @param startNumber the start number of the jumper
     * @param jumperName  the name of the jumper
     * @param result      the result of this jump in meters
     * @param legalJump   boolean that defines if jump was legal
     * @param timeOfJump  the time of the jump
     * @throws IllegalArgumentException if the start number is defined as less than 0
     * @throws IllegalArgumentException if the jumper name is empty
     * @throws IllegalArgumentException if the start number is defined as less than 0
     * @throws IllegalArgumentException if the start number is defined as less than 0
     */
    public LongJumpResult(int startNumber, String jumperName, float result, boolean legalJump, LocalTime timeOfJump) throws IllegalArgumentException {
        if (startNumber < 0) throw new IllegalArgumentException("The start number cannot be lower than 0.");
        //Here I use isBlank() and not isEmpty() because isBlank() also sees if there is only whitespace. I could have used .trim() on the input, but that works badly in this case.
        if (jumperName.isBlank()) throw new IllegalArgumentException("You have not specified a name.");
        if (result < 0) throw new IllegalArgumentException("A jumper cannot jump less than 0 meters.");
        if (timeOfJump == null) throw new IllegalArgumentException("You have not specified when the jump occurred");
        this.startNumber = startNumber;
        this.jumperName = jumperName;
        this.result = result;
        this.legalJump = legalJump;
        this.timeOfJump = timeOfJump;
    }

    //As I use composition I have a second constructor for constructing deep copies. This also gives me looser coupling.
    public LongJumpResult(LongJumpResult longJumpResult) {
        this(longJumpResult.getStartNumber(), longJumpResult.getJumperName(), longJumpResult.getResult(), longJumpResult.isLegalJump(), longJumpResult.getTimeOfJump());
    }

    /**
     * Gets the start number.
     *
     * @return the start number
     */
    public int getStartNumber() {
        return startNumber;
    }

    /**
     * Gets the jumpers name.
     *
     * @return the jumpers name
     */
    public String getJumperName() {
        return jumperName;
    }

    /**
     * Gets the result.
     *
     * @return the result
     */
    public float getResult() {
        return result;
    }

    /**
     * Gets boolean of whether jump is legal or not.
     *
     * @return the boolean
     */
    public boolean isLegalJump() {
        return legalJump;
    }

    /**
     * Gets the time of jump.
     *
     * @return the time of jump
     */
    public LocalTime getTimeOfJump() {
        return timeOfJump;
    }

    /**
     * Override to string method to print object neatly.
     * @return object as string.
     */
    @Override
    public String toString() {
        return "Start number: " + getStartNumber() + '\n' +
                "Name: " + getJumperName() + '\n' +
                "Result: " + getResult() + '\n' +
                "Legal jump: " + isLegalJump() + '\n' +
                "Time of jump: " + getTimeOfJump() + '\n';
    }

    /**
     * Override equals method to check if the start number, the name of the jumper and time of the jump are equal in two objects.
     * @param o a new instance of LongJumpResult
     * @return true or false based on if this result of a long jump already exist for the specified jumper, their start number and this date.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LongJumpResult)) return false;
        LongJumpResult that = (LongJumpResult) o;
        return getStartNumber() == that.getStartNumber() && Objects.equals(getJumperName(), that.getJumperName()) && Objects.equals(getTimeOfJump(), that.getTimeOfJump());
    }
}
