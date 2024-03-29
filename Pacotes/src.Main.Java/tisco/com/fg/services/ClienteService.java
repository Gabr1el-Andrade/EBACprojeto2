package tisco.com.fg.services;

import tisco.com.fg.dao.ClienteDAO;
import tisco.com.fg.dao.IClienteDAO;
import tisco.com.fg.doMain.Cliente;

public class ClienteService implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO){
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Boolean salvar(Cliente cliente) {
    return clienteDAO.salvar(cliente);
    }

    @Override
    public Cliente buscarPorCpf(Long cpf) {
        return clienteDAO.buscarPorCpf(cpf);
    }

    @Override
    public void excluir(Long cpf) {
    clienteDAO.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) {
    clienteDAO.alterar(cliente);
    }
}
