package app.eton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ReportActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);
        
        Bundle bd = this.getIntent().getExtras();
        TextView tvRTip = (TextView) findViewById(R.id.tvRTip);
        tvRTip.setText(bd.getString(getString(R.string.kWeight)));
    }

}
