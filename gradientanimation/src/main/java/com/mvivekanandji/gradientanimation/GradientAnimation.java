package com.mvivekanandji.gradientanimation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

import com.mvivekanandji.gradientanimation.model.Gradient;
import com.mvivekanandji.gradientanimation.model.GradientItem;

import java.util.ArrayList;
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
 * Created by Vivekanand Mishra on 08/12/19.
 *
 * @author vivekanand
 * @version 1.0
 * <p>
 * Class to create animation drawable
 */
public class GradientAnimation {

    //region member variables
    private ViewGroup viewGroup;
    private View view;
    private int backgroundDrawable;
    private int duration;
    private int enterDuration;
    private int exitDuration;
    private int alpha;
    private boolean loop;
    private int loopCount;
    private int gradientCount;
    private AnimationDrawable animationDrawable;
    private List<Gradient> gradientList;
    private List<GradientItem> gradientItemList;
    //endregion

    /**
     * Constructor
     *
     * @param builder GradientAnimation.Builder
     */
    private GradientAnimation(@NonNull Builder builder) {
        initMemberVariables(builder);

        if (!gradientList.isEmpty() || !gradientItemList.isEmpty()) {

            checkBackgroundDrawable();
            initGradientItemList();
            initGradientList();
            initViewBackground();

        } else {
            initViewBackgroundResource();
        }

        initDurations();
        animationDrawable.setAlpha(alpha);
    }

    /**
     * Method to set alpha of the animation
     *
     * @param alpha integer in the range 0 to 255
     */
    public void setAlpha(@IntRange(from = 0, to = 255) final int alpha) {
        animationDrawable.setAlpha(alpha);
    }

