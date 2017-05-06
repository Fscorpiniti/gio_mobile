package untref.tesis.gio.presentation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import untref.tesis.gio.R;
import untref.tesis.gio.presentation.domain.CreateTermDepositPresenterFactory;
import untref.tesis.gio.presentation.presenter.CreateTermDepositPresenter;

public class DefaultCreateTermDepositActivity extends Activity implements CreateTermDepositActivity,
        AdapterView.OnItemSelectedListener {

    private static final String PERCENTAGE = "%";
    private CreateTermDepositPresenter createTermDepositPresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_term_deposit_activity);
        Spinner spinner = (Spinner) findViewById(R.id.spinner_term_deposit_duration);
        spinner.setOnItemSelectedListener(this);
        this.createTermDepositPresenter = CreateTermDepositPresenterFactory.build(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Integer duration = Integer.valueOf((String) parent.getItemAtPosition(position));
        this.createTermDepositPresenter.findRateForDuration(duration);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        throw new RuntimeException("Duration is required");
    }

    @Override
    public void updateRateValue(Double rate) {
        TextView rateTextView = (TextView) findViewById(R.id.rate_value_term_deposit_text_view);
        rateTextView.setText(buildRatePercentage(rate));
    }

    private String buildRatePercentage(Double rate) {
        return new StringBuilder(String.valueOf(rate)).append(PERCENTAGE).toString();
    }

}
