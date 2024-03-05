package td2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class Stock {
    public HashMap<String, Integer> getStockMg() {
		return stockMg;
	}

	public void setStockMg(HashMap<String, Integer> stockMg) {
		this.stockMg = stockMg;
	}

	private HashSet<Article> articlesMg = new HashSet<>();
    private HashMap<String, Integer> stockMg = new HashMap<>();

    public boolean addNouvArticle(Article a, int qt) {
        if (stockMg.containsKey(a.getNom()))
            return false;
        articlesMg.add(a);
        stockMg.put(a.getNom(), qt);
        return true;
    }

    public boolean verifArticle(String a) {
        return stockMg.containsKey(a);
    }

    public Article getArticle(String a) {
        for (Article article : articlesMg) {
            if (article.getNom().equals(a)) {
                return article;
            }
        }
        return null;
    }

    public boolean removeArticle(String a) {
        if (!stockMg.containsKey(a))
            return false;
        Iterator<Article> it = articlesMg.iterator();
        while (it.hasNext()) {
            Article article = it.next();
            if (article.getNom().equals(a)) {
                it.remove();
                stockMg.remove(a);
                return true;
            }
        }
        return false;
    }

    public int getQt(String a){
	    if(!stockMg.containsKey(a))
	    	return -1;
	    else
	    	return stockMg.get(a);

    }

    public boolean changeQt(String a, int i) {
        if (!stockMg.containsKey(a))
            return false;
        int qt = stockMg.get(a);
        qt = qt + i;
        if (qt < 0)
            return false;
        else
            stockMg.put(a, qt);
        return true;
    }

    public void sortStock() {
        List<String> keys = new ArrayList<>(stockMg.keySet());
        Collections.sort(keys);
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (String key : keys) {
            sortedMap.put(key, stockMg.get(key));
        }
        stockMg = sortedMap;
    }
    
}

