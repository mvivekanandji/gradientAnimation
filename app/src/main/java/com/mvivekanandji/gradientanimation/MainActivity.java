package com.mvivekanandji.gradientanimation;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.mvivekanandji.gradientanimation.model.Gradient;
import com.mvivekanandji.gradientanimation.model.GradientItem;

/**
 * Copyright 2019 Vivekanand Mishra.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * Created by Vivekanand Mishra on 10/12/19.
 *
 * @author vivekanand
 * @version 1.0
 * <p>
 * Main activity class of demo
 */
public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;
    ImageView imageViewCustom;
    ImageView imageViewJava;
    Button buttonStart;
    Button buttonStop;
    Button buttonToggle;
    Button buttonReset;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

//        final GradientAnimation gradientAnimationLayout = new GradientAnimation.Builder()
//                .setViewGroup(scrollView)
//                .setBackgroundDrawable(R.drawable.anim)
//                .setDuration(2000)
//                .build();
//
//        gradientAnimationLayout.startAnimation();

        String[] strings = new String[]{"#000000","#aaaaaa","ffffff","#eeeeee"};

        GradientAnimation.Builder builderButton = new GradientAnimation.Builder()
                .setView(buttonStart)
//                .addGradient(Gradient.getInbuiltGradient("black"))
//                .addGradient(Gradient.getInbuiltGradient("white"))
//                .addGradient(new Gradient(new int[]{22,22,22,22},Gradient.Orientation.BOTTOM_TOP))
                .addGradientItem(new GradientItem(new Gradient("#000000","#222222","#aaddff"),2000))
                .addGradientItem(new GradientItem(new Gradient(new String[]{"#000000","#008577","#eeeeee","#D81B60","#ffffff"}),2000))
                .addGradientItem(new GradientItem(Gradient.getInbuiltGradient("white"),2000))
//                .setEnterDuration(1500)
//                .setExitDuration(1500)
//                .setDuration(1000)
                ;

        builderButton.build().startAnimation();


//        buttonStart.setOnClickListener(v -> gradientAnimationLayout.startAnimation());
//        buttonStop.setOnClickListener(v -> gradientAnimationLayout.stopAnimation());
//        buttonReset.setOnClickListener( v -> gradientAnimationLayout.resetAnimation());
//        buttonToggle.setOnClickListener(v -> gradientAnimationLayout.toggleAnimation());
    }


    private void initViews() {
        scrollView = findViewById(R.id.scroll);
        imageViewCustom = findViewById(R.id.imageViewCustom);
        imageViewJava = findViewById(R.id.imageViewJava);
        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        buttonToggle = findViewById(R.id.buttonToggle);
        buttonReset = findViewById(R.id.buttonReset);
        seekBar = findViewById(R.id.seekBar);
    }
}
