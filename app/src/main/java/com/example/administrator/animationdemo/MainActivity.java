package com.example.administrator.animationdemo;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.rotateButton)
    private Button rotateBtn;
    @ViewInject(R.id.scaleButton)
    private Button scaleBtn;
    @ViewInject(R.id.alphaButton)
    private Button alphaBtn;
    @ViewInject(R.id.translateButton)
    private Button translateBtn;
    @ViewInject(R.id.image_iv)
    private ImageView imageView;
    @ViewInject(R.id.frame_image_iv)
    private ImageView framIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //@ContentView(value = R.layout.activity_main)
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);

    }

    /**
     * 旋转
     *
     * @param view
     */
    @OnClick(R.id.rotateButton)
    public void rotate(View view) {
        AnimationSet animationSet = new AnimationSet(true);
        //参数1：从哪个旋转角度开始
        //参数2：转到什么角度
        //后4个参数用于设置围绕着旋转的圆的圆心在哪里
        //参数3：确定x轴坐标的类型，有ABSOLUT绝对坐标、RELATIVE_TO_SELF相对于自身坐标、RELATIVE_TO_PARENT相对于父控件的坐标
        //参数4：x轴的值，0.5f表明是以自身这个控件的一半长度为x轴
        //参数5：确定y轴坐标的类型
        //参数6：y轴的值，0.5f表明是以自身这个控件的一半长度为x轴
        RotateAnimation rotateAnim = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnim.setDuration(1000);
        animationSet.addAnimation(rotateAnim);
        imageView.startAnimation(animationSet);

    }

    /**
     * 缩放
     *
     * @param view
     */
    @OnClick(R.id.scaleButton)
    public void scale(View view) {

        AnimationSet animationSet = new AnimationSet(true);

        //参数1：x轴的初始值
        //参数2：x轴收缩后的值
        //参数3：y轴的初始值
        //参数4：y轴收缩后的值
        //参数5：确定x轴坐标的类型
        //参数6：x轴的值，0.5f表明是以自身这个控件的一半长度为x轴
        //参数7：确定y轴坐标的类型
        //参数8：y轴的值，0.5f表明是以自身这个控件的一半长度为x轴

        ScaleAnimation scaleAnimation = new ScaleAnimation(
                0, 0.1f, 0, 0.1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        scaleAnimation.setDuration(5000);
        animationSet.addAnimation(scaleAnimation);
        imageView.startAnimation(animationSet);
    }

    /**
     * 浅入浅出
     *
     * @param view
     */
    @OnClick(R.id.alphaButton)
    public void alpcaleButtonha(View view) {
        AnimationSet animationSet = new AnimationSet(true);

        //创建一个AlphaAnimation对象，参数从完全的透明度，到完全的不透明
        //AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        //创建一个AlphaAnimation对象，参数从完全的不透明度，到完全的透明
        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        //设置动画执行的时间
        alphaAnimation.setDuration(5000);
        //将alphaAnimation对象添加到AnimationSet当中
        animationSet.addAnimation(alphaAnimation);
        //使用ImageView的startAnimation方法执行动画
        imageView.startAnimation(animationSet);


    }

    /**
     * 平移
     *
     * @param view
     */
    @OnClick(R.id.translateButton)
    public void transLate(View view) {
        AnimationSet animationSet = new AnimationSet(true);

        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,     //参数1～2：x轴的开始位置
                Animation.RELATIVE_TO_SELF, 0.5f,   //参数3～4：x轴的结束位置
                Animation.RELATIVE_TO_SELF, 0f,     //参数5～6：y轴的开始位置
                Animation.RELATIVE_TO_SELF, 0.5f);  //参数7～8：x轴的结束位置

        translateAnimation.setDuration(2000);

        animationSet.addAnimation(translateAnimation);
        animationSet.setFillAfter(true);//如果fillAfter的值为true,则动画执行后，控件将停留在执行结束的状态
        imageView.startAnimation(animationSet);
    }

    /**
     * 浅入浅出
     * @param view
     */
    @OnClick(R.id.alphaButton2)
    public void alpha2(View view){
        // 使用AnimationUtils装载动画配置文件
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        // 启动动画
        imageView.startAnimation(animation);

    }

    /**
     * 旋转
     * @param view
     */
    @OnClick(R.id.rotateButton2)
    public void rotate2(View view){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imageView.startAnimation(animation);
    }

    /**
     * 缩放
     * @param view
     */
    @OnClick(R.id.scaleButton2)
    public void scale2(View view){

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        imageView.startAnimation(animation);
    }

    /**
     * 平移
     * @param view
     */
    @OnClick(R.id.translateButton2)
    public void translate2(View view){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        imageView.startAnimation(animation);
    }

    /**
     * 帧动画
     * @param view
     */
    @OnClick(R.id.frame_anim)
    public void frameAnim(View view){
        framIv.setBackgroundResource(R.drawable.fram_by_fram_anim);
        AnimationDrawable animationDrawable = (AnimationDrawable) framIv.getBackground();
        animationDrawable.start();
    }
    @OnClick(R.id.attribute_anim)
    public void attributeAnim(View view){
        Intent intent = new Intent(this,AttributeAnimaction.class);
        startActivity(intent);
    }
}
