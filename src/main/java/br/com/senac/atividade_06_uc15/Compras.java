package br.com.senac.atividade_06_uc15;

public class Compras {

    private String codigoProduto;
    private String tituloProduto;
    private String valorUnitario;
    private String quantidade;
    private String valorTotal;
    private String cpfCliente;
    private String codigoVendedor;
    private String dataVenda;
    private String metodoPagamento;

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getTituloProduto() {
        return tituloProduto;
    }

    public void setTituloProduto(String tituloProduto) {
        this.tituloProduto = tituloProduto;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public void setValorTotal(String valorUnitario) {
        this.valorTotal = String.valueOf(Double.parseDouble(valorUnitario) * Integer.parseInt(this.quantidade));
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(String codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodo) {
        this.metodoPagamento = metodo;
    }

}