    /**
     * Method to start animation
     */
    public void startAnimation() {
        if (!animationDrawable.isRunning())
            animationDrawable.start();

        if (!loop) animationDrawable.setOneShot(true);

        else if (loopCount > 0) {

            int animCount = gradientList.size() + gradientItemList.size();

            if (animCount > 0)
                gradientCount = animCount;

            long loopTime = new Long(loopCount) * gradientCount * (enterDuration + exitDuration);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    stopAnimation();
                }
            }, loopTime);
        }
    }

    /**
     * Method to stop the running animation
     */
    public void stopAnimation() {
        if (animationDrawable.isRunning())
            animationDrawable.stop();
    }

    /**
     * Method to toggle animation
     * If animation is running itr will stop
     * else if animation not running/stopped it will start running
     */
    public void toggleAnimation() {
        if (animationDrawable.isRunning())
            animationDrawable.stop();
        else
            startAnimation();
    }

    /**
     * Method to reset animation
     */
    public void resetAnimation() {
        stopAnimation();
        startAnimation();
    }


    /**
     * Builder class
     */
    public static class Builder {
        private ViewGroup viewGroup;
        private View view;
        private int backgroundDrawable;
        private int duration;
        private int enterDuration;
        private int exitDuration;
        private int alpha;
        private boolean loop;
        private int loopCount;
        private int gradientCount;
        List<Gradient> gradientList;
        List<GradientItem> gradientItemList;

        /**
         * Constructor
         */
        public Builder() {
            duration = -1;
            enterDuration = 1000;
            exitDuration = 1000;
            alpha = 255;
            loop = true;
            loopCount = -1;
            gradientCount = 2;
            gradientList = new ArrayList<>();
            gradientItemList = new ArrayList<>();
        }

        /**
         * Method to add new GradientItem.
         *
         * @param gradientItem GradientItem
         * @return this object
         * @see GradientItem
         */
        public Builder addGradientItem(@NonNull GradientItem gradientItem) {
            this.gradientItemList.add(gradientItem);
            return this;
        }

        /**
         * Method to set GradientItem.
         * Method will remove all exiting GradientItem and add just the given GradientItem.
         *
         * @param gradientItem GradientItem
         * @return this object
         * @see GradientItem
         */
        public Builder setGradientItem(@NonNull GradientItem gradientItem) {
            this.gradientItemList.clear();
            return addGradientItem(gradientItem);
        }

        /**
         * Method to add new GradientItem list.
         *
         * @param gradientItems List<GradientItem>
         * @return this object
         * @see GradientItem
         */
        public Builder addGradientItems(@NonNull List<GradientItem> gradientItems) {
            this.gradientItemList.addAll(gradientItems);
            return this;
        }

        /**
         * Method to set GradientItem list.
         * Method will remove all exiting GradientItem and add just the given GradientItem list.
         *
         * @param gradientItems List<GradientItem>
         * @return this object
         * @see GradientItem
         */
        public Builder setGradientItems(@NonNull List<GradientItem> gradientItems) {
            this.gradientItemList.clear();
            return addGradientItems(gradientItems);
        }

        /**
         * Method to remove particular GradientItem.
         *
         * @param gradientItem GradientItem
         * @return this object
         */
        public Builder removeGradientItem(@NonNull GradientItem gradientItem) {
            this.gradientItemList.remove(gradientItem);
            return this;
        }

        /**
         * Method to remove list of GradientItem.
         *
         * @param gradientItems List<GradientItem>
         * @return this object
         */
        public Builder removeGradientItems(@NonNull List<GradientItem> gradientItems) {
            this.gradientItemList.removeAll(gradientItems);
            return this;
        }

        /**
         * Method to remove all GradientItem.
         *
         * @return this object
         */
        public Builder clearGradientItems() {
            this.gradientItemList.clear();
            return this;
        }

        /**
         * Method to add new Gradient.
         *
         * @param gradient Gradient
         * @return this object
         * @see Gradient
         */
        public Builder addGradient(@NonNull Gradient gradient) {
            this.gradientList.add(gradient);
            return this;
        }

        /**
         * Method to set Gradient.
         * Method will remove all exiting Gradient and add just the given Gradient.
         *
         * @param gradient Gradient
         * @return this object
         * @see Gradient
         */
        public Builder setGradient(@NonNull Gradient gradient) {
            this.gradientList.clear();
            return addGradient(gradient);
        }

        /**
         * Method to add new Gradient list.
         *
         * @param gradients List<Gradient>
         * @return this object
         * @see Gradient
         */
        public Builder addGradients(@NonNull List<Gradient> gradients) {
            this.gradientList.addAll(gradients);
            return this;
        }

        /**
         * Method to set Gradient list.
         * Method will remove all exiting GradientI and add just the given Gradient list.
         *
         * @param gradients List<Gradient>
         * @return this object
         * @see Gradient
         */
        public Builder setGradients(@NonNull List<Gradient> gradients) {
            this.gradientList.clear();
            return addGradients(gradients);
        }

        /**
         * Method to remove particular Gradient.
         *
         * @param gradient Gradient
         * @return this object
         */
        public Builder removeGradient(@NonNull Gradient gradient) {
            this.gradientList.remove(gradient);
            return this;
        }

        /**
         * Method to remove list of Gradient.
         *
         * @param gradients List<Gradient>
         * @return this object
         */
        public Builder removeGradients(@NonNull List<Gradient> gradients) {
            this.gradientList.removeAll(gradients);
            return this;
        }

        /**
         * Method to remove all Gradient.
         *
         * @return this object
         */
        public Builder clearGradients() {
            this.gradientList.clear();
            return this;
        }

        public Builder setViewGroup(@NonNull ViewGroup viewGroup) {
            this.viewGroup = viewGroup;
            return this;
        }

        public Builder setView(@NonNull View view) {
            this.view = view;
            return this;
        }

        public Builder setBackgroundDrawable(@NonNull @DrawableRes int backgroundDrawable) {
            this.backgroundDrawable = backgroundDrawable;
            return this;
        }

        public Builder setDuration(@IntRange(from = 0, to = Integer.MAX_VALUE) int duration) {
            this.duration = duration;
            return this;
        }

        public Builder setEnterDuration(@IntRange(from = 0, to = Integer.MAX_VALUE) int enterDuration) {
            this.enterDuration = enterDuration;
            return this;
        }

        public Builder setExitDuration(@IntRange(from = 0, to = Integer.MAX_VALUE) int exitDuration) {
            this.exitDuration = exitDuration;
            return this;
        }

        public Builder setAlpha(@IntRange(from = 0, to = 255) final int alpha) {
            this.alpha = alpha;
            return this;
        }

        public Builder shouldLoop(boolean loop) {
            this.loop = loop;
            return this;
        }

        public Builder setLoopCount(@IntRange(from = 0, to = Integer.MAX_VALUE) final int loopCount) {
            this.loopCount = loopCount;
            return this;
        }

        public Builder setGradientCount(@IntRange(from = 0, to = Integer.MAX_VALUE) int gradientCount) {
            this.gradientCount = gradientCount;
            return this;
        }

        /**
         * Method to get new GradientAnimation object
         *
         * @return GradientAnimation object
         */
        public GradientAnimation build() {
            return new GradientAnimation(this);
        }
    }

    //region private methods

    /**
     * Method to initialize member variables
     *
     * @param builder GradientAnimation.Builder
     */
    private void initMemberVariables(Builder builder) {
        this.viewGroup = builder.viewGroup;
        this.view = builder.view;
        this.backgroundDrawable = builder.backgroundDrawable;
        this.duration = builder.duration;
        this.enterDuration = builder.enterDuration;
        this.exitDuration = builder.exitDuration;
        this.alpha = builder.alpha;
        this.loop = builder.loop;
        this.loopCount = builder.loopCount;
        this.gradientCount = builder.gradientCount;
        this.gradientList = builder.gradientList;
        this.gradientItemList = builder.gradientItemList;

        animationDrawable = new AnimationDrawable();
    }

    /**
     * Method to throw IllegalArgumentException,
     * if both drawable as well individual gradients are provided
     */
    private void checkBackgroundDrawable() {
        if (backgroundDrawable != 0)
            throw new IllegalArgumentException("Don't supply drawable when using Gradient or GradientItem");
    }

    /**
     * Method to initialize gradientItem arraylist
     */
    private void initGradientItemList() {
        for (GradientItem gradientItem : gradientItemList) {
            int[] colors;

            if (gradientItem.getGradient().getCenterColor() == -1)
                colors = new int[]{
                        gradientItem.getGradient().getStartColor(),
                        gradientItem.getGradient().getEndColor()
                };

            else
                colors = new int[]{
                        gradientItem.getGradient().getStartColor(),
                        gradientItem.getGradient().getCenterColor(),
                        gradientItem.getGradient().getEndColor()
                };

            animationDrawable.addFrame
                    (new GradientDrawable(Gradient.getDrawableOrientation
                            (gradientItem.getGradient().getOrientation()), colors), gradientItem.getDuration());
        }
    }

    /**
     * Method to initialize gradient arraylist
     */
    private void initGradientList() {
        for (Gradient gradient : gradientList) {
            int[] colors;

            if (gradient.getCenterColor() == -1)
                colors = new int[]{
                        gradient.getStartColor(),
                        gradient.getEndColor()
                };

            else
                colors = new int[]{
                        gradient.getStartColor(),
                        gradient.getCenterColor(),
                        gradient.getEndColor()
                };

            animationDrawable.addFrame(new GradientDrawable(Gradient.getDrawableOrientation
                    (gradient.getOrientation()), colors), duration);
        }
    }

    /**
     * Method to initialize background
     */
    private void initViewBackground() {
        if (viewGroup != null) {
            viewGroup.setBackground(animationDrawable);
            animationDrawable = (AnimationDrawable) viewGroup.getBackground();
        } else {
            view.setBackground(animationDrawable);
            animationDrawable = (AnimationDrawable) view.getBackground();
        }
    }

    /**
     * Method to initialize background
     */
    private void initViewBackgroundResource() {
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(backgroundDrawable);
            animationDrawable = (AnimationDrawable) viewGroup.getBackground();
        } else {
            view.setBackgroundResource(backgroundDrawable);
            animationDrawable = (AnimationDrawable) view.getBackground();
        }
    }

    /**
     * Method to initialize duration, enter duration and exit duration
     */
    private void initDurations() {
        if (gradientItemList.isEmpty()) {
            if (duration > 0) {
                enterDuration = duration;
                exitDuration = duration;
            }
            animationDrawable.setEnterFadeDuration(enterDuration);
            animationDrawable.setExitFadeDuration(exitDuration);
        }
    }

    //endregion

}
