package com.mvivekanandji.gradientanimation.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

import com.mvivekanandji.gradientanimation.R;


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
 *
 * A view class to use in layout xml
 */
public class GradientAnimationView extends View {

    @DrawableRes
    private int drawable;
    private int duration;
    private int enterDuration;
    private int exitDuration;
    @IntRange(from=0,to=255)
    private int alpha;
    private boolean loop;
    @IntRange(from=1,to=Integer.MAX_VALUE)
    private int loopCount;
    private int gradientCount;


    /**
     * Simple constructor to use when creating a view from code.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     */
    public GradientAnimationView(Context context) {
        super(context);
        initAnimation();
    }

    /**
     * Constructor that is called when inflating a view from XML. This is called
     * when a view is being constructed from an XML file, supplying attributes
     * that were specified in the XML file. This version uses a default style of
     * 0, so the only attribute values applied are those in the Context's Theme
     * and the given AttributeSet.
     *
     * <p>
     * The method onFinishInflate() will be called after all children have been
     * added.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     */
    public GradientAnimationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = getContext().
                obtainStyledAttributes(attrs, R.styleable.GradientAnimationView,0,0);

        drawable = typedArray.getResourceId(R.styleable.GradientAnimationView_ga_drawable,R.drawable.anim_blue_purple);

        if(typedArray.hasValue(R.styleable.GradientAnimationView_ga_duration)){
            duration = typedArray.getInt(R.styleable.GradientAnimationView_ga_duration, 1000);
            enterDuration = duration;
            exitDuration = duration;
        } else {
            enterDuration = typedArray.getInt(R.styleable.GradientAnimationView_ga_enter_duration, 1000);
            exitDuration = typedArray.getInt(R.styleable.GradientAnimationView_ga_exit_duration, 1000);
        }

        alpha = typedArray.getInt(R.styleable.GradientAnimationView_ga_alpha,255);
        loop = typedArray.getBoolean(R.styleable.GradientAnimationView_ga_loop,true);
        loopCount = typedArray.getInt(R.styleable.GradientAnimationView_ga_loop_count, -1);
        gradientCount = typedArray.getInt(R.styleable.GradientAnimationView_ga_loop_count, 2);

        typedArray.recycle();

        initAnimation();
    }

    /**
     * Perform inflation from XML and apply a class-specific base style from a
     * theme attribute. This constructor of View allows subclasses to use their
     * own base style when they are inflating. For example, a Button class's
     * constructor would call this version of the super class constructor and
     * supply <code>R.attr.buttonStyle</code> for <var>defStyleAttr</var>; this
     * allows the theme's button style to modify all of the base view attributes
     * (in particular its background) as well as the Button class's attributes.
     *
     * @param context      The Context the view is running in, through which it can
     *                     access the current theme, resources, etc.
     * @param attrs        The attributes of the XML tag that is inflating the view.
     * @param defStyleAttr An attribute in the current theme that contains a
     *                     reference to a style resource that supplies default values for
     *                     the view. Can be 0 to not look for defaults.
     */
    public GradientAnimationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAnimation();
    }

    /**
     * Perform inflation from XML and apply a class-specific base style from a
     * theme attribute or style resource. This constructor of View allows
     * subclasses to use their own base style when they are inflating.
     * <p>
     * When determining the final value of a particular attribute, there are
     * four inputs that come into play:
     * <ol>
     * <li>Any attribute values in the given AttributeSet.
     * <li>The style resource specified in the AttributeSet (named "style").
     * <li>The default style specified by <var>defStyleAttr</var>.
     * <li>The default style specified by <var>defStyleRes</var>.
     * <li>The base values in this theme.
     * </ol>
     * <p>
     * Each of these inputs is considered in-order, with the first listed taking
     * precedence over the following ones. In other words, if in the
     * AttributeSet you have supplied <code>&lt;Button * textColor="#ff000000"&gt;</code>
     * , then the button's text will <em>always</em> be black, regardless of
     * what is specified in any of the styles.
     *
     * @param context      The Context the view is running in, through which it can
     *                     access the current theme, resources, etc.
     * @param attrs        The attributes of the XML tag that is inflating the view.
     * @param defStyleAttr An attribute in the current theme that contains a
     *                     reference to a style resource that supplies default values for
     *                     the view. Can be 0 to not look for defaults.
     * @param defStyleRes  A resource identifier of a style resource that
     *                     supplies default values for the view, used only if
     *                     defStyleAttr is 0 or can not be found in the theme. Can be 0
     *                     to not look for defaults.
     */
    public GradientAnimationView(Context context, @Nullable AttributeSet attrs,
                                 int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAnimation();
    }


    /**
     * Method to initialize AnimationDrawable and start animation
     */
    private void initAnimation(){
        setBackgroundResource(drawable);
        final AnimationDrawable animationDrawable = (AnimationDrawable) getBackground();

        animationDrawable.setEnterFadeDuration(enterDuration);
        animationDrawable.setExitFadeDuration(exitDuration);
        animationDrawable.setAlpha(alpha);

        animationDrawable.start();

        if(!loop) animationDrawable.setOneShot(true);

        else if(loopCount > 0) {
            long loopTime = new Long(loopCount) * gradientCount * (enterDuration + exitDuration);

            postDelayed(new Runnable() {
                @Override
                public void run() {
                    animationDrawable.stop();
                }
            },loopTime);
        }

    }


}
