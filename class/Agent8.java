import java.util.ArrayList; 

public class Agent8 {
    private int posX;
    private int posY;
    private ArrayList<Joyau> sacdejoyaux ;
    private Grille g ;


    public Agent8(int xnew,int ynew,Grille g){

        this.posX = xnew ;
        this.posY = ynew ;
        sacdejoyaux = new ArrayList<Joyau> () ;
        this.g = g ;



    }
    public boolean deplacementvalide(int x,int y){
        return (y>=0 && y<Grille.NBCOLONNESMAX-1 &&  x>=0 && x<Grille.NBLIGNESMAX-1); 
    }
        public void seDeplacer(int xnew,int ynew) throws DeplacementsIncorrectes,CaseNonPleineException,CoordonneesIncorrectesException{       
        if (!deplacementvalide(xnew, ynew)){
            throw new DeplacementsIncorrectes("Deplacements Incorrectes");}
        this.posX = xnew ;
        this.posY = ynew ;
            Contenu contenuCase = g.getCase(xnew, ynew);
            if (contenuCase instanceof Joyau) {
                sacdejoyaux.add((Joyau) contenuCase);
                g.videCase(posX, posY);

            }
            if (contenuCase instanceof Gardien){
                sacdejoyaux = new ArrayList<Joyau>() ;
            }
        }
    public int getPosX(){
        return posX ;
    }
        public int getPosY(){
        return posY ;
    }




    public void seDeplacer(int xnew,int ynew,int f) throws DeplacementsIncorrectes,CaseNonPleineException,CoordonneesIncorrectesException {
        if (!(g.sontValides(xnew, ynew))) {
            throw new DeplacementsIncorrectes("Deplacements Incorrectes");

        } 
        this.posX = xnew ;
        this.posY = ynew ;

        Contenu contenuCase = g.getCase(xnew, ynew);
        if (contenuCase instanceof Joyau) {
            sacdejoyaux.add((Joyau) contenuCase);
            g.videCase(posX, posY);
            }
            if (contenuCase instanceof Gardien){
                if (f>((Gardien)contenuCase).getPv()){
                g.videCase(xnew, ynew) ;}
                else {

                    ((Gardien)contenuCase).pertepv(f);
                    sacdejoyaux = new ArrayList<Joyau>() ;
                }

            }

    }
    
public int fortune() {
    if (sacdejoyaux ==null){
        return 0 ;
    }
    int somme = 0;
    for (int i = 0; i < sacdejoyaux.size(); i++) {
        Joyau joyau = sacdejoyaux.get(i);
        if (joyau != null) {
            somme += joyau.getQuantite()*joyau.getPrix();
        }
    }
    return somme;
}
    public void contenuSac(){
        System.out.println("Contenu du sac:");
        for (int i = 0; i < sacdejoyaux.size(); i++) {
        Joyau joyau = sacdejoyaux.get(i);
        if (joyau != null) {
            System.out.println(joyau.toString());

        }
        }


    }
    
}
