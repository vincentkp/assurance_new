package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.service.deces.TypeapporteurServiceBeanLocal;
import com.contrat.dao.deces.TypeapporteurDaoBeanLocal;
import com.contrat.entities.Typeapporteur;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class TypeapporteurServiceBean extends BaseServiceBean<Typeapporteur, Integer> implements TypeapporteurServiceBeanLocal {

@EJB
private TypeapporteurDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Typeapporteur, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Typeapporteur> typeapporteurall() {
        return this.dao.typeapporteurall();
    }
}