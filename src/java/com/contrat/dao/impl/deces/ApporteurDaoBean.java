package com.contrat.dao.impl.deces;

import com.contrat.dao.deces.ApporteurDaoBeanLocal;
import com.contrat.dao.impl.BaseDaoBean;
import com.contrat.entities.Apporteur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ApporteurDaoBean extends BaseDaoBean<Apporteur,Integer> implements ApporteurDaoBeanLocal {

    public ApporteurDaoBean() {
        super(Apporteur.class);
    }

    @Override
    public List<Apporteur> apporteurall() {
        Query q=this.em.createQuery("SELECT a from Apporteur a WHERE a.statutapp=:valeur");
        q.setParameter("valeur", "actif");
        return q.getResultList();
    }

    @Override
    public List<Apporteur> recherchenom(String nom) {
        Query q=this.em.createQuery("SELECT a FROM Apporteur a WHERE UPPER(a.nomapp) LIKE :nom");
        q.setParameter("valeur", "%"+nom.toUpperCase()+"%");
        return q.getResultList();
    }

  
    
}
