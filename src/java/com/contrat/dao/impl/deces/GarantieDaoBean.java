package com.contrat.dao.impl.deces;

import com.contrat.dao.deces.GarantieDaoBeanLocal;
import com.contrat.dao.impl.BaseDaoBean;
import com.contrat.entities.Garantie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class GarantieDaoBean extends BaseDaoBean<Garantie,Integer> implements GarantieDaoBeanLocal {

    public GarantieDaoBean() {
        super(Garantie.class);
    }

    @Override
    public List<Garantie> garantieall() {
        Query q=this.em.createQuery("SELECT g from Garantie g WHERE g.statutgarantie=:valeur");
        q.setParameter("valeur", "actif");
        return q.getResultList();
    }
    

     
}
