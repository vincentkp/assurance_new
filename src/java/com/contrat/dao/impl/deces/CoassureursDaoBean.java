package com.contrat.dao.impl.deces;

import com.contrat.dao.deces.CoassureursDaoBeanLocal;
import com.contrat.dao.impl.BaseDaoBean;
import com.contrat.entities.Coassureurs;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class CoassureursDaoBean extends BaseDaoBean<Coassureurs, Integer> implements CoassureursDaoBeanLocal {

    public CoassureursDaoBean() {
        super(Coassureurs.class);
    }

    @Override
    public List<Coassureurs> coassureurall() {
        Query q = this.em.createQuery("SELECT c from Coassureurs c WHERE c.statutcoass=:valeur");
        q.setParameter("valeur", "actif");
        return q.getResultList();

    }

}
