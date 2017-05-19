package untref.tesis.gio.infrastructure.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class InvestmentsResponse {

    @SerializedName("investments")
    private List<InvestmentResponse> investments = new ArrayList<>();

    public List<InvestmentResponse> getInvestments() {
        return investments;
    }

}
