package untref.tesis.gio.presentation.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

import untref.tesis.gio.R;
import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.presentation.domain.CreateTermDepositPresenterFactory;
import untref.tesis.gio.presentation.domain.InterestCalculator;
import untref.tesis.gio.presentation.presenter.CreateTermDepositPresenter;

public class DefaultCreateTermDepositActivity extends Activity implements CreateTermDepositActivity,
        AdapterView.OnItemSelectedListener {

    private static final String PERCENTAGE = "%";
    private static final Integer DEFAULT_USER_ID = 0;
    private CreateTermDepositPresenter createTermDepositPresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_term_deposit_activity);
        Spinner spinner = findDurationSpinner();
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
    public void refreshByChangeRate(Double rate, Integer durationInMonths) {
        refreshComponent(R.id.rate_value_term_deposit_text_view, buildRatePercentage(rate));
        refreshInterest(rate, durationInMonths);
    }

    @Override
    public void sucessfulCreationTermDeposit(TermDeposit termDeposit) {
        Toast.makeText(this, buildSucessfulMessage(termDeposit), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DefaultDashboardActivity.class);
        startActivity(intent);
    }

    @Override
    public void notifyError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void create(View view) {
        EditText editAmount = (EditText) findViewById(R.id.amout_term_deposit_edit);
        TextView textRateValue = (TextView) findViewById(R.id.rate_value_term_deposit_text_view);
        Spinner spinner = findDurationSpinner();
        String durationSelected = (String) spinner.getSelectedItem();

        Double amount = Double.valueOf(editAmount.getText().toString());
        Double rate = Double.valueOf(getRateValue(textRateValue));
        Integer duration = Integer.valueOf(durationSelected);

        SharedPreferences sharedPref = getSharedPreferences("user", Context.MODE_PRIVATE);
        Integer ownerId = sharedPref.getInt("user_id", DEFAULT_USER_ID);

        this.createTermDepositPresenter.create(ownerId, amount, rate, duration);
    }

    private String getRateValue(TextView textRateValue) {
        return textRateValue.getText().toString().substring(0, textRateValue.getText().length() - 1);
    }

    private Spinner findDurationSpinner() {
        return (Spinner) findViewById(R.id.spinner_term_deposit_duration);
    }

    private void refreshInterest(Double rate, Integer durationInMonths) {
        EditText amountEditText = (EditText) findViewById(R.id.amout_term_deposit_edit);
        String amount = amountEditText.getText().toString();

        if (StringUtils.isNotBlank(amount)) {
            refreshComponent(R.id.interest_value_term_deposit_text_view,
                    String.valueOf(calculateInterest(rate, durationInMonths, amount)));
        }
    }

    private Double calculateInterest(Double rate, Integer durationInMonths, String amount) {
        return new InterestCalculator().calculate(Double.valueOf(amount), rate, durationInMonths);
    }

    private void refreshComponent(int rate_value_term_deposit_text_view, String text) {
        TextView rateTextView = (TextView) findViewById(rate_value_term_deposit_text_view);
        rateTextView.setText(text);
    }

    private String buildRatePercentage(Double rate) {
        return new StringBuilder(String.valueOf(rate)).append(PERCENTAGE).toString();
    }

    private String buildSucessfulMessage(TermDeposit termDeposit) {
        return new StringBuilder("Creacion exitosa de plazo fijo por: ").append(termDeposit.getAmount()).toString();
    }

}
