package com.progresssoft.clustered_data.it;


import com.progresssoft.clustered_data.entity.Deal;
import com.progresssoft.clustered_data.repo.DealRepository;
import com.progresssoft.clustered_data.service.DealService;
import com.progresssoft.clustered_data.utils.CurrencyCode;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@ActiveProfiles("test")
public class DealsIntegrationTest {

    @Autowired
    private DealRepository dealRepository;
    @Autowired
    private DealService dealService;
    @Autowired
    private DataSource dataSource;


    @LocalServerPort
    private int port;


    @Test
    void whenApplicationIsLoadedAllTheBeansShouldBeCreatedAndItShouldUseH2Database() throws SQLException {
        Assertions.assertNotNull(dealService);
        Assertions.assertNotNull(dealRepository);
        Assertions.assertNotNull(dataSource);
        Assertions.assertTrue(dataSource.getConnection().getMetaData().getURL().startsWith("jdbc:h2:"));
    }

    @BeforeEach
    void saveEntity(){
        Deal deal = Deal.builder()
                .id(1L)
                .dealAmount(1.2)
                .fromCurrency(CurrencyCode.AUD)
                .toCurrency(CurrencyCode.USD)
                .dealTimestamp(LocalDateTime.now())
                .build();

        dealRepository.save(deal);
    }

    @Test
    void postingValidDataShouldSucceed(){
        RestAssured.baseURI = "http://localhost:" + port;


        RestAssured.given()
                .baseUri("http://localhost:" + port)
                .basePath("/api/deals")
                .contentType("application/json")
                .body(
                               """
                                {
                                  "deal-id": 3,
                                  "from-currency": "EUR",
                                  "to-currency": "EUR",
                                  "deal-time-stamp": "2024-08-01T12:00:00",
                                  "deal-amount": 1000.00
                                }
                               """
                ).when()
                .post()
                .then()
                .log()
                .body()
                .body("status" , equalTo(true))
                .body("message" , equalTo("Deal created successfully!"));
    }

    @Test
    void postingInvalidCurrencyShouldFail(){
        RestAssured.baseURI = "http://localhost:" + port;


        RestAssured.given()
                .baseUri("http://localhost:" + port)
                .basePath("/api/deals")
                .contentType("application/json")
                .body(
                        """
                         {
                           "deal-id": 4,
                           "from-currency": "UR",
                           "to-currency": "EUR",
                           "deal-time-stamp": "2024-08-01T12:00:00",
                           "deal-amount": 1000.00
                         }
                        """
                ).when()
                .post()
                .then()
                .log()
                .body()
                .body("status" , equalTo(false))
                .body("message" , equalTo("Invalid Arguments"));
    }

    @Test
    void postingPredefinedIdShouldFail(){

        RestAssured.baseURI = "http://localhost:" + port;


        RestAssured.given()
                .baseUri("http://localhost:" + port)
                .basePath("/api/deals")
                .contentType("application/json")
                .body(
                        """
                         {
                           "deal-id": 1,
                           "from-currency": "EUR",
                           "to-currency": "EUR",
                           "deal-time-stamp": "2024-08-01T12:00:00",
                           "deal-amount": 1000.00
                         }
                        """
                ).when()
                .post()
                .then()
                .log()
                .body()
                .body("status" , equalTo(false))
                .body("message" , equalTo("Invalid Arguments"));
    }

}