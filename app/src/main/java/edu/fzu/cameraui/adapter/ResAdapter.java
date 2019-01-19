package edu.fzu.cameraui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import edu.fzu.cameraui.R;
import edu.fzu.cameraui.pojo.FishInfo;

/**
 * 适配器
 */
public class ResAdapter extends ArrayAdapter<FishInfo> {

    /**
     * 布局文件id
     */
    private int resourceId;

    public ResAdapter(@NonNull Context context, int resource, List<FishInfo> objects) {
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
            TextView poolText = view.findViewById(R.id.res_pool_id);
            int poolId = fishInfo.getPoolId();
            poolText.setText(poolId + "号池塘");

            TextView feedText = view.findViewById(R.id.res_feed_quantity);
            int feedQuantity1 = fishInfo.getFeedQuantity1();
            int feedQuantity2 = fishInfo.getFeedQuantity2();
            int feedQuantity3 = fishInfo.getFeedQuantity3();
            int feedQuantity4 = fishInfo.getFeedQuantity4();
            feedText.setText("投料量：" + feedQuantity1 + "," + feedQuantity2 + "," + feedQuantity3 + "," + feedQuantity4);

            TextView phText = view.findViewById(R.id.res_ph);
            float phAM = fishInfo.getPhAM();
            float phPM = fishInfo.getPhPM();
            phText.setText("PH值：" + "上午 " + phAM + "，下午 " + phPM);

            TextView nh4nText = view.findViewById(R.id.res_nh4n);
            int nh4n = fishInfo.getNh4n();
            nh4nText.setText("氨氮：" + nh4n);

            TextView nano2Text = view.findViewById(R.id.res_nano2);
            int nano2 = fishInfo.getNano2();
            nano2Text.setText("亚硝酸盐：" + nano2);

            TextView recordText = view.findViewById(R.id.res_medication_record);
            String medicationRecord = fishInfo.getMedicationRecord();
            recordText.setText("用药记录：" + medicationRecord);

            Button deleteButton = view.findViewById(R.id.res_btn_delete);
        }
        return view;
    }
}
