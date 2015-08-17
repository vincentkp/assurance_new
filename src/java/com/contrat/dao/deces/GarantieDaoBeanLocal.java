package com.contrat.dao.deces;

import com.contrat.dao.BaseDaoBeanLocal;
import com.contrat.entities.Garantie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface GarantieDaoBeanLocal extends BaseDaoBeanLocal<Garantie, Integer>{
    List<Garantie> garantieall();
    
}