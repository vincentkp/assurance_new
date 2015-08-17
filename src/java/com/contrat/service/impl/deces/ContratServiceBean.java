package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.service.deces.ContratServiceBeanLocal;
import com.contrat.dao.deces.ContratDaoBeanLocal;
import com.contrat.entities.Contrat;
import com.contrat.entities.Groupe;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ContratServiceBean extends BaseServiceBean<Contrat,Integer> implements ContratServiceBeanLocal {

@EJB
private ContratDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Contrat, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Contrat> contratall() {
return this.dao.contratall();
    }

    @Override
    public List<Contrat> contratentreprise() {
        return this.dao.contratentreprise();
    }

    @Override
    public List<Contrat> contratresilie() {
        return this.dao.contratresilie();
    }

    @Override
    public Double sommecapitale() {
        return this.dao.sommecapitale();
    }

    @Override
    public Double sommeprime() {
        return this.dao.sommeprime();
    }

    @Override
    public List<Contrat> assurecontratgroupe(Groupe gr) {
        return this.dao.assurecontratgroupe(gr);
    }

    @Override
    public List<Contrat> autregroupe() {
        return this.dao.autregroupe();
    }
    
}