package com.mvivekanandji.gradientanimation.model;

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
 * A model class representing a GradientItem.
 * This class encapsulates Gradient object and animation duration
 */
public class GradientItem {

    private int duration;
    private Gradient gradient;

    /**
     * Constructor
     *
     * @param gradient Gradient object
     * @param duration animation duration
     * @see Gradient
     */
    public GradientItem(Gradient gradient, int duration) {
        this.duration = duration;
        this.gradient = gradient;
    }

    /**
     * Getter
     *
     * @return {@code int} animation duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Getter
     *
     * @return {@code Gradient} Gradient object
     * @see Gradient
     */
    public Gradient getGradient() {
        return gradient;
    }
}
