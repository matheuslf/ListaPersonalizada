package desenvolve.unesc.listapersonalizada;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtProduto;
    private Button btnBuscarProduto;
    private final int CONSULTA_PRODUTO = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtProduto = findViewById(R.id.edtProduto);
        btnBuscarProduto = findViewById(R.id.btnBuscarProduto);
        btnBuscarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, ProdutosActivity.class), CONSULTA_PRODUTO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CONSULTA_PRODUTO && resultCode == RESULT_OK) {
            edtProduto.setText(data.getStringExtra("produto_escolhido"));
        }
    }
}