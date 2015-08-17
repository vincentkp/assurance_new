package com.contrat.dao.deces;

import com.contrat.dao.BaseDaoBeanLocal;
import com.contrat.entities.Modepayement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface ModepayementDaoBeanLocal extends BaseDaoBeanLocal<Modepayement, Integer>{
    List<Modepayement> listmodepayementall();
}