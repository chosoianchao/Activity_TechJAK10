package com.dcht69.lesson8uik10;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        LinearLayout lnAnimail = findViewById(R.id.ln_animal);
        lnAnimail.removeAllViews();

        try {
            String[] listAnimalName = getAssets().list("photo");
            for (String fileName : listAnimalName) {
                View itemAnimalView = LayoutInflater.from(this).inflate(R.layout.item_animal, null);
                ImageView ivAnimal = itemAnimalView.findViewById(R.id.iv_animal);

                ivAnimal.setTag(fileName);
                ivAnimal.setOnClickListener(this);

                TextView tvAnimal = itemAnimalView.findViewById(R.id.tv_animal);

                String animalName = fileName.substring(0, fileName.indexOf("."));

                tvAnimal.setText(animalName);
                setPhoto(ivAnimal, fileName);

                lnAnimail.addView(itemAnimalView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        ImageView ivAnimal1 = findViewById(R.id.iv_animal1);
//        ImageView ivAnimal2 = findViewById(R.id.iv_animal2);
//        ImageView ivAnimal3 = findViewById(R.id.iv_animal3);
//
//        setPhoto(ivAnimal1,"rabbit.jpg");
//        setPhoto(ivAnimal2,"sheep.jpg");
//        setPhoto(ivAnimal3,"tiger.jpg");

//        ivAnimal1.setImageResource(R.drawable.bg_sheep);
//        ivAnimal2.setImageResource(R.drawable.bg_rabit);
//        ivAnimal3.setImageResource(R.drawable.bg_tiger);

//        Drawable   anmial1 = ContextCompat.getDrawable(this,R.drawable.bg_rabit);
//        Drawable   anmial2 = ContextCompat.getDrawable(this,R.drawable.bg_sheep);
//        Drawable   anmial3 = ContextCompat.getDrawable(this,R.drawable.bg_tiger);
//
//        ivAnimal1.setImageDrawable(anmial1);
//        ivAnimal2.setImageDrawable(anmial2);
//        ivAnimal3.setImageDrawable(anmial3);
    }

    private void setPhoto(ImageView ivPhoto, String photoName) throws Exception {

        InputStream streamAnimal1 = getAssets().open("photo/" + photoName);
        Glide.with(this).load(BitmapFactory.decodeStream(streamAnimal1)).into(ivPhoto);

    }

    @Override
    public void onClick(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_grow_fade_in_from_bottom));
        if (view instanceof ImageView) {
            domAimaClick((String) view.getTag());
        }

    }

    private void domAimaClick(String fileName) {
        String animalName = fileName.substring(0, fileName.indexOf("."));
        Toast.makeText(this, animalName, Toast.LENGTH_LONG).show();
    }
}
