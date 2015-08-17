package com.contrat.service.deces;

import javax.ejb.Local;
import com.contrat.entities.Typeapporteur;
import com.contrat.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface TypeapporteurServiceBeanLocal extends BaseServiceBeanLocal<Typeapporteur, Integer> {
     List<Typeapporteur> typeapporteurall(); 
}