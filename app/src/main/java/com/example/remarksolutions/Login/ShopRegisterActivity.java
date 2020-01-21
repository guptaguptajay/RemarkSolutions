package com.example.remarksolutions.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.remarksolutions.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ShopRegisterActivity extends AppCompatActivity {
    FirebaseFirestore firebaseFirestore;
    Map<String,String> shopDetail=new HashMap<>();
    EditText name,desc,add,phone;
    Spinner category;
    Button submit;
    ShopCategories sc= new ShopCategories();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_register);



        firebaseFirestore=FirebaseFirestore.getInstance();
        name=findViewById(R.id.etShopRegisterShopName);
        desc=findViewById(R.id.etShopRegisterDescription);
        add=findViewById(R.id.etShopRegisterAddress);
        phone=findViewById(R.id.etShopRegisterPhone);
        category=findViewById(R.id.spShopRegisterShopCategory);
        submit=findViewById(R.id.btnShopRegisterSubmit);

        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,sc.getA());
        category.setAdapter(arrayAdapter);
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                shopDetail.put("category",sc.getA()[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                shopDetail.put("name",name.getText().toString());
                shopDetail.put("description",desc.getText().toString());
                shopDetail.put("address",add.getText().toString());
                shopDetail.put("phone",phone.getText().toString());





                firebaseFirestore.collection("SHOP").document(phone.getText().toString()).set(shopDetail).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ShopRegisterActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ShopRegisterActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}
