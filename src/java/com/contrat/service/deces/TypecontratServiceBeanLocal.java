package com.contrat.service.deces;

import javax.ejb.Local;
import com.contrat.entities.Typecontrat;
import com.contrat.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface TypecontratServiceBeanLocal extends BaseServiceBeanLocal<Typecontrat, Integer> {
    List<Typecontrat> typecontratall();
    List<Typecontrat> autretypecontrat();
}