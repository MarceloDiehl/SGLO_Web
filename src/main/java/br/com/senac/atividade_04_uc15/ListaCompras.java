package br.com.senac.atividade_04_uc15;

import br.com.senac.atividade_04_uc15.gui.CadastrarFuncionarios;
import br.com.senac.atividade_04_uc15.persistencia.CatalogoProduto;
import br.com.senac.atividade_04_uc15.persistencia.ControleVendas;
import br.com.senac.atividade_04_uc15.persistencia.ControleVendasDAO;
import br.com.senac.atividade_04_uc15.persistencia.CatalogoProdutoDAO;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ListaCompras {

    private static final DateTimeFormatter FORMATO_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Declaração de variáveis
    public static ArrayList<Compras> lista = new ArrayList<Compras>();

    // Método para acessarmos a lista:
    public static ArrayList<Compras> listar() {
        return lista;
    }
    //Método para adicionar novo produto à lista:

    public static void adicionar(Compras compras) {
        lista.add(compras);
    }

    //Método para excluir produto da lista:
    public static boolean excluir(int id) {
        lista.remove(id);
        return true;
    }

    // Método para somar valor total:
    public static String getValorTotal() {
        Double valorTotal = 0.0;
        for (Compras c : lista) {
            valorTotal = valorTotal + Double.parseDouble(c.getValorTotal());
        }
        return String.valueOf(valorTotal);
    }

    // Método para limpar a lista de compras:
    public static void limparLista() {
        lista.clear();
    }

    // Método para atualizar a quantidade de um produto da lista:
    public static void atualizarQtd(int id, int qtd) {
        Compras c = lista.get(id);

        c.getCodigoProduto();

        CatalogoProduto p = new CatalogoProduto();
        CatalogoProdutoDAO catalogoProdutoDAO = new CatalogoProdutoDAO();
        p = catalogoProdutoDAO.buscarPorCodigo(c.getCodigoProduto());
        int qtdProduto = p.getQuantidade();
        boolean testeEstoque;

        if (qtdProduto < qtd) {
            JOptionPane.showMessageDialog(null, "Não há produtos suficientes no estoque! \n");
            testeEstoque = false;
        } else {
            testeEstoque = true;
            c.setQuantidade(String.valueOf(qtd));
            c.setValorTotal(c.getValorUnitario());
            JOptionPane.showMessageDialog(null, "Quantidade atualizada com sucesso! \n");
        }

    }

    // Método para incluir CPF na lista:
    public static void setCPF(String CPF) {

        for (Compras c : lista) {
            c.setCpfCliente(CPF);
        }
    }

    // Método para incluir Data na lista:
    public static void setData(String Data) {

        for (Compras c : lista) {
            c.setDataVenda(Data);
        }
    }

    // Método para incluir ID do vendedor na lista:
    public static void setIdVendedor(String Id) {

        for (Compras c : lista) {
            c.setCodigoVendedor(Id);
        }
    }

    // Método para incluir método de pagamento na lista:
    public static void setMetodoPagamento(String metodo) {

        for (Compras c : lista) {
            c.setMetodoPagamento(metodo);
        }
    }

    // Método para salvar a lista na classe Vendas na lista:
    public static void concluirVendaItem() {
        for (Compras c : lista) {

            String cpf = c.getCpfCliente();
            String codigoProduto = c.getCodigoProduto();
            String titulo = c.getTituloProduto();
            String valorUnitario = c.getValorUnitario();
            String quantidade = c.getQuantidade();
            String valorTotal = c.getValorTotal();
            String codigoVendedor = c.getCodigoVendedor();
            String dataVenda = c.getDataVenda();
            String metodoPagamento = c.getMetodoPagamento();

            ControleVendas cv = new ControleVendas();
            cv.setCpfNota(cpf);
            cv.setCodProduto(codigoProduto);
            cv.setTituloProduto(titulo);
            cv.setValorUnitario(Double.parseDouble(valorUnitario));
            cv.setQuantidade(Integer.parseInt(quantidade));
            cv.setValorTotal(Double.parseDouble(valorTotal));
            cv.setIdVendedor(Integer.parseInt(codigoVendedor));
            cv.setDataVenda(CadastrarFuncionarios.convertLocalDate(dataVenda));
            cv.setIdMetodoPagamento(Integer.parseInt(metodoPagamento));

            CatalogoProduto p = new CatalogoProduto();
            CatalogoProdutoDAO catalogoProdutoDAO = new CatalogoProdutoDAO();

            p = catalogoProdutoDAO.buscarPorCodigo(codigoProduto);
            int qtd = p.getQuantidade();
            int atualizarQtd = qtd - (Integer.parseInt(quantidade));
            p.setQuantidade(atualizarQtd);
            catalogoProdutoDAO.Atualizar(p);

            ControleVendasDAO controleVendasDAO = new ControleVendasDAO();
            controleVendasDAO.Cadastrar(cv);

        }
    }
// Método para buscar a posição de um array:

    public static int retornarPosicao(String codigoProduto) {
        for (Compras c : lista) {
            if (c.getCodigoProduto().equals(codigoProduto)) {
                int indice = lista.indexOf(c);
                return indice;
            }
        }
        return -1;
    }
}
