/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Perfil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CASKLE
 */
@Stateless
public class PerfilFacade extends AbstractFacade<Perfil> {

    @PersistenceContext(unitName = "PerfilProyectoPU")
    private EntityManager em;
    
     @Override
    public void create(Perfil perfil){
        em.persist(perfil);
    }
    
    @Override
    public void remove(Perfil Nombre){
        em.remove(em.merge(Nombre));
    }
    
    @Override
    public void edit(Perfil perfil){
        em.merge(perfil);
    }
    
    
    public Perfil fin(String Id){
        return em.find(Perfil.class, Id);
    }
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilFacade() {
        super(Perfil.class);
    }
    
}
