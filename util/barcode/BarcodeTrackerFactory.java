package com.example.mtz_5555_transp.qrcodeapplication.util.barcode;

import android.content.Context;

import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.barcode.Barcode;

/**
 * Created by mtz-5555-transp on 22/08/17.
 */

public class BarcodeTrackerFactory implements MultiProcessor.Factory<Barcode> {

    private Context context;

    public BarcodeTrackerFactory(Context context) {
        this.context = context;
    }

    @Override
    public Tracker<Barcode> create(Barcode barcode) {
        return new BarcodeGraphicTracker(context);
    }
}