package desenvolve.unesc.listapersonalizada.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import desenvolve.unesc.listapersonalizada.R;

public class ProdutoAdapter extends BaseAdapter {

    private Activity activity;
    private List<ProdutoModel> listaProdutos;

    public ProdutoAdapter(final Activity activity, final List<ProdutoModel> listaProdutos) {
        this.activity = activity;
        this.listaProdutos = listaProdutos;
    }

    @Override
    public int getCount() {
        return listaProdutos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaProdutos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = activity.getLayoutInflater().inflate(R.layout.item_lista_produto, parent, false);
        }

        TextView codigoProduto = convertView.findViewById(R.id.codigoProduto);
        codigoProduto.setText("Código: "+((ProdutoModel)getItem(position)).getCodigoProduto());

        TextView nomeProduto = convertView.findViewById(R.id.nomeProduto);
        nomeProduto.setText("Nome: "+((ProdutoModel)getItem(position)).getNomeProduto());

        TextView barrasProduto = convertView.findViewById(R.id.barrasProduto);
        barrasProduto.setText("Código de Barras: "+((ProdutoModel)getItem(position)).getBarrasProduto());

        TextView estoqueProduto = convertView.findViewById(R.id.estoqueProduto);

        LinearLayout btnEstoque = convertView.findViewById(R.id.btnEstoque);
        btnEstoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] partes = estoqueProduto.getText().toString().split(":");
                int estoque = Integer.parseInt(partes[1].trim());
                estoqueProduto.setText("Estoque: "+(estoque + 1));

            }
        });

        return convertView;
    }
}
