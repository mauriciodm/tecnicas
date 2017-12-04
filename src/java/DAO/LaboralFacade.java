/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Laboral;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CASKLE
 */
@Stateless
public class LaboralFacade extends AbstractFacade<Laboral> {

    @PersistenceContext(unitName = "PerfilProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LaboralFacade() {
        super(Laboral.class);
    }
    
}
