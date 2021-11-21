package Oving_4;

public class Valuta {
    private float pengerEtterOmgjoering;
    private float kurs;
    private String name;

    public Valuta(float kurs, String name){
        this.kurs = kurs;
        this.name = name;
    }

    public void pengerFraNok(float pengeSum){
        if (pengeSum != 0) {
            this.pengerEtterOmgjoering = pengeSum / kurs;
        }
    }

    public void pengerTilNok(float pengeSum){
        if (pengeSum != 0) {
            this.pengerEtterOmgjoering = pengeSum * kurs;
        }
    }

    public float hentSum() {
        return pengerEtterOmgjoering;
    }
}