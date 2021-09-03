package desenvolve.unesc.listapersonalizada.adapter;

public class ProdutoModel {

    private String codigoProduto;
    private String nomeProduto;
    private String barrasProduto;

    public ProdutoModel(final String codigoProduto, final String nomeProduto, final String barrasProduto) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.barrasProduto = barrasProduto;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getBarrasProduto() {
        return barrasProduto;
    }
}
