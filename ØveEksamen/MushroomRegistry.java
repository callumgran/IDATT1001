import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Pattern;

/**
 * The type Mushroom registry.
 */
public class MushroomRegistry {
    private ArrayList<MushroomSpecies> speciesRegistry;

    /**
     * Instantiates a new Mushroom registry.
     */
    public MushroomRegistry() {
        speciesRegistry = new ArrayList<MushroomSpecies>();
    }

    /**
     * Gets species.
     *
     * @return the species
     */
    public ArrayList<MushroomSpecies> getSpecies() {
        ArrayList<MushroomSpecies> speciesCopy = new ArrayList<>();
        for (MushroomSpecies mushroomSpecies: speciesRegistry) {
            speciesCopy.add(new MushroomSpecies(mushroomSpecies));
        }
        Collections.sort(speciesCopy, Comparator.comparing(MushroomSpecies::getName));
        return speciesCopy;
    }

    /**
     * Add species boolean.
     *
     * @param name      the name
     * @param desc      the desc
     * @param poisonous the poisonous
     * @return the boolean
     */
    public boolean addSpecies(String name, String desc, boolean poisonous) {
        MushroomSpecies species;
        if (desc.isEmpty()) {
            species = new MushroomSpecies(name, poisonous);
        } else {
            species = new MushroomSpecies(name, desc, poisonous);
        }
        if (!speciesRegistry.toString().contains(species.getName())) {
            speciesRegistry.add(species);
            return true;
        }
        return false;
    }

    /**
     * Edible mushrooms array list.
     *
     * @return the array list
     */
    public ArrayList<MushroomSpecies> edibleMushrooms() {
        ArrayList<MushroomSpecies> edibleMushrooms = new ArrayList<MushroomSpecies>();
        for (MushroomSpecies mushroomSpecies: speciesRegistry) {
            if (mushroomSpecies.isPoisonous() == false) edibleMushrooms.add(new MushroomSpecies(mushroomSpecies));
        }
        return edibleMushrooms;
    }

    /**
     * Searched shroom array list.
     *
     * @param search the search
     * @return the array list
     */
    public ArrayList<MushroomSpecies> searchedShroom(String search) {
        ArrayList<MushroomSpecies> searchedMushrooms = new ArrayList<MushroomSpecies>();
        for (MushroomSpecies mushroomSpecies: speciesRegistry) {
            if (Pattern.compile(Pattern.quote(search),
                    Pattern.CASE_INSENSITIVE).matcher(mushroomSpecies.getDesc()).find())
                searchedMushrooms.add(new MushroomSpecies(mushroomSpecies));
        }
        return searchedMushrooms;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (MushroomSpecies mushroomSpecies : speciesRegistry){
            sb.append(mushroomSpecies);
        }
        return sb.toString();
    }
}
