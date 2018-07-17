package com.digitalstore.barcodescanner;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InfoActivity extends AppCompatActivity {

    DatabaseReference ref;
    String reflink;
    String imagelink;
    private EditText brandedittext;

    ImageView image;

    private String gendervalue=" ",categoryvalue=" ",stylevalue=" ",brandvalue=" ",sizevalue=" ";

    private RadioButton male,female,top,accessories,bottom,footwear,shirt,tshirt,coat,formal,casual,party,special,levis,denim,xs,s,m,l,xl,xxl ;

    private RadioGroup gender,category,category2,style,style2,brand,size;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);



        brandedittext = findViewById(R.id.inputbrand);
        image = findViewById(R.id.infoimage);

        gender = findViewById(R.id.gender);
        category = findViewById(R.id.category);
        category2 = findViewById(R.id.category2);
        style = findViewById(R.id.style);
        brand = findViewById(R.id.brand);
        size = findViewById(R.id.size);

        male = findViewById(R.id.male);
        female  = findViewById(R.id.female);
        top = findViewById(R.id.top);
        accessories = findViewById(R.id.accessories);
        bottom = findViewById(R.id.bottom);
        footwear = findViewById(R.id.footwear);
        shirt = findViewById(R.id.shirt);
        tshirt = findViewById(R.id.tshirt);
        coat = findViewById(R.id.coat);
        formal = findViewById(R.id.formal);
        casual = findViewById(R.id.casual);
        party = findViewById(R.id.party);
        special = findViewById(R.id.special);
        levis = findViewById(R.id.levis);
        denim = findViewById(R.id.denim);
        xs = findViewById(R.id.xs);
        s=  findViewById(R.id.s);
        m = findViewById(R.id.m);
        l = findViewById(R.id.l);
        xl = findViewById(R.id.xl);
        xxl = findViewById(R.id.xxl);

        // clearing all radioroups to default values
        gender.clearCheck();
        category.clearCheck();
        category2.clearCheck();
        style.clearCheck();
        size.clearCheck();
        brand.clearCheck();


        /* Extracting the sent data from MainActivity */
        reflink = getIntent().getStringExtra("link");
        ref = FirebaseDatabase.getInstance().getReference(reflink);



        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    try {

                        imagelink = dataSnapshot.child("Infoimage0").getValue().toString();

                        // using Glide library to set the link as source to imageview */
                        Glide.with(InfoActivity.this).load(imagelink).into(image);

                        gendervalue = dataSnapshot.child("Gender").getValue().toString();
                        categoryvalue = dataSnapshot.child("Category").getValue().toString();
                        stylevalue = dataSnapshot.child("Style").getValue().toString();
                        brandvalue = dataSnapshot.child("Brand").getValue().toString();
                        sizevalue = dataSnapshot.child("Size").getValue().toString();

                    }catch (Exception e){
                        e.printStackTrace();
                    }


                    try {

                        // Displaying data from firebase

                        if (gendervalue.matches("Male")) {
                            male.setTextColor(Color.WHITE);
                            male.setBackgroundResource(R.drawable.round_button_fill);
                        } else if (gendervalue.matches("Female")) {
                            female.setTextColor(Color.WHITE);
                            female.setBackgroundResource(R.drawable.round_button_fill);
                        }

                        if (categoryvalue.matches("Top")) {
                            top.setTextColor(Color.WHITE);
                            top.setBackgroundResource(R.drawable.round_button_fill);
                        } else if (categoryvalue.matches("Bottom")) {
                            bottom.setTextColor(Color.WHITE);
                            bottom.setBackgroundResource(R.drawable.round_button_fill);
                        } else if (categoryvalue.matches("Footwear")) {
                            footwear.setTextColor(Color.WHITE);
                            footwear.setBackgroundResource(R.drawable.round_button_fill);
                        } else if (categoryvalue.matches("Accessories")) {
                            accessories.setTextColor(Color.WHITE);
                            accessories.setBackgroundResource(R.drawable.round_button_fill);
                        }

                        if (stylevalue.matches("Formal")) {
                            formal.setTextColor(Color.WHITE);
                            formal.setBackgroundResource(R.drawable.round_button_fill);
                        } else if (stylevalue.matches("Casual")) {
                            casual.setTextColor(Color.WHITE);
                            casual.setBackgroundResource(R.drawable.round_button_fill);
                        } else if (stylevalue.matches("Party")) {
                            party.setTextColor(Color.WHITE);
                            party.setBackgroundResource(R.drawable.round_button_fill);
                        } else if (stylevalue.matches("Special")) {
                            special.setTextColor(Color.WHITE);
                            special.setBackgroundResource(R.drawable.round_button_fill);
                        }


                        if (brandvalue.matches("Levis")) {
                            levis.setTextColor(Color.WHITE);
                            levis.setBackgroundResource(R.drawable.round_button_fill);
                        } else if (brandvalue.matches("Denim")) {
                            denim.setTextColor(Color.WHITE);
                            denim.setBackgroundResource(R.drawable.round_button_fill);
                        }else {
                            brandedittext.setText(brandvalue);
                        }



                        if (sizevalue.matches("XS")) {
                            xs.setTextColor(Color.WHITE);
                            xs.setBackgroundResource(R.drawable.round_button_fill);
                        } else if (sizevalue.matches("S")) {
                            s.setTextColor(Color.WHITE);
                            s.setBackgroundResource(R.drawable.round_button_fill);
                        } else if (sizevalue.matches("M")) {
                            m.setTextColor(Color.WHITE);
                            m.setBackgroundResource(R.drawable.round_button_fill);
                        } else if (sizevalue.matches("L")) {
                            l.setTextColor(Color.WHITE);
                            l.setBackgroundResource(R.drawable.round_button_fill);
                        } else if (sizevalue.matches("XL")) {
                            xl.setTextColor(Color.WHITE);
                            xl.setBackgroundResource(R.drawable.round_button_fill);
                        } else if (sizevalue.matches("XXL")) {
                            xxl.setTextColor(Color.WHITE);
                            xxl.setBackgroundResource(R.drawable.round_button_fill);
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }




                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });








    }


}
