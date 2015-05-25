package com.tutsplus.matt.bluetoothscanner;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

/**
 * Created by Matt on 5/12/2015.
 */
public class DeviceListAdapter extends ArrayAdapter{

    private Context context;
    private BluetoothAdapter bTAdapter;

    public DeviceListAdapter(Context context, List items, BluetoothAdapter bTAdapter) {
        super(context, android.R.layout.simple_list_item_1, items);
        this.bTAdapter = bTAdapter;
        this.context = context;
    }

    /**
     * Holder for the list items.
     */
    private class ViewHolder{
        TextView titleText;
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        TextView batteryLife = null;
        View line = null;
        DeviceItem item = (DeviceItem)getItem(position);
        final String name = item.getDeviceName();
        ToggleButton enableDisable = null;
        View viewToUse = null;
        ImageButton remove = null;


        // This block exists to inflate the settings list item conditionally based on whether
        // we want to support a grid or list view.
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        viewToUse = mInflater.inflate(R.layout.device_list_item, null);
        holder = new ViewHolder();
        holder.titleText = (TextView)viewToUse.findViewById(R.id.titleTextView);
        viewToUse.setTag(holder);

        batteryLife = (TextView)viewToUse.findViewById(R.id.batterylife);
        enableDisable = (ToggleButton)viewToUse.findViewById(R.id.enableDisable);
        line = (View)viewToUse.findViewById(R.id.line);
        remove = (ImageButton)viewToUse.findViewById(R.id.remove);
        holder.titleText.setText(item.getDeviceName());

        if ( item.getDeviceName().toString() == "No Devices") {
            batteryLife.setVisibility(View.INVISIBLE);
            enableDisable.setVisibility(View.INVISIBLE);
            line.setVisibility(View.INVISIBLE);
            remove.setVisibility(View.INVISIBLE);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            params.addRule(RelativeLayout.CENTER_HORIZONTAL);
            holder.titleText.setLayoutParams(params);
        }
        else {
            enableDisable.setChecked(item.getEnabled());

            enableDisable.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        //TODO Connect
                    } else {
                        //TODO Disconnect
                    }

                }
            });

            remove.setOnClickListener(new ImageButton.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              //TODO remove
                                              v.invalidate();
                                          }
                                      }
            );
            batteryLife.setText(item.getBatteryLife() + "%");
        }

        return viewToUse;
    }


}
