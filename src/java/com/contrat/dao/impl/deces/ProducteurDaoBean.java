package com.contrat.dao.impl.deces;

import com.contrat.dao.deces.ProducteurDaoBeanLocal;
import com.contrat.dao.impl.BaseDaoBean;
import com.contrat.entities.Producteur;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ProducteurDaoBean extends BaseDaoBean<Producteur,Integer> implements ProducteurDaoBeanLocal {

    public ProducteurDaoBean() {
        super(Producteur.class);
    }

    
}
