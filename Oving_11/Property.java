public class Property {
    private final int kommuneNr;
    private final String kommuneNavn;
    private final int gnr;
    private final int bnr;
    private final String bruksNavn;
    private final float areal;
    private final String eierNavn;

    public Property(int kommuneNr, String kommuneNavn, int gnr, int bnr, String bruksNavn, float areal, String eierNavn) {
        this.kommuneNr = kommuneNr;
        this.kommuneNavn = kommuneNavn;
        this.gnr = gnr;
        this.bnr = bnr;
        this.bruksNavn = bruksNavn;
        this.areal = areal;
        this.eierNavn = eierNavn;
    }

    public int getKommuneNr() {
        return kommuneNr;
    }

    public String getKommuneNavn() {
        return kommuneNavn;
    }

    public int getGnr() {
        return gnr;
    }

    public int getBnr() {
        return bnr;
    }

    public String getBruksNavn() {
        return bruksNavn;
    }

    public float getAreal() {
        return areal;
    }

    public String getEierNavn() {
        return eierNavn;
    }

    public String getId() {
        return this.getKommuneNr() + "-" + this.getGnr() + "/" + this.getBnr() + '\n';
    }

    @Override
    public String toString() {
        return "Eiendom: " + '\n' +
                "Kommune: " + this.getKommuneNavn() + '\n' +
                "Eiendomsnummer: " + this.getId() +
                "Bruksnavn: " + this.getBruksNavn() + '\n' +
                "Areal i kvm: " + this.getAreal() + '\n' +
                "Eier: " + this.getEierNavn() + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return kommuneNr == property.kommuneNr && gnr == property.gnr && bnr == property.bnr;
    }
}
