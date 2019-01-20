package edu.fzu.cameraui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.fzu.cameraui.R;
import edu.fzu.cameraui.pojo.FishInfo;

/**
 * 适配器
 */
public class RecordAdapter extends ArrayAdapter<FishInfo> {

    /**
     * 布局文件id
     */
    private int resourceId;

    public RecordAdapter(@NonNull Context context, int resource, List<FishInfo> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final FishInfo fishInfo = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        } else {
            view = convertView;
        }

        if (fishInfo != null) {
            TextView poolText = view.findViewById(R.id.record_pool_id);
            String poolId = fishInfo.getPoolId();
            poolText.setText(poolId + "号池塘");

/*            TextView timeText = view.findViewById(R.id.record_time);
            Date date = fishInfo.getDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:ss");
            String timeStr = simpleDateFormat.format(date);
            timeText.setText(timeStr);*/

            TextView recordText = view.findViewById(R.id.record_medication_record);
            String medicationRecord = fishInfo.getMedicationRecord();
            recordText.setText("用药记录：" + medicationRecord);
        }
        return view;
    }
}
