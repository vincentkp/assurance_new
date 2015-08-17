package com.contrat.dao.impl.deces;

import com.contrat.dao.deces.SouscripteurDaoBeanLocal;
import com.contrat.dao.impl.BaseDaoBean;
import com.contrat.entities.Souscripteur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class SouscripteurDaoBean extends BaseDaoBean<Souscripteur,Integer> implements SouscripteurDaoBeanLocal {

    public SouscripteurDaoBean() {
        super(Souscripteur.class);
    }

    @Override
    public List<Souscripteur> souscripteurall() {
        Query q=this.em.createQuery("SELECT s from Souscripteur s WHERE s.statutsous=:valeur");
        q.setParameter("valeur", "actif");
        return q.getResultList();
    }

    
}
