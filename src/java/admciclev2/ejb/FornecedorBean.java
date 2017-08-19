/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admciclev2.ejb;

import admciclev2.dao.FornecedorDAO;
import admciclev2.modelo.Fornecedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * EJB do fornecedor
 * 
 * @author caio.correa
 */
@Stateless
public class FornecedorBean implements FornecedorRemote {

    @PersistenceContext
    private EntityManager entityManager;
    
    private FornecedorDAO dao;
    
    public FornecedorBean(){
        this.dao = new FornecedorDAO(entityManager);
       }
    
    public Fornecedor salvar(Fornecedor fornecedor){
        try{
            fornecedor = this.dao.salvar(fornecedor);
        } catch (Exception ex){
            ex.printStackTrace();
        }
         return fornecedor;
    }
    
    public void excluir(Long id){
        this.dao.excluir(id);
    }
    
    public Fornecedor consultarPorRazao(String razao){
        return this.dao.consultarPorRazao(razao);
    }
    
    public Fornecedor consultarPorNome(String nome){
        return this.dao.consultarPorNome(nome);
        }
        
    public Fornecedor consultarPorContato(String contato){
        return this.dao.consultarPorContato(contato);
        }
    
    public Fornecedor consultarPorCnpj(String CNPJ){
        return this.dao.consultarPorCnpj(CNPJ);
    }
 
    public Fornecedor consultarPorCpf(String CPF){
        return this.dao.consultarPorCpf(CPF);
    }
    
    public Fornecedor consultarPorInscricao(String inscricao){
        return this.dao.consultarPorInscricao(inscricao);
    }
}
