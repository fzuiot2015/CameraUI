package edu.fzu.cameraui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import edu.fzu.cameraui.R;
import edu.fzu.cameraui.adapter.ResAdapter;
import edu.fzu.cameraui.pojo.FishInfo;
import edu.fzu.cameraui.util.SharedPreferencesUtil;

public class ResActivity extends AppCompatActivity {
    private ResAdapter resAdapter;
    private List<FishInfo> resList = new ArrayList<>();
    private ListView listView;
    private Activity activity;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        activity = this;
        context = this;

        View barView = LayoutInflater.from(this).inflate(R.layout.bar_res, new RelativeLayout(this), false);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(barView);
        }
        ImageView returnBtn = barView.findViewById(R.id.res_bar_return);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });

        SharedPreferencesUtil.saveStringValue(context, "data", "");

        ImageView okBtn = barView.findViewById(R.id.res_bar_ok);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2019/1/20 保存识别结果
                Gson gson = new Gson();
                final String jsonRes = gson.toJson(resList);
                SharedPreferencesUtil.saveStringValue(context, "data", jsonRes);

                Intent intent = new Intent(activity, RecordActivity.class);
                activity.startActivity(intent);
            }
        });

        resAdapter = new ResAdapter(activity, R.layout.item_res, resList);
        listView = findViewById(R.id.list_res);
        listView.setAdapter(resAdapter);
        getData();
    }

    public void getData() {
        // TODO: 2019/1/19 获取数据
        FishInfo fishInfo = new FishInfo();
        fishInfo.setPoolId("1");
        fishInfo.setFeedQuantity1("12");
        fishInfo.setFeedQuantity2("12");
        fishInfo.setFeedQuantity3("12");
        fishInfo.setFeedQuantity4("0");
        fishInfo.setWaterQuantity("0");
        fishInfo.setPhAM("8.2");
        fishInfo.setPhPM("8.6");
        fishInfo.setNh4n("0");
        fishInfo.setNano2("0");
        fishInfo.setMedicationRecord("光合菌调水");
        resList.add(fishInfo);
        resList.add(fishInfo);
        resList.add(fishInfo);
        resList.add(fishInfo);
        resList.add(fishInfo);
    }

}
