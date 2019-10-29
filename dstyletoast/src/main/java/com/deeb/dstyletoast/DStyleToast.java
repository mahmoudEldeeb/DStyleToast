package com.deeb.dstyletoast;

import android.annotation.SuppressLint;
import android.content.Context;

import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;

import static android.view.View.inflate;

public class DStyleToast {
    private String text;
    private Context context;
    TextView textView;
    LinearLayout rootLayout;
    private float cornerRadius = -1;
    @ColorRes
    private int backgroundColor;
    private int strokeColor;
    private int strokeWidth;
    private int style;
    private int iconStart;
    private int iconEnd;
    private int length;
    ImageView icon_begin,icon_end;
    public DStyleToast(Bulider bulider){
        context=bulider.context;
        this.strokeColor=bulider.strokeColor;
        this.strokeWidth=bulider.strokeWidth;
        this.backgroundColor=bulider.backgroundColor;
        this.cornerRadius=bulider.cornerRadius;
        this.text=bulider.text;
        this.iconStart=bulider.iconStart;
        this.iconEnd=bulider.iconEnd;
        this.length=bulider.length;

    }

    public DStyleToast(Context ctx, String text, int style) {
        this.context=ctx;
        this.text=text;
        this.style=style;
    }

    public void show(){
        getView();
          Toast toast = new Toast(context);
        toast.setDuration(length);
        toast.setView(rootLayout);
        toast.show();
    }


    @SuppressLint("ResourceAsColor")
    private void getView() {
        View v = inflate(context, R.layout.toast_layout, null);
        rootLayout = v.findViewById(R.id.parent);
         textView=v.findViewById(R.id.toast_text);
        icon_begin=v.findViewById(R.id.iconstart);
        icon_end=v.findViewById(R.id.iconend);


        putBackground();
        putIconAndText();

    }

    private void putBackground() {
        GradientDrawable shape = (GradientDrawable) rootLayout.getBackground().mutate();
        if (strokeWidth > 0) {
            shape.setStroke(strokeWidth, strokeColor);
        }
        if (cornerRadius > -1) {
            shape.setCornerRadius(cornerRadius);
        }
        if (backgroundColor != 0) {
            Log.v("ddd",backgroundColor+"");
            shape.setColor(ContextCompat.getColor(context, backgroundColor));
        }

        int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            rootLayout.setBackgroundDrawable(shape);
        } else {
            rootLayout.setBackground(shape);
        }
    }

    private void putIconAndText() {
        if(iconStart!=0){
            icon_begin.setImageResource(iconStart);
        }
        else icon_begin.setVisibility(View.GONE);
        if(iconEnd!=0){
            icon_end.setImageResource(iconEnd);
        }
        else icon_end.setVisibility(View.GONE);
        textView.setText(text);

    }

    public static void warningToast(Context context, String text, int duration){
        Bulider bulider=new Bulider(context);
        bulider.setIconStart(R.drawable.ic_warning_black_24dp);
        bulider.setText(text);
        bulider.setBackgroundColor(R.color.warningColor);
        new DStyleToast(bulider)
                .show();
    }


    public static void sucessToast(Context context, String text, int length){
        Bulider bulider=new Bulider(context);
        bulider.setIconStart(R.drawable.ic_check_black_24dp);
        bulider.setText(text);
        bulider.setLength(length);
        bulider.setBackgroundColor(R.color.successColor);
        new DStyleToast(bulider)
                .show();
    }
    public static void infoToast(Context context, String text, int length){
        Bulider bulider=new Bulider(context);
        bulider.setIconStart(R.drawable.ic_info_black_24dp);
        bulider.setText(text);
        bulider.setLength(length);
        bulider.setBackgroundColor(R.color.infoColor);
        new DStyleToast(bulider)
                .show();
    }

    public static void errorToast(Context context, String text, int length){
        Bulider bulider=new Bulider(context);
        bulider.setIconStart(R.drawable.ic_error_black_24dp);
        bulider.setText(text);
        bulider.setLength(length);
        bulider.setBackgroundColor(R.color.errorColor);
        new DStyleToast(bulider)
                .show();
    }


    public static Bulider build(Context context){
        return new Bulider(context);
    }

    public static class Bulider{
        private float cornerRadius = -1;
        @ColorRes
        private int backgroundColor;
        private int strokeColor;
        private int strokeWidth;
        private int iconStart;
        private int iconEnd;
        private int length;
        private String text;
        private DStyleToast toast;
        private  Context context;

public  Bulider(Context ctx){
    this.context=ctx;
}
        public Bulider() {

        }
        public Bulider setCornerRadius(int cornerRadius) {
            this.cornerRadius = cornerRadius;
            return this;
        }


        public Bulider setBackgroundColor(@ColorRes int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Bulider setStrokeColor(int strokeColor) {
            this.strokeColor = strokeColor;
            return this;
        }

        public Bulider setStrokeWidth(int strokeWidth) {
            this.strokeWidth = strokeWidth;
            return this;
        }

        public Bulider setIconStart(int iconStart) {
            this.iconStart = iconStart;
            return this;
        }

        public Bulider setIconEnd(int iconEnd) {
            this.iconEnd = iconEnd;
            return this;
        }
        public Bulider setLength(int length) {
            this.length = length;
            return this;
        }


        public Bulider setText(String text) {
            this.text = text;
            return this;
        }


        public Bulider setContext(Context context) {
            this.context = context;
            return this;
        }

    
        public void show(){
            toast=new DStyleToast(this);
            toast.show();
        }
    }
}
