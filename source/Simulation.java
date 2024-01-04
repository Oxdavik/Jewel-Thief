//CHING David Wassim Bouzidi

public class Simulation {
    private Contenu[] tabContenu ;
    private static String[] nomjoyau = {"Diamant","Rubis","Or","Argent"} ;

    Grille gri ;
    Agent8 agent ;
    public Simulation(int nbContenu) throws CoordonneesIncorrectesException {
        this.gri = new Grille(5, 5);
        this.tabContenu = new Contenu[nbContenu];
    
        int agentX = (int) (Math.random() * gri.nbLignes);
        int agentY = (int) (Math.random() * gri.nbColonnes);
        this.agent = new Agent8(agentX, agentY, gri);
        
        for (int i = 0; i < nbContenu; i++) {
            int contenuX = (int) (Math.random() * gri.nbLignes);
            int contenuY = (int) (Math.random() * gri.nbColonnes);
            int alea = (int) (Math.random() * 3);
            tabContenu[i] = new Joyau(nomjoyau[alea], 3);
            tabContenu[i].setPosition(contenuX, contenuY);
            gri.setCase(contenuX, contenuY, tabContenu[i]);
        }
    }
    
    public String toString(){
        gri.affiche(6) ;
        return "Position de l'agent:" + agent.getPosX()+","+agent.getPosY()+" Total Gain:"+agent.fortune()+"\n" ;
    }
    public void lance(int nbEtapes) throws DeplacementsIncorrectes, CoordonneesIncorrectesException, CaseNonPleineException {
        for (int i = 0; i < nbEtapes; i++) {
            int x = (int) (Math.random()*gri.nbLignes);
            int y = (int) (Math.random() *gri.nbColonnes);
    
            if (Math.random() < 0.3) {
                int f = (int) ((Math.random() * 100+10) - 10);
                agent.seDeplacer(x, y, f) ;              
                System.out.println("Déplacement avec force à : " + agent.getPosX() + "," + agent.getPosY() + " avec une force de : " + f);

            } else {
                agent.seDeplacer(x, y);
                System.out.println("Déplacement sans force à : " + agent.getPosX() + "," + agent.getPosY());

            }
            
            System.out.println("Total Gain: " + agent.fortune());
            //agent.seDeplacer(1, 0);
            //System.out.println("Total Gain: " + agent.fortune()); //si il croise un gardien
            agent.contenuSac();
        }
    }








    
}
