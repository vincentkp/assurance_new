package com.contrat.service.deces;

import javax.ejb.Local;
import com.contrat.entities.Coassureurs;
import com.contrat.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface CoassureursServiceBeanLocal extends BaseServiceBeanLocal<Coassureurs, Integer> {
    List<Coassureurs> coassureurall();
}