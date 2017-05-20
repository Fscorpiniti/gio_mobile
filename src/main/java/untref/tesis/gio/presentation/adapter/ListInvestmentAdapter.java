package untref.tesis.gio.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import untref.tesis.gio.R;
import untref.tesis.gio.domain.entity.Investment;
import untref.tesis.gio.presentation.activity.DashboardActivity;

public class ListInvestmentAdapter extends RecyclerView.Adapter<ListInvestmentAdapter.ViewHolder>  {

    private List<Investment> investments;
    private DashboardActivity dashboardActivity;

    public ListInvestmentAdapter(List<Investment> investments, DashboardActivity dashboardActivity) {
        this.investments = investments;
        this.dashboardActivity = dashboardActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Investment investment = investments.get(position);

        String title = new StringBuilder(investment.getName()).toString();
        String subTitle = new StringBuilder("Monto de inversion : ").append(investment.getAmount()).toString();
        holder.title.setText(title);
        holder.subtitle.setText(subTitle);
        holder.force.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardActivity.force(investment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return investments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView subtitle;
        public Button force;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title_list);
            subtitle =  (TextView) view.findViewById(R.id.sub_title_list);
            force = (Button) view.findViewById(R.id.btn_force);
        }
    }
}
