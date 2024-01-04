public class TestSimulation {
    public static void main(String[] args) throws CoordonneesIncorrectesException,DeplacementsIncorrectes,CaseNonPleineException{
        Simulation s = new Simulation(5) ;
        Gardien g1 = new Gardien("Bart", 1, 50);
        g1.setPosition(2, 3);

        s.gri.setCase(2, 3, g1);
        Gardien g2 = new Gardien("Roger", 1, 200);

        g2.setPosition(1, 4);
        s.gri.setCase(1 ,4, g2);
        s.gri.affiche(7);
        System.out.println(s.gri.toString());
        g1.TP(4,2,s.gri);
        g2.TP(3,4,s.gri);
        s.gri.affiche(6);
        s.lance(20);
        System.out.println(s.gri.toString());
        s.gri.lesContenus() ;

        


        

    }

    
}
