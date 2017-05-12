package untref.tesis.gio.infrastructure.response;


import com.google.gson.annotations.SerializedName;

import java.util.Set;

public class TermDepositResponses {

    @SerializedName("result")
    private Set<TermDepositResponse> termDepositResponses;

    public TermDepositResponses() {}

    public TermDepositResponses(Set<TermDepositResponse> termDepositResponses) {
        this.termDepositResponses = termDepositResponses;
    }

    public Set<TermDepositResponse> getTermDepositResponses() {
        return termDepositResponses;
    }

}
