package tisco.com.fg.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tisco.com.fg.dao.IClienteDAO;
import tisco.com.fg.dao.test.ClienteDAOMock;
import tisco.com.fg.doMain.Cliente;
import tisco.com.fg.services.ClienteService;
import tisco.com.fg.services.IClienteService;

public class ClienteServiceTest {
    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest(){
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);}

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
        }

    @Test
    public void pesquisarCliente(){
        Cliente clienteconsultado = clienteService.buscarPorCpf(cliente.getCpf());
        Assert.assertNotNull(clienteconsultado);
    }
    @Test
    public void salvarCliente(){
       Boolean retorno = clienteService.salvar(cliente);
       Assert.assertTrue(retorno);
    }
    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }
    @Test
    public void alterarCliente(){
        cliente.setNome("F Gabriel");
    clienteService.alterar(cliente);
    Assert.assertEquals("F Gabriel", cliente.getNome());
    }
}
