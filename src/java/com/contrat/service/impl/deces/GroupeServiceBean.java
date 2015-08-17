package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.service.deces.GroupeServiceBeanLocal;
import com.contrat.dao.deces.GroupeDaoBeanLocal;
import com.contrat.entities.Groupe;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class GroupeServiceBean extends BaseServiceBean<Groupe, Integer> implements GroupeServiceBeanLocal {

@EJB
private GroupeDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Groupe, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Groupe> groupeall() {
        return this.dao.groupeall();
    }
}