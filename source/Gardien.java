public class Gardien extends Contenu implements Teleportation {
    private int pv ;
    public Gardien(String type,int quantite,int pv){
        super(type,quantite);
        this.pv = pv;
    }
    public int getPv(){
        return pv ;
    }
    public void pertepv(int p){
        this.pv-=p ;
    }
    public void TP(int x, int y, Grille g) throws CoordonneesIncorrectesException,CaseNonPleineException {
        // Retire le gardien de sa position actuelle
        g.videCase(this.x, this.y);
        
        
        if (Math.random() < 0.9) {
            if (g.sontValides(x, y)) {
                // Téléporte le gardien aux nouvelles coordonnées dans la grille
                this.x = x;
                this.y = y;
                g.setCase(this.x, this.y, this);
                System.out.println("Gardien téléporté à la position : " + x + "," + y);
            } else {
                System.out.println("Les nouvelles coordonnées ne sont pas valides.");
            }
        } else {
            System.out.println("La téléportation du gardien a échoué.");
        }
    }
    
    public String toString(){
        return super.toString()+" pv:"+ getPv() ;
    }
    
}
