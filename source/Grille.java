import java.util.ArrayList ;

public final class Grille {
    public final  int nbColonnes ;
    public static final int NBCOLONNESMAX=20;
    public final int nbLignes ;
    public static final int NBLIGNESMAX = 20;
    private Contenu[][] grille ;


    public Grille(){
        this.nbColonnes = NBCOLONNESMAX ;
        this.nbLignes = NBLIGNESMAX ;
        this.grille = new Contenu[NBCOLONNESMAX][NBLIGNESMAX];

    }
    public Grille(int nbLi,int nbcol){
        if (sontValides(nbLi, nbcol)){
        this.nbColonnes = nbcol ;
        this.nbLignes = nbLi ;
        this.grille = new Contenu[nbLignes][nbColonnes];
    }
        else {
            this.nbColonnes = 1 ;
            this.nbLignes = 1 ;
            this.grille = new Contenu[nbLignes][nbColonnes];
        }
    }
    public Contenu getCase(int lig,int col) throws CoordonneesIncorrectesException {
        if (!sontValides(lig, col)){
            throw new CoordonneesIncorrectesException("Coordonnees Incorrectes");}
        else {
            return grille[lig][col];}}
public Contenu videCase(int lig, int col) throws CaseNonPleineException, CoordonneesIncorrectesException {
    if (grille[lig][col]==null){
        throw new CaseNonPleineException("Case vide");
    }
    if (!sontValides(lig, col)){
        throw new CoordonneesIncorrectesException("Coordonnees Incorrectes");
    }
    else {
        Contenu c = grille[lig][col] ;
        grille[lig][col] = null ;
        return c ;
    }


}
public void setCase(int lig, int col, Contenu contenu) throws CoordonneesIncorrectesException {
    if (sontValides(lig, col)){
        grille[lig][col] = contenu ;
    } else {
        throw new CoordonneesIncorrectesException("Coordonnees Incorrectes");
    }
}


public boolean caseEstVide(int lig, int col) throws CoordonneesIncorrectesException{
    if (!sontValides(lig, col)){
        throw new CoordonneesIncorrectesException(null);
    }
    return grille[lig][col]==null ;
    }
public boolean sontValides(int lig, int col){
    return (col >= 0 && col <= NBCOLONNESMAX && lig >= 0 && lig <= NBLIGNESMAX);}

public String toString(){
    String s ="CONTENUS:\n";
    for (Contenu[] c1:grille){
        for(Contenu c2: c1){
            if (c2!=null){
            s+=c2+"\n" ;}
        }
    }
    return s ;}

public ArrayList<Contenu> lesContenus(){
        ArrayList<Contenu> contents = new ArrayList<>();
        for (Contenu[] ligne : grille) {
            for (Contenu cellContent : ligne) {
                if (cellContent != null) {
                    contents.add(cellContent);
                }
            }
        }
        return contents;
    }
    public void affiche(int nbCaracteres) {
        // Loop through each row
        for (int i = 0;  i < nbLignes; i++) {
            System.out.println("===========================================");
            for (int j = 0; j < nbColonnes; j++) {
                if (grille[i][j] != null) {
                    String s = ""+(grille[i][j].type);
                    if (s.length() < nbCaracteres)  {
                        while (s.length() < nbCaracteres) {
                            s += " ";
                        }
                    }
                    System.out.print(s);
                } else {
                    // If no content, print empty space
                    for (int k = 0; k < nbCaracteres; k++) {
                        System.out.print(" ");
                    }
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
        System.out.println("===========================================");
    }
    
}

