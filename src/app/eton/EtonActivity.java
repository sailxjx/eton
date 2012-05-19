package app.eton;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EtonActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button bt = (Button) findViewById(R.id.btConfirm);
		bt.setOnClickListener(oclBmi);
	}

	protected OnClickListener oclBmi = new OnClickListener() {

		public void onClick(View v) {
			DecimalFormat df = new DecimalFormat("0.00");
			EditText etHeight = (EditText) findViewById(R.id.etHeight);
			EditText etWeight = (EditText) findViewById(R.id.etWeight);
			double dbHeight = Double.parseDouble(etHeight.getText().toString()) / 100;
			double dbWeight = Double.parseDouble(etWeight.getText().toString());
			double dbBMI = dbWeight / (dbHeight * dbHeight);

			TextView tvResult = (TextView) findViewById(R.id.tvResult);
			tvResult.setText(getResources().getString(R.string.labelResult) + "~：" + df.format(dbBMI));

			TextView tvTip = (TextView) findViewById(R.id.tvTip);

			String[] aTips = getResources().getStringArray(R.array.aTips);
			if (dbBMI > 25) {
				tvTip.setText(aTips[2]);
			} else if (dbBMI < 20) {
				tvTip.setText(aTips[0]);
			} else {
				tvTip.setText(aTips[1]);
			}
		}
	};
}