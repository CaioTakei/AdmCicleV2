/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admciclev2.dao;

import admciclev2.modelo.Fornecedor;
import javax.persistence.EntityManager;

/**
 *Classe utilizada para fazer a interação com o EntityManager.
 * @author caio.correa
 */
public class FornecedorDAO {

    private EntityManager entityManager;

    /**
     * Construtor da classe DAO que chama os metodos do EntityManager.
     * 
     * @param entityManager
     */
    public FornecedorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    /**
     * Método para salvar ou atualizar o Fornecedor.
     * 
     * @param fornecedor
     * @return
     * throws java.lang.Exception
     */
    public Fornecedor salvar(Fornecedor fornecedor) throws Exception {
        System.out.println("Salvando o Fornecedor: " + fornecedor.getNome());
        /* Verifica se o fornecedor ainda não esta salvo no banco de dados. */
        if (fornecedor.getId() == null) {
            /*Salva o fornecedor no banco de dados.*/
            this.entityManager.persist(fornecedor);
        } else {
            /*Verifica se o fornecedor não esta no estado managed. */
            if (!this.entityManager.contains(fornecedor)) {
                /*Se o fornecedor não esta no estado managed verifica se ele existe na base. */
                if (entityManager.find(Fornecedor.class, fornecedor.getId()) == null) {
                    throw new Exception("Fornecedor não existe!");
                }
            }
            /*Faz uma atualização do fornecedor que estava gravado na base de dados*/
            return entityManager.merge(fornecedor);
        }

        /*Retorna o fornecedor que foi salvo,para termos o id. */
        return fornecedor;
    }

    /*
     * Método que exclui o fornecedor do banco de dados
     * 
     * @param id
     */
    public void excluir(Long id) {
        /*Consulta o fornecedor na base de dados através de seu ID. */
        Fornecedor fornecedor = entityManager.find(Fornecedor.class, id);
        System.out.println("Excluindo o fornecedor:" + fornecedor.getNome());

        /*Remove o fornecedor da base de dados. */
        entityManager.remove(fornecedor);
    }

    public Fornecedor consultarPorRazao(String razao) {
        throw new UnsupportedOperationException("Consulta por razão ainda não foi implementado.");
    }

    public Fornecedor consultarPorNome(String nome) {
        throw new UnsupportedOperationException("Consulta por nome ainda não foi implementado.");
    }

    public Fornecedor consultarPorContato(String contato) {
        throw new UnsupportedOperationException("Consulta por contato ainda não foi implementado.");
    }

    public Fornecedor consultarPorCnpj(String CNPJ) {
        throw new UnsupportedOperationException("Consulta por CNPJ ainda não foi implementado.");
    }

    public Fornecedor consultarPorCpf(String CPF) {
        throw new UnsupportedOperationException("Consulta por CPF ainda não foi implementado.");
    }

    public Fornecedor consultarPorInscricao(String inscricao) {
        throw new UnsupportedOperationException("Consulta por inscrição ainda não foi implementado.");
    }
}
    
    
    
     
     
