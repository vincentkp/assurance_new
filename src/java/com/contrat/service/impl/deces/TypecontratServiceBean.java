package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.service.deces.TypecontratServiceBeanLocal;
import com.contrat.dao.deces.TypecontratDaoBeanLocal;
import com.contrat.entities.Typecontrat;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class TypecontratServiceBean extends BaseServiceBean<Typecontrat, Integer> implements TypecontratServiceBeanLocal {

@EJB
private TypecontratDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Typecontrat, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Typecontrat> typecontratall() {
        return this.dao.typecontratall();
    }

    @Override
    public List<Typecontrat> autretypecontrat() {
        return this.dao.autretypecontrat();
    }
}