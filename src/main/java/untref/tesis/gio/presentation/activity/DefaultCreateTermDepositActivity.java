package untref.tesis.gio.presentation.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
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
    private static final String DEFAULT_NUMBER_VALUE = "0";
    private static final String DEFAULT_TOKEN = "0";
    private CreateTermDepositPresenter createTermDepositPresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_term_deposit_activity);
        Spinner spinner = findDurationSpinner();
        spinner.setOnItemSelectedListener(this);
        addListenerToAmountEditText();
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
    public void refreshByChangeRate(Double rate, Integer duration) {
        refreshComponent(R.id.rate_value_term_deposit_text_view, buildRatePercentage(rate));
        refreshInterest(rate, duration);
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

        Double amount = Double.valueOf(getValidAmount(editAmount));
        Double rate = Double.valueOf(getRateValue(textRateValue));
        Integer duration = Integer.valueOf(durationSelected);

        SharedPreferences sharedPref = getSharedPreferences("user", Context.MODE_PRIVATE);
        Integer ownerId = sharedPref.getInt("user_id", DEFAULT_USER_ID);
        String authToken = sharedPref.getString("auth_token", DEFAULT_TOKEN);

        this.createTermDepositPresenter.create(ownerId, amount, rate, duration, authToken);
    }

    private String getValidAmount(EditText editAmount) {
        String amountText = editAmount.getText().toString();
        if (StringUtils.isBlank(amountText)) {
            return DEFAULT_NUMBER_VALUE;
        }
        return amountText;
    }

    private String getRateValue(TextView textRateValue) {
        String rateText = textRateValue.getText().toString();
        if(StringUtils.isBlank(rateText)) {
            return DEFAULT_NUMBER_VALUE;
        }
        return rateText.substring(0, textRateValue.getText().length() - 1);
    }

    private Spinner findDurationSpinner() {
        return (Spinner) findViewById(R.id.spinner_term_deposit_duration);
    }

    private void refreshInterest(Double rate, Integer duration) {
        EditText amountEditText = (EditText) findViewById(R.id.amout_term_deposit_edit);
        String amount = amountEditText.getText().toString();

        if (StringUtils.isNotBlank(amount)) {
            refreshComponent(R.id.interest_value_term_deposit_text_view,
                    String.valueOf(calculateInterest(rate, duration, amount)));
        } else {
            refreshComponent(R.id.interest_value_term_deposit_text_view, DEFAULT_NUMBER_VALUE);
        }
    }

    private Double calculateInterest(Double rate, Integer duration, String amount) {
        return new InterestCalculator().calculate(Double.valueOf(amount), rate, duration);
    }

    private void refreshComponent(int componentId, String text) {
        TextView rateTextView = (TextView) findViewById(componentId);
        rateTextView.setText(text);
    }

    private String buildRatePercentage(Double rate) {
        return new StringBuilder(String.valueOf(rate)).append(PERCENTAGE).toString();
    }

    private String buildSucessfulMessage(TermDeposit termDeposit) {
        return new StringBuilder("Creacion exitosa de plazo fijo por: ").append(termDeposit.getAmount()).toString();
    }

    private void addListenerToAmountEditText() {
        EditText editText = (EditText) findViewById(R.id.amout_term_deposit_edit);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                Spinner spinner = findDurationSpinner();
                onItemSelected(spinner, editText.getRootView(), spinner.getSelectedItemPosition(),
                        spinner.getId());
            }
        });
    }
}
