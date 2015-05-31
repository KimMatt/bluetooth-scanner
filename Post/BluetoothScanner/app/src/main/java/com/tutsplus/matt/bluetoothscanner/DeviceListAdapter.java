package com.tutsplus.matt.bluetoothscanner;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

/**
 * Created by Matt on 5/12/2015.
 */
public class DeviceListAdapter extends ArrayAdapter<DeviceItem>{

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
        View line = null;
        DeviceItem item = (DeviceItem)getItem(position);
        final String name = item.getDeviceName();
        ToggleButton connectDisconnect = null;
        View viewToUse = null;

        // This block exists to inflate the settings list item conditionally based on whether
        // we want to support a grid or list view.
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        viewToUse = mInflater.inflate(R.layout.device_list_item, null);
        holder = new ViewHolder();
        holder.titleText = (TextView)viewToUse.findViewById(R.id.titleTextView);
        viewToUse.setTag(holder);

        connectDisconnect = (ToggleButton)viewToUse.findViewById(R.id.connectDisconnect);
        line = (View)viewToUse.findViewById(R.id.line);
        holder.titleText.setText(item.getDeviceName());


        if ( item.getDeviceName().toString() == "No Devices") {
            connectDisconnect.setVisibility(View.INVISIBLE);
            line.setVisibility(View.INVISIBLE);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            params.addRule(RelativeLayout.CENTER_HORIZONTAL);
            holder.titleText.setLayoutParams(params);
        }
        else {
            connectDisconnect.setChecked(item.getConnected());

            connectDisconnect.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        //TODO Connect
                    } else {
                        //TODO Disconnect
                    }

                }
            });

        }

        return viewToUse;
    }


}
