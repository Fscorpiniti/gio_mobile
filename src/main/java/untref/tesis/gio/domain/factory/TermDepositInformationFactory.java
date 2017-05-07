package untref.tesis.gio.domain.factory;

import untref.tesis.gio.domain.entity.TermDepositInformation;
import untref.tesis.gio.infrastructure.response.TermDepositInformationResponse;

public class TermDepositInformationFactory {

    public static TermDepositInformation build(TermDepositInformationResponse response) {
        return new TermDepositInformation(response.getMonthlyRate(), response.getBiMonthlyRate(),
                response.getQuarterlyRate(), response.getSemiAnnualRate(), response.getAnnualRate());
    }

}
