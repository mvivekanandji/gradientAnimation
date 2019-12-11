package com.mvivekanandji.gradientanimation.model;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * Created by Vivekanand Mishra on 09/12/19.
 *
 * @author vivekanand
 * @version 1.0
 * <p>
 * A model class representing a gradient.
 * This class represents a simple gradient.
 */
public class Gradient {

    /**
     * enum for gradient angle (multiple of 45 degrees)
     */
    public enum Orientation {
        /**
         * draw the gradient from the top to the bottom (270 degree)
         */
        TOP_BOTTOM,
        /**
         * draw the gradient from the top-right to the bottom-left (225 degree)
         */
        TR_BL,
        /**
         * draw the gradient from the right to the left (180 degree)
         */
        RIGHT_LEFT,
        /**
         * draw the gradient from the bottom-right to the top-left (135 degree)
         */
        BR_TL,
        /**
         * draw the gradient from the bottom to the top (90 degree)
         */
        BOTTOM_TOP,
        /**
         * draw the gradient from the bottom-left to the top-right (45 degree)
         */
        BL_TR,
        /**
         * draw the gradient from the left to the right (0 degree)
         */
        LEFT_RIGHT,
        /**
         * draw the gradient from the top-left to the bottom-right (315 degree)
         */
        TL_BR,
    }

    private float[] radii; // TODO: 11-12-2019 implement radius and radii
    private int[] colors; // TODO: 11-12-2019 implement colors[]( possibly chnage entire class)
    private Orientation orientation;

    /**
     * Method to get GradientDrawable.Orientation value corresponding to Gradient.Orientation
     *
     * @param value Gradient.Orientation
     * @return GradientDrawable.Orientation
     */
    public static GradientDrawable.Orientation getDrawableOrientation(Orientation value) {
        return GradientDrawable.Orientation.values()[value.ordinal()];
    }

    /**
     * Constructor
     *
     * @param colors integer array of color codes
     * @param orientation Gradient.Orientation
     */
    public Gradient(int[] colors, Orientation orientation){
        this.colors = colors;
        this.orientation = orientation;
    }

    /**
     * Constructor
     *
     * @param colors integer array of color codes
     */
    public Gradient(int[] colors){
        this(colors,Orientation.BOTTOM_TOP);
    }

    /**
     * Constructor
     *
     * @param colors string array of color codes
     * @param orientation Gradient.Orientation
     */
    public Gradient(String[] colors, Orientation orientation){
        this.colors = new int[colors.length];
        this.orientation = orientation;

        for(int i=0; i<colors.length; i++)
            this.colors[i] = Color.parseColor(colors[i]);
    }

    /**
     * Constructor
     *
     * @param colors string array of color codes
     */
    public Gradient(String[] colors){
        this(colors, Orientation.BOTTOM_TOP);
    }

    /**
     * Constructor
     *
     * @param startColor  integer color code
     * @param centerColor integer color code
     * @param endColor    integer color code
     * @param orientation Gradient.Orientation
     */
    public Gradient(int startColor, int centerColor, int endColor, Orientation orientation) {
        this(new int[]{startColor,centerColor,endColor},orientation);
    }

    /**
     * Constructor
     *
     * @param startColor integer color code
     * @param centerColor integer color code
     * @param endColor integer color code
     */
    public Gradient(int startColor, int centerColor, int endColor){
        this(startColor, centerColor, endColor, Orientation.BOTTOM_TOP);
    }

    /**
     * Constructor
     *
     * @param startColor  String color code
     * @param centerColor String color code
     * @param endColor    String color code
     * @param orientation Gradient.Orientation
     */
    public Gradient(String startColor, String centerColor, String endColor, Orientation orientation) {
       this(new String[]{startColor,centerColor,endColor},orientation);
    }

    /**
     * Constructor
     *
     * @param startColor  String color code
     * @param centerColor String color code
     * @param endColor    String color code
     */
    public Gradient(String startColor, String centerColor, String endColor){
        this(startColor, centerColor, endColor, Orientation.BOTTOM_TOP);
    }

    /**
     * Constructor
     *
     * @param startColor  integer color code
     * @param endColor    integer color code
     * @param orientation Gradient.Orientation
     */
    public Gradient(int startColor, int endColor, Orientation orientation) {
        this(new int[]{startColor,endColor},orientation);
    }

    /**
     * Constructor
     *
     * @param startColor  integer color code
     * @param endColor    integer color code
     */
    public Gradient(int startColor, int endColor){
        this(startColor,endColor,Orientation.BOTTOM_TOP);
    }

    /**
     * Constructor
     *
     * @param startColor  String color code
     * @param endColor    String color code
     * @param orientation Gradient.Orientation
     */
    public Gradient(String startColor, String endColor, Orientation orientation) {
        this(new String[]{startColor,endColor},orientation);
    }

    /**
     * Constructor
     *
     * @param startColor  String color code
     * @param endColor    String color code
     */
    public Gradient(String startColor, String endColor){
        this(startColor,endColor, Orientation.BOTTOM_TOP);
    }


    /**
     * Getter - to get
     *
     * @return
     */
    public float[] getRadii() {
        return radii;
    }

    /**
     * Setter - to set
     *
     * @param radii
     * @return
     */
    public Gradient setRadii(float[] radii) {
        this.radii = radii;
        return this;
    }

    /**
     * Getter - to get colors array
     *
     * @return
     */
    public int[] getColors() {
        return colors;
    }

    /**
     * Setter - to set colors array
     *
     * @param colors
     * @return
     */
    public Gradient setColors(int[] colors) {
        this.colors = colors;
        return this;
    }

    /**
     * Getter - to get Gradient.Orientation
     *
     * @return Gradient.Orientation
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Setter - to set Gradient.Orientation
     *
     * @param orientation Gradient.Orientation
     * @return this object
     */
    public Gradient setOrientation(Orientation orientation) {
        this.orientation = orientation;
        return this;
    }


    // TODO: 11-12-2019 implement this getInbuiltGradient(String name, int[] colors)
    /**
     * Method to get inbuilt gradients.
     *
     * @param name gradient name see https://webgradients.com/.
     *             "name" can be in any case, with or without space, with or without _"
     *             (eg. "warmFlame", "warmflame", warm flame", "Warm Flame", "warm flame",
     *             "WARM FLAME","WARMFLAME, "WARM_FLAME, "warm_flame" etc all are allowed)
     * @return new Gradient object
     */
    public static Gradient getInbuiltGradient(@NonNull String name) {
        name = name.replaceAll("\\s", "");
        name = name.replaceAll("_", "");


        switch (name.toLowerCase()) {
            case "black":
                return new Gradient("#000000","#000000",Orientation.BOTTOM_TOP);
            case "white":
                return new Gradient("#ffffff","#ffffff",Orientation.BOTTOM_TOP);
            case "warmflame":
                return new Gradient("#ff9a9e", "#fad0c4", Orientation.BOTTOM_TOP);
            case "nightfade":
                return new Gradient("#a18cd1", "#fbc2eb", Orientation.BOTTOM_TOP);
            default:
                return new Gradient("#ff9a9e", "#fad0c7", Orientation.BOTTOM_TOP);
        }
    }
}
