package com.contrat.dao.impl.deces;

import com.contrat.dao.deces.TypecontratDaoBeanLocal;
import com.contrat.dao.impl.BaseDaoBean;
import com.contrat.entities.Typecontrat;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class TypecontratDaoBean extends BaseDaoBean<Typecontrat,Integer> implements TypecontratDaoBeanLocal {

    public TypecontratDaoBean() {
        super(Typecontrat.class);
    }

    @Override
    public List<Typecontrat> typecontratall() {
        Query list=this.em.createQuery("SELECT t FROM Typecontrat t WHERE t.statuttypecontrat=:valeur");
        list.setParameter("valeur", "actif");
        return list.getResultList();
    }

    @Override
    public List<Typecontrat> autretypecontrat() {
        Query q=this.em.createQuery("SELECT t FROM Typecontrat t WHERE t.libtypecontrat<>:valeur AND t.statuttypecontrat=:valeur2");
        q.setParameter("valeur", "groupe entreprise");
        q.setParameter("valeur2", "actif");
        return q.getResultList();
    }

    
}
