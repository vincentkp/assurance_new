package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.service.deces.DossiersinistreServiceBeanLocal;
import com.contrat.dao.deces.DossiersinistreDaoBeanLocal;
import com.contrat.entities.Dossiersinistre;

/**
 *
 * @author K.M.A
 */
@Stateless
public class DossiersinistreServiceBean extends BaseServiceBean<Dossiersinistre, Integer> implements DossiersinistreServiceBeanLocal {

@EJB
private DossiersinistreDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Dossiersinistre, Integer> getDAO() {
        return this.dao;
    }
}