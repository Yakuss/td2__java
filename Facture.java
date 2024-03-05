package td2;

import java.util.ArrayList;

public class Facture {
    private ArrayList<LigneFacture> lignes;
    private Stock stock;

    public Facture(Stock stock) {
        this.stock = stock;
        lignes = new ArrayList<LigneFacture>();
    }

    public boolean addLigne(int qt, String a) {
        if (!stock.verifArticle(a))
            return false;
        int Q = stock.getQt(a);
        if (Q <= 0 || Q < qt)
            return false;
        int id = lignes.size() + 1;
        LigneFacture LF = new LigneFacture(id, qt, stock.getArticle(a));
        lignes.add(LF);
        stock.changeQt(a, -qt);
        return true;
    }

    public ArrayList<LigneFacture> getLignes() {
		return lignes;
	}

	public void setLignes(ArrayList<LigneFacture> lignes) {
		this.lignes = lignes;
	}

	public boolean removeLigne(int id) {
        int size = lignes.size();
        if (id > size)
            return false;
        else {
            LigneFacture ligneFacture = lignes.get(id - 1);
            int qt = ligneFacture.getQt();
            stock.changeQt(ligneFacture.getArticle().getNom(), qt);
            lignes.remove(id - 1);
            for (int i = id - 1; i < size - 1; i++)
                lignes.get(i).setId(i + 1);
            return true;
        }
    }

    public double getMontantTotal() {
        double mT = 0.0;
        for (LigneFacture LF : lignes) {
            mT += LF.getMontantTotal();
        }
        return mT;
    }

    @Override
    public String toString() {
        return "Facture{" +"lignes=" + lignes +", stock=" + stock +'}';
    }

    	public static void main(String[] args) {
    	    Stock stock = new Stock();
    	    Article article1 = new Article("Livre", 10.0);
    	    
    	    stock.addNouvArticle(article1, 5);
    	    
    	    Article article2 = new Article("Stylo", 1.5);
    	    
    	    stock.addNouvArticle(article2, 20);

    	    Facture facture = new Facture(stock);

    	  
    	    facture.addLigne(3, "Livre");
    	    facture.addLigne(5, "Stylo");

    	   
    	    System.out.println("facture:");
    	    for (LigneFacture ligne : facture.getLignes()) {
    	        System.out.println(ligne);
    	    }

    	    
    	    facture.removeLigne(1);

    	  
    	    System.out.println("after removing a ligne:");
    	    for (LigneFacture ligne : facture.getLignes()) {
    	        System.out.println(ligne);
    	    }

    	 
    	    System.out.println("after sorting:");
    	    stock.sortStock();
    	    for (String article : stock.getStockMg().keySet()) {
    	        System.out.println(article + ": " + stock.getStockMg().get(article));
    	    }
    	    
    	    System.out.println("montant total est:" +facture.getMontantTotal());
    	    
    	} 

    }


