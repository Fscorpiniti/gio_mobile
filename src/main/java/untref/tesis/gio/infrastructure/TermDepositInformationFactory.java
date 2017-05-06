package untref.tesis.gio.infrastructure;

import untref.tesis.gio.domain.TermDepositInformation;

public class TermDepositInformationFactory {

    public static TermDepositInformation build(TermDepositInformationResponse response) {
        return new TermDepositInformation(response.getMonthlyRate(), response.getBiMonthlyRate(),
                response.getQuarterlyRate(), response.getSemiAnnualRate(), response.getAnnualRate());
    }

}
