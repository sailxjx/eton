package app.eton;

import java.net.URL;
import java.text.DecimalFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EtonActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button bt = (Button) findViewById(R.id.btConfirm);
		bt.setOnClickListener(oclBmi);
	}

	protected OnClickListener oclBmi = new OnClickListener() {

		public void onClick(View v) {
			try {
				DecimalFormat df = new DecimalFormat("0.00");
				EditText etHeight = (EditText) findViewById(R.id.etHeight);
				EditText etWeight = (EditText) findViewById(R.id.etWeight);
				double dbHeight = Double.parseDouble(etHeight.getText()
						.toString()) / 100;
				double dbWeight = Double.parseDouble(etWeight.getText()
						.toString());
				double dbBMI = (dbHeight * dbHeight == 0) ? 0 : dbWeight
						/ (dbHeight * dbHeight);

				TextView tvResult = (TextView) findViewById(R.id.tvResult);

				tvResult.setText(getResources().getString(R.string.labelResult)
						+ "~：" + df.format((double) dbBMI));

				TextView tvTip = (TextView) findViewById(R.id.tvTip);

				String[] aTips = getResources().getStringArray(R.array.aTips);
				if (dbBMI > 25) {
					tvTip.setText(aTips[2]);
				} else if (dbBMI < 20) {
					tvTip.setText(aTips[0]);
				} else {
					tvTip.setText(aTips[1]);
				}
			} catch (Exception e) {
				Toast.makeText(EtonActivity.this, "打错了哦～", Toast.LENGTH_SHORT)
						.show();
				this.openOptionsDialog();
				return;
			}
		}

		protected void openOptionsDialog() {
			new AlertDialog.Builder(EtonActivity.this).setTitle("小喇叭小的不得了")
					.setMessage("小喇叭出错咯～～～").setPositiveButton("确认", oclLeave)
					.setNegativeButton("首页", this.getToHomepage()).show();
		}

		protected DialogInterface.OnClickListener getToHomepage() {
			return new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					Uri uri = Uri.parse("http://www.loli.local.com");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					startActivity(intent);
				}
			};
		}
	};

	protected DialogInterface.OnClickListener oclLeave = new DialogInterface.OnClickListener() {

		public void onClick(DialogInterface dialog, int which) {
		}
	};

}