import java.util.Objects;

/**
 * The type Mushroom species.
 */
public class MushroomSpecies {
    private final String name;
    private final String desc;
    private final boolean poisonous;


    /**
     * Instantiates a new Mushroom species.
     *
     * @param name      the name
     * @param desc      the desc
     * @param poisonous the poisonous
     * @throws IllegalArgumentException the illegal argument exception
     */
    public MushroomSpecies(String name, String desc, boolean poisonous) throws IllegalArgumentException {
        if(equals(name)) {
            throw new IllegalArgumentException("This mushroom has already been registered");
        }
        this.name = name;
        this.desc = desc;
        this.poisonous = poisonous;
    }

    /**
     * Instantiates a new Mushroom species.
     *
     * @param name      the name
     * @param poisonous the poisonous
     * @throws IllegalArgumentException the illegal argument exception
     */
    public MushroomSpecies (String name, boolean poisonous)
            throws IllegalArgumentException{
        this(name, "This mushroom has no description", poisonous);
    }

    /**
     * Instantiates a new Mushroom species.
     *
     * @param mushroomSpecies the mushroom species
     * @throws IllegalArgumentException the illegal argument exception
     */
    public MushroomSpecies(MushroomSpecies mushroomSpecies)
            throws IllegalArgumentException{
        this(mushroomSpecies.getName(), mushroomSpecies.getDesc(),
                mushroomSpecies.isPoisonous());
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets desc.
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Is poisonous boolean.
     *
     * @return the boolean
     */
    public boolean isPoisonous() {
        return poisonous;
    }

    /**
     * Contains string boolean.
     *
     * @param search the search
     * @return the boolean
     * @throws IllegalArgumentException the illegal argument exception
     */
    public boolean containsString(String search) throws IllegalArgumentException{
        if (search.equals("")) throw new IllegalArgumentException("The string you entered was empty");
        if (this.getDesc().contains(search)) {
            return true;
        }
        return false;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return this.getName() + ". " + this.getDesc() + " Poisonous: " + this.isPoisonous() + '\n';
    }

    /**
     * Equals boolean.
     *
     * @param o the o
     * @return the boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MushroomSpecies that = (MushroomSpecies) o;
        return poisonous == that.poisonous && Objects.equals(name, that.name) && Objects.equals(desc, that.desc);
    }

    /**
     * Hash code int.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, desc, poisonous);
    }
}
