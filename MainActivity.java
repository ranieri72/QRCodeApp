package com.example.mtz_5555_transp.qrcodeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final int BARCODE_REQUEST = 1;
    @BindView(R.id.txtContent)
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void submit(View view) {
        Intent it;
        switch (view.getId()) {
            case R.id.button:
                it = new Intent(this, CameraActivity.class);
                startActivityForResult(it, BARCODE_REQUEST);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case BARCODE_REQUEST:
                if (resultCode == CommonStatusCodes.SUCCESS) {
                    if (data != null) {
                        Barcode barcode = data.getParcelableExtra(CameraActivity.BARCODE_RESPONSE);
                        txtView.setText(barcode.displayValue);
                        Log.w("onActivityResult", "Barcode: " + barcode.displayValue);
                    } else {
                        txtView.setText("Error");
                    }
                }
                break;
        }

    }
}
