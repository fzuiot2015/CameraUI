package edu.fzu.cameraui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.fzu.cameraui.R;
import edu.fzu.cameraui.adapter.ResAdapter;
import edu.fzu.cameraui.pojo.FishInfo;

public class ResActivity extends AppCompatActivity {
    private ResAdapter resAdapter;
    private List<FishInfo> resList = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        resAdapter = new ResAdapter(this, R.layout.item_res, resList);
        listView = findViewById(R.id.list_res);
        listView.setAdapter(resAdapter);
        getData();
    }

    public void getData() {
        // TODO: 2019/1/19 获取数据
        FishInfo fishInfo = new FishInfo();
        fishInfo.setPoolId(1);
        fishInfo.setFeedQuantity1(12);
        fishInfo.setFeedQuantity2(12);
        fishInfo.setFeedQuantity3(12);
        fishInfo.setFeedQuantity4(0);
        fishInfo.setWaterQuantity(0);
        fishInfo.setPhAM(8.2f);
        fishInfo.setPhPM(8.6f);
        fishInfo.setNh4n(0);
        fishInfo.setNano2(0);
        fishInfo.setMedicationRecord("光合菌调水");
        resList.add(fishInfo);
        resList.add(fishInfo);
        resList.add(fishInfo);
        resList.add(fishInfo);
        resList.add(fishInfo);
    }

}
