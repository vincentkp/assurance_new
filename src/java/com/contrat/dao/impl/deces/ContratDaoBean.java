package com.contrat.dao.impl.deces;

import com.contrat.dao.deces.ContratDaoBeanLocal;
import com.contrat.dao.impl.BaseDaoBean;
import com.contrat.entities.Contrat;
import com.contrat.entities.Groupe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ContratDaoBean extends BaseDaoBean<Contrat,Integer> implements ContratDaoBeanLocal {

    public ContratDaoBean() {
        super(Contrat.class);
    }

    @Override
    public List<Contrat> contratall() {
        Query q=this.em.createQuery("SELECT c from Contrat c WHERE c.etatcontrat=:valeur AND c.dateexp>CURRENT_TIMESTAMP");
        q.setParameter("valeur", "actif");
        return q.getResultList();
    }

    @Override
    public List<Contrat> contratentreprise() {
        Query q=this.em.createQuery("SELECT SUM(c.capitgarantitotale),c.idgarantie from Contrat c GROUP BY c.idgarantie ");
        return q.getResultList();
       
    }


    @Override
    public List<Contrat> contratresilie() {
        Query q=this.em.createQuery("SELECT c FROM Contrat c WHERE c.etatcontrat=:valeur");
        q.setParameter("valeur", "inactif");
        return q.getResultList();
    }

    @Override
    public Double sommecapitale() {
 Query q = em.createQuery("SELECT SUM(c.capitgarantitotale) FROM Contrat c WHERE c.codeapp  IS NULL");
        return (Double) q.getSingleResult();
    }
    

    @Override
    public Double sommeprime() {
        Query q=this.em.createQuery("SELECT SUM(c.primemontant) FROM Contrat c WHERE c.codeapp IS NULL");
        return (Double) q.getSingleResult();
    }

    @Override
    public List<Contrat> assurecontratgroupe(Groupe gr) {
        Query q=this.em.createQuery("SELECT c FROM Contrat c WHERE c.idgroupe=:valeur");
        q.setParameter("valeur", gr);
        return q.getResultList();
    }

    @Override
    public List<Contrat> autregroupe() {
        Query q=this.em.createQuery("SELECT c FROM Contrat c WHERE c.idtypecontrat.libtypecontrat<>:valeur AND c.etatcontrat=:valeur2 AND c.dateexp>CURRENT_TIMESTAMP");
        q.setParameter("valeur", "groupe entreprise");
        q.setParameter("valeur2", "actif");
        return q.getResultList();
    }

    
}
