package com.contrat.dao.impl.deces;

import com.contrat.dao.deces.ModepayementDaoBeanLocal;
import com.contrat.dao.impl.BaseDaoBean;
import com.contrat.entities.Modepayement;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;


/**
 *
 * @author K.M.A
 */
@Stateless
public class ModepayementDaoBean extends BaseDaoBean<Modepayement,Integer> implements ModepayementDaoBeanLocal {

    public ModepayementDaoBean() {
        super(Modepayement.class);
    }

    @Override
    public List<Modepayement> listmodepayementall() {
        Query q=this.em.createQuery("SELECT m from Modepayement m WHERE m.statutmodpaye=:valeur");
        q.setParameter("valeur", "actif");
        return q.getResultList();
    }

    
}
