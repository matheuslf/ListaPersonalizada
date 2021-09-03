package desenvolve.unesc.listapersonalizada;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import desenvolve.unesc.listapersonalizada.adapter.ProdutoAdapter;
import desenvolve.unesc.listapersonalizada.adapter.ProdutoModel;

public class ProdutosActivity extends AppCompatActivity {

    private ListView listaProdutos;
    private ArrayList<ProdutoModel> lst = new ArrayList<ProdutoModel>();
    private Button btnAdicionar;
    private ProdutoAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lst.add(new ProdutoModel("666666", "Carne de Porco", "666666"));
                adapter.notifyDataSetChanged();
            }
        });

        listaProdutos = findViewById(R.id.listaProdutos);
        listaProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent();
                it.putExtra("produto_escolhido", lst.get(position).getNomeProduto());
                setResult(RESULT_OK, it);
                finish();
            }
        });

        lst.add(new ProdutoModel("455182", "Alcatra", "789456123"));
        lst.add(new ProdutoModel("37108466", "Picanha", "123456789"));
        lst.add(new ProdutoModel("159753", "Acem", "741852963"));
        lst.add(new ProdutoModel("852963", "Maminha", "123456777"));
        lst.add(new ProdutoModel("357159", "Fraldinha", "74158754"));
        lst.add(new ProdutoModel("456789", "Carvão", "965896589"));
        lst.add(new ProdutoModel("123789", "Alcool", "4521452145"));
        lst.add(new ProdutoModel("789523", "Espeto", "5632563256"));
        lst.add(new ProdutoModel("159852", "Farofa", "852852852"));

        adapter = new ProdutoAdapter(ProdutosActivity.this, lst);
        listaProdutos.setAdapter(adapter);

    }
}
