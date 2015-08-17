package com.contrat.dao.impl.deces;

import com.contrat.dao.deces.GroupeDaoBeanLocal;
import com.contrat.dao.impl.BaseDaoBean;
import com.contrat.entities.Groupe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class GroupeDaoBean extends BaseDaoBean<Groupe,Integer> implements GroupeDaoBeanLocal {

    public GroupeDaoBean() {
        super(Groupe.class);
    }

    @Override
    public List<Groupe> groupeall() {
        Query q=this.em.createQuery("SELECT g from Groupe g WHERE g.statutgroup=:valeur");
        q.setParameter("valeur", "actif");
        return q.getResultList();
    }

    
}
