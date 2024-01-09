package tisco.com.fg.dao.test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tisco.com.fg.dao.IClienteDAO;
import tisco.com.fg.doMain.Cliente;

public class ClienteDAOTest {
    private IClienteDAO clienteDAO;

    private Cliente cliente;

    public ClienteDAOTest(){
        clienteDAO = new ClienteDAOMock();
    }
    @Before
    public void init(){
        cliente = new Cliente();
        cliente.setCpf(1234567891L);
        cliente.setNome("Gabriel");
        cliente.setNum(979);
        cliente.setTel(97997979797l);
        cliente.setCidde("manaus");
        cliente.setEst("AM");
        cliente.setEnd("Rua tal");
        clienteDAO.salvar(cliente);
    }
    @Test
    public void pesquisarCliente(){
        Cliente clienteconsultado = clienteDAO.buscarPorCpf(cliente.getCpf());

        Assert.assertNotNull(clienteconsultado);
    }
    @Test
    public void salvarCliente(){
        Boolean retorno = clienteDAO.salvar(cliente);
        Assert.assertTrue(retorno);
    }
    @Test
    public void excluirCliente(){
        clienteDAO.excluir(cliente.getCpf());
    }
    @Test
    public void alterarCliente(){
        cliente.setNome("F Gabriel");
        clienteDAO.alterar(cliente);
        Assert.assertEquals("F Gabriel", cliente.getNome());
    }
}




