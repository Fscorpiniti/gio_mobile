package untref.tesis.gio.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import untref.tesis.gio.R;
import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.presentation.activity.DashboardActivity;
import untref.tesis.gio.presentation.activity.DefaultDashboardActivity;

public class ListTermDepositsAdapter extends RecyclerView.Adapter<ListTermDepositsAdapter.ViewHolder> {

    private static final String PLAZO_FIJO_ACTIVO_POR = "Plazo fijo activo por: ";
    private static final String FECHA_DE_VENCIMIENTO = "Fecha de vencimiento: ";
    private static final String PESOS = " pesos.";
    private static final String PATTERN = "dd/M/yyyy";
    private List<TermDeposit> termDeposits;
    private DashboardActivity dashboardActivity;

    public ListTermDepositsAdapter(List<TermDeposit> termDeposits, DashboardActivity dashboardActivity) {
        this.termDeposits = termDeposits;
        this.dashboardActivity = dashboardActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_term_deposit, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String title = new StringBuilder(PLAZO_FIJO_ACTIVO_POR).append(termDeposits.get(position)
                .getAmount().toString()).append(PESOS).toString();
        holder.amount.setText(title);
        String expirationText = new StringBuilder(FECHA_DE_VENCIMIENTO)
                .append(formatExpirationDate(position)).toString();
        holder.expiration.setText(expirationText);
        holder.force.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardActivity.force(termDeposits.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return termDeposits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView amount;
        public TextView expiration;
        public Button force;

        public ViewHolder(View view) {
            super(view);
            amount = (TextView) view.findViewById(R.id.title_term_deposit_list);
            expiration =  (TextView) view.findViewById(R.id.expiration_term_deposit_list);
            force = (Button) view.findViewById(R.id.btn_force);
        }
    }

    private String formatExpirationDate(int position) {
        return new SimpleDateFormat(PATTERN).format(termDeposits.get(position).getExpiration());
    }
}
