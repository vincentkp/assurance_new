package com.contrat.dao.impl.deces;

import com.contrat.dao.deces.TypeapporteurDaoBeanLocal;
import com.contrat.dao.impl.BaseDaoBean;
import com.contrat.entities.Typeapporteur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class TypeapporteurDaoBean extends BaseDaoBean<Typeapporteur,Integer> implements TypeapporteurDaoBeanLocal {

    public TypeapporteurDaoBean() {
        super(Typeapporteur.class);
    }

    @Override
    public List<Typeapporteur> typeapporteurall() {
        Query list=this.em.createQuery("SELECT t FROM Typeapporteur t WHERE t.statuttypeapporteur=:valeur");
          list.setParameter("valeur", "actif");
          return list.getResultList();
    }

    
}
