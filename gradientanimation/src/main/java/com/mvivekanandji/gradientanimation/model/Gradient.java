package com.mvivekanandji.gradientanimation.model;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

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
        /** draw the gradient from the top to the bottom (270 degree)*/
        TOP_BOTTOM,
        /** draw the gradient from the top-right to the bottom-left (225 degree)*/
        TR_BL,
        /** draw the gradient from the right to the left (180 degree)*/
        RIGHT_LEFT,
        /** draw the gradient from the bottom-right to the top-left (135 degree)*/
        BR_TL,
        /** draw the gradient from the bottom to the top (90 degree)*/
        BOTTOM_TOP,
        /** draw the gradient from the bottom-left to the top-right (45 degree)*/
        BL_TR,
        /** draw the gradient from the left to the right (0 degree)*/
        LEFT_RIGHT,
        /** draw the gradient from the top-left to the bottom-right (315 degree)*/
        TL_BR,
    }

    private int startColor;
    private int centerColor = -1;
    private int endColor;
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
     * @param startColor integer color code
     * @param centerColor integer color code
     * @param endColor integer color code
     * @param orientation Gradient.Orientation
     */
    public Gradient(int startColor, int centerColor, int endColor, Orientation orientation) {
        this.startColor = startColor;
        this.centerColor = centerColor;
        this.endColor = endColor;
        this.orientation = orientation;
    }

    /**
     * Constructor
     *
     * @param startColor String color code
     * @param centerColor String color code
     * @param endColor String color code
     * @param orientation Gradient.Orientation
     */
    public Gradient(String startColor, String centerColor, String endColor, Orientation orientation) {
        this(Color.parseColor(startColor)
                ,Color.parseColor(centerColor)
                ,Color.parseColor(endColor)
                ,orientation);
    }

    /**
     * Constructor
     *
     * @param startColor integer color code
     * @param endColor integer color code
     * @param orientation Gradient.Orientation
     */
    public Gradient(int startColor, int endColor, Orientation orientation) {
        this.startColor = startColor;
        this.endColor = endColor;
        this.orientation = orientation;
    }

    /**
     * Constructor
     *
     * @param startColor String color code
     * @param endColor String color code
     * @param orientation Gradient.Orientation
     */
    public Gradient(String startColor, String endColor, Orientation orientation) {
        this(Color.parseColor(startColor)
                ,Color.parseColor(endColor)
                ,orientation);
    }

    /**
     * Setter - to set start color of gradient
     *
     * @param startColor integer color code
     * @return this object
     */
    public Gradient setStartColor(int startColor) {
        this.startColor = startColor;
        return this;
    }


    /**
     * Setter - to set start color of gradient
     *
     * @param startColor String color code
     * @return this object
     */
    public Gradient setStartColor(String startColor) {
       return setStartColor(Color.parseColor(startColor));
    }

    /**
     * Setter - to set center color of gradient
     *
     * @param centerColor integer color code
     * @return this object
     */
    public Gradient setCenterColor(int centerColor) {
        this.centerColor = centerColor;
        return this;
    }

    /**
     * Setter - to set center color of gradient
     *
     * @param centerColor String color code
     * @return this object
     */
    public Gradient setCenterColor(String centerColor) {
        return setStartColor(Color.parseColor(centerColor));
    }

    /**
     * Setter - to set end color of gradient
     *
     * @param endColor integer color code
     * @return this object
     */
    public Gradient setEndColor(int endColor) {
        this.endColor = endColor;
        return this;
    }

    /**
     * Setter - to set end color of gradient
     *
     * @param endColor String color code
     * @return this object
     */
    public Gradient setEndColor(String endColor) {
        return setStartColor(Color.parseColor(endColor));
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

    /**
     * Getter - to get start color of gradient
     *
     * @return int start color
     */
    public int getStartColor() {
        return startColor;
    }

    /**
     * Getter - to get center color of gradient
     *
     * @return int center color
     */
    public int getCenterColor() {
        return centerColor;
    }

    /**
     * Getter - to get end color of gradient
     *
     * @return int end color
     */
    public int getEndColor() {
        return endColor;
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
     * Method to get inbuilt gradients.
     *
     * @param name gradient name. "name" can be in any case, with or without space, with or without _"
     *             (eg. "warmFlame", "warmflame", warm flame", "Warm Flame", "warm flame",
     *             "WARM FLAME","WARMFLAME, "WARM_FLAME, "warm_flame" etc all are allowed)
     * @return new Gradient object
     * see https://webgradients.com/
     */
    public static Gradient getInbuiltGradient(String name){
        name = name.replaceAll("\\s", "");
        name = name.replaceAll("_", "");

        switch (name.toLowerCase()){
            case "warmflame": return new Gradient("#ff9a9e","#fad0c4",Orientation.BOTTOM_TOP);
            default: return  new Gradient("#ff9a9e","#fad0c7",Orientation.BOTTOM_TOP);
        }

    }
}
