import java.util.ArrayList;

public class PropertyRegister {
    private ArrayList<Property> propReg;

    public PropertyRegister() {
        propReg = new ArrayList<Property>();
    }

    public ArrayList<Property> getPropReg() {
        return propReg;
    }

    /**
     *
     * @param kommuneNr
     * @param kommuneNavn
     * @param gnr
     * @param bnr
     * @param bruksNavn
     * @param areal
     * @param eierNavn
     */

    public void propReg(int kommuneNr, String kommuneNavn, int gnr, int bnr, String bruksNavn, float areal, String eierNavn) {
        Property nyProp = new Property(kommuneNr, kommuneNavn, gnr, bnr, bruksNavn, areal, eierNavn);
        if (!propReg.contains(nyProp)) {
            this.propReg.add(nyProp);
        }
    }

    public float avgAreal() {
        float totalAreal = 0;
        for (int i = 0; i < this.propReg.size(); i++) {
            totalAreal += this.propReg.get(i).getAreal();
        }
        float avgAreal = totalAreal/this.propReg.size();
        return avgAreal;
    }

    public String sokProp (int kommuneNr, int gnr, int bnr) {
        String soktProps = "";
        for (int i = 0; i < this.propReg.size(); i++) {
            if (this.propReg.get(i).getKommuneNr() == kommuneNr && this.propReg.get(i).getGnr() == gnr && this.propReg.get(i).getBnr() == bnr) {
                soktProps += (this.propReg.get(i).toString());
            }
        }
        return soktProps;
    }

    public String sokPropsByGnr (int gnr) {
        String soktPropsGnr = "";
        for (int i = 0; i < this.propReg.size(); i++) {
            if (this.propReg.get(i).getGnr() == gnr) {
                soktPropsGnr += (this.propReg.get(i).toString());
            }
        }
        return soktPropsGnr;
    }

    @Override
    public String toString() {
        String props = "";
        for (int i = 0; i < this.getPropReg().size(); i++) {
            props += this.getPropReg().get(i).toString();
        }
        return props;
    }
}
