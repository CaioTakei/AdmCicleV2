/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admciclev2.ejb;

import admciclev2.modelo.Fornecedor;
import javax.ejb.Remote;

/**
 *interface remota do EJB do fornecedor.
 * 
 * @author caio.correa
 */
@Remote
public interface FornecedorRemote {

    public Fornecedor salvar(Fornecedor fornecedor);

    public void excluir(Long id);

    public Fornecedor consultarPorRazao(String razao);

    public Fornecedor consultarPorNome(String nome);

    public Fornecedor consultarPorContato(String contato);

    public Fornecedor consultarPorCnpj(String cnpj);

    public Fornecedor consultarPorCpf(String cpf);

    public Fornecedor consultarPorInscricao(String inscricao);
}
