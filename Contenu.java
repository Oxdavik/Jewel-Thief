public class Contenu {
    private final int ident;
    public final String type;
    private int quantite;
    protected int x;
    protected int y;
    private static int cpt =0 ;
    public Contenu(String type, int quantite) {
        this.type = type;
        this.quantite = quantite;
        this.ident = cpt++; 
        this.x = -1;
        this.y = -1;
    }

    public int getQuantite() {
        return quantite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPosition(int lig, int col) {
        this.x = lig;
        this.y = col;
    }

    public void initialisePosition() {
        this.x = -1;
        this.y = -1;
    }


    @Override
    public String toString() {
        return "Identifiant: " + ident + ", Type: " + type + ", Position: (" + x + ", " + y + ")";
    }}



