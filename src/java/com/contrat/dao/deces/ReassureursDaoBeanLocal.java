package com.contrat.dao.deces;

import com.contrat.dao.BaseDaoBeanLocal;
import com.contrat.entities.Reassureurs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface ReassureursDaoBeanLocal extends BaseDaoBeanLocal<Reassureurs, Integer>{
    List<Reassureurs> reassureurall();
    List<Reassureurs> recherchereassureurnom(String nom);
    
}