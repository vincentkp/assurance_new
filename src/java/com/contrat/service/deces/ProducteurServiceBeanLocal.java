package com.contrat.service.deces;

import javax.ejb.Local;
import com.contrat.entities.Producteur;
import com.contrat.service.BaseServiceBeanLocal;

/**
 *
 * @author K.M.A
 */
@Local
public interface ProducteurServiceBeanLocal extends BaseServiceBeanLocal<Producteur, Integer> {
}