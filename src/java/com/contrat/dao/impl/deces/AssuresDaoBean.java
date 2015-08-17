package com.contrat.dao.impl.deces;

import com.contrat.dao.deces.AssuresDaoBeanLocal;
import com.contrat.dao.impl.BaseDaoBean;
import com.contrat.entities.Assures;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class AssuresDaoBean extends BaseDaoBean<Assures,Integer> implements AssuresDaoBeanLocal {

    public AssuresDaoBean() {
        super(Assures.class);
    }

    @Override
    public List<Assures> assureall() {
        Query q=this.em.createQuery("SELECT a from Assures a WHERE a.statutassur=:valeur");
        q.setParameter("valeur", "actif");
        return q.getResultList();
    }

  

    @Override
    public Integer moyenneage() {
        Query q=this.em.createQuery("SELECT AVG(a.ageassur) FROM Assures a where a.codsous IS NULL ");
        return (Integer) q.getSingleResult();
    }

    @Override
    public List<Assures> assureentreprise() {
        Query q=this.em.createQuery("SELECT a FROM Assures a   WHERE a.gentreprise=:valeur ORDER BY a.codassure DESC ");
        q.setParameter("valeur", "oui");
        return q.getResultList();
    }

    
}
