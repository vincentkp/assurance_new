package com.contrat.service.deces;

import javax.ejb.Local;
import com.contrat.entities.Garantie;
import com.contrat.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface GarantieServiceBeanLocal extends BaseServiceBeanLocal<Garantie, Integer> {
      List<Garantie> garantieall();
}