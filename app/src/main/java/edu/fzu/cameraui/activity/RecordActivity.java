package edu.fzu.cameraui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import edu.fzu.cameraui.R;
import edu.fzu.cameraui.adapter.RecordAdapter;
import edu.fzu.cameraui.pojo.FishInfo;
import edu.fzu.cameraui.util.SharedPreferencesUtil;

public class RecordActivity extends AppCompatActivity {
    private RecordAdapter recordAdapter;
    private List<FishInfo> recordList = new ArrayList<>();
    private ListView listView;
    private Activity activity;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        context = this;
        activity = this;

        View barView = LayoutInflater.from(this).inflate(R.layout.bar_record, new RelativeLayout(this), false);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(barView);
        }
        ImageView returnBtn = barView.findViewById(R.id.record_bar_return);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });

        ImageView takePhotoBtn = barView.findViewById(R.id.record_bar_take_photo);
        takePhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2019/1/20 跳转到拍照界面
                Intent intent = new Intent(context, ResActivity.class);
                startActivity(intent);
            }
        });

        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar
                .Builder(this, R.id.record_calendar)
                .range(startDate, endDate)
                .datesNumberOnScreen(7)
                .build();
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                // TODO: 2019/1/19 选择日期时显示指定日期的记录
            }
        });

        recordAdapter = new RecordAdapter(this, R.layout.item_record, recordList);
        listView = findViewById(R.id.list_record);
        listView.setAdapter(recordAdapter);
        getData();
    }

    public void getData() {
        // TODO: 2019/1/19 获取数据
        final String jsonData = SharedPreferencesUtil.getStringValue(context, "data");

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, jsonData, Toast.LENGTH_LONG);
            }
        });

        if (!"".equals(jsonData)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<FishInfo>>() {
            }.getType();
            List<FishInfo> list= gson.fromJson(jsonData, type);
            recordList.addAll(list);
        }

/*        FishInfo fishInfo = new FishInfo();
        fishInfo.setPoolId("1");
        fishInfo.setDate(new Date());
        fishInfo.setMedicationRecord("氨基酸");
        recordList.add(fishInfo);
        recordList.add(fishInfo);
        recordList.add(fishInfo);
        recordList.add(fishInfo);
        recordList.add(fishInfo);
        recordList.add(fishInfo);
        recordList.add(fishInfo);
        recordList.add(fishInfo);*/
    }

}
