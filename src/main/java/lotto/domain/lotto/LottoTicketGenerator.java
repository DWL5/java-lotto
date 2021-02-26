package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {
    protected static final int PRICE_EACH_LOTTO = 1000;

    private static LottoTicketGenerator instance;
    private final RandomLottoGenerator randomLottoGenerator;

    private LottoTicketGenerator() {
        randomLottoGenerator = new RandomLottoGenerator();
    }

    public static LottoTicketGenerator getInstance() {
        if (instance == null) {
            instance = new LottoTicketGenerator();
        }

        return instance;
    }


    public LottoTicket createLottoTicket(LottoTicketBuyingRequest lottoTicketBuyingRequest) {
        List<LottoLine> autoLottoLineList = new ArrayList();
        for (int i = 0; i < lottoTicketBuyingRequest.getAutoLottoAmount(); i++) {
            autoLottoLineList.add(new LottoLine(randomLottoGenerator.createLottoLine()));
        }

        return new LottoTicket(autoLottoLineList, lottoTicketBuyingRequest.getManualLottoLineList());
    }
}
