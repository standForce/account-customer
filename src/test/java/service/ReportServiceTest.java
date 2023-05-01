package service;

import com.transaction.accountcustomer.repository.BalanceRepository;
import com.transaction.accountcustomer.service.ReportService;
import constants.MockData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
 class ReportServiceTest {

    @InjectMocks
    ReportService reportService;

    @Mock
    BalanceRepository balanceRepository;

    @Test

    void  get_report_list_test(){

        Mockito.when(balanceRepository.findBalanceDetails(Mockito.any(), Mockito.any()))
                .thenReturn(Flux.just(MockData.getReportModelList()));

        StepVerifier.create(reportService.getBalanceByDate(LocalDate.now(), LocalDate.now()))
                .expectNextCount(1)
                .verifyComplete();
    }
}
