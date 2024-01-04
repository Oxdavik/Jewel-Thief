public class Joyau extends Contenu {   
    private int prix ;
    public Joyau(String type, int quantite) {
    super(type, quantite);
    this.prix = (int)((Math.random()*8000-1)+1);
}

public int getPrix() {
    return prix;
}
public String toString(){
    return super.toString()+"Prix:"+getPrix();
}
}
    
