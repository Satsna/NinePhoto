package com.example.stasna;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.stasna.util.LogUtil;
import com.example.stasna.util.ToastUtil;
import com.satsna.ninephoto.widget.SortableNinePhotoLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String tag = "MainActivity";
    private Context context = this;


    SortableNinePhotoLayout np;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        np = findViewById(R.id.np);
        initGridPhotoLayout();
    }


    /**
     * 九宫格图片
     *******************************************************************************************************/
    public void initGridPhotoLayout() {
        // 设置拖拽排序控件的代理
        SortableNinePhotoLayout.Delegate sort = new SortableNinePhotoLayout.Delegate() {
            @Override
            public void onClickAddNinePhotoItem(SortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, ArrayList<String> models) {
//                choicePhotoWrapper();
                LogUtil.e(tag, "onClickAddNinePhotoItem");
//                openGallery();//打开图库
            }

            @Override
            public void onClickDeleteNinePhotoItem(SortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
                np.removeItem(position);
            }

            @Override
            public void onClickNinePhotoItem(SortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
                LogUtil.e(tag, "position=" + position + 1);

            }

            @Override
            public void onNinePhotoItemExchanged(SortableNinePhotoLayout sortableNinePhotoLayout, int fromPosition, int toPosition, ArrayList<String> models) {
                ToastUtil.shortshow(context, "排序发生变化");
            }
        };
        np.setDelegate(sort);
    }
    /**九宫格图片*******************************************************************************************************/
}
