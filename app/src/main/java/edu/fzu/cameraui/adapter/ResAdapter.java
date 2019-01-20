package edu.fzu.cameraui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import edu.fzu.cameraui.R;
import edu.fzu.cameraui.pojo.FishInfo;

/**
 * 适配器
 */
public class ResAdapter extends ArrayAdapter<FishInfo> {
    private EditText poolText;
    private EditText feedText1;
    private EditText feedText2;
    private EditText feedText3;
    private EditText feedText4;

    private EditText waterText;

    private EditText phAmText;
    private EditText phPmText;

    private EditText nh4nText;
    private EditText nano2Text;
    private EditText recordText;

//    private List<EditText> editTextList = new ArrayList<>();

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
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final FishInfo fishInfo = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        } else {
            view = convertView;
        }

        if (fishInfo != null) {
            poolText = view.findViewById(R.id.res_pool_id);
            poolText.setText(fishInfo.getPoolId());

            feedText1 = view.findViewById(R.id.res_feed_quantity1);
            feedText1.setText(fishInfo.getFeedQuantity1());
//            editTextList.add(feedText1);

            feedText2 = view.findViewById(R.id.res_feed_quantity2);
            feedText2.setText(fishInfo.getFeedQuantity2());
//            editTextList.add(feedText2);

            feedText3 = view.findViewById(R.id.res_feed_quantity3);
            feedText3.setText(fishInfo.getFeedQuantity3());
//            editTextList.add(feedText3);

            feedText4 = view.findViewById(R.id.res_feed_quantity4);
            feedText4.setText(fishInfo.getFeedQuantity4());
//            editTextList.add(feedText4);

            waterText = view.findViewById(R.id.res_water_quantity);
            waterText.setText(fishInfo.getWaterQuantity());
//            editTextList.add(waterText);

            phAmText = view.findViewById(R.id.res_ph_am);
            phAmText.setText(String.valueOf(fishInfo.getPhAM()));
//            editTextList.add(phAmText);

            phPmText = view.findViewById(R.id.res_ph_pm);
            phPmText.setText(String.valueOf(fishInfo.getPhPM()));
//            editTextList.add(phPmText);

            nh4nText = view.findViewById(R.id.res_nh4n);
            nh4nText.setText(fishInfo.getNh4n());
//            editTextList.add(nh4nText);

            nano2Text = view.findViewById(R.id.res_nano2);
            nano2Text.setText(fishInfo.getNano2());
//            editTextList.add(nano2Text);

            recordText = view.findViewById(R.id.res_medication_record);
            recordText.setText(fishInfo.getMedicationRecord());
//            editTextList.add(recordText);

            Button deleteButton = view.findViewById(R.id.res_btn_delete);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: 2019/1/19 删除
                }
            });

            Button modifyButton = view.findViewById(R.id.res_btn_modify);
            modifyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: 2019/1/19 修正
/*                    for (EditText editText : editTextList) {
                        enableEditText(editText);
                    }*/
                }
            });

            Button okButton = view.findViewById(R.id.res_btn_ok);
            okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: 2019/1/19 确认
/*                    FishInfo fishInfoRes = ResActivity.resList.get(position);
                    fishInfoRes.setDate(new Date());
                    fishInfoRes.setPoolId(poolText.getText().toString());
                    fishInfoRes.setFeedQuantity1(feedText1.getText().toString());
                    fishInfoRes.setFeedQuantity2(feedText2.getText().toString());
                    fishInfoRes.setFeedQuantity3(feedText3.getText().toString());
                    fishInfoRes.setFeedQuantity4(feedText4.getText().toString());
                    fishInfoRes.setWaterQuantity(waterText.getText().toString());
                    fishInfoRes.setPhAM(phAmText.getText().toString());
                    fishInfoRes.setPhPM(phPmText.getText().toString());
                    fishInfoRes.setNh4n(nh4nText.getText().toString());
                    fishInfoRes.setNano2(nano2Text.getText().toString());
                    fishInfoRes.setMedicationRecord(recordText.getText().toString());*/

/*                    for (EditText editText : editTextList) {
                        disableEditText(editText);
                    }*/
                }
            });
        }
        return view;
    }

    private void enableEditText(EditText editText) {
        editText.setFocusableInTouchMode(true);
        editText.setFocusable(true);
    }

    private void disableEditText(EditText editText) {
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(false);
    }
}
