package com.progresssoft.clustered_data.entity;


import com.progresssoft.clustered_data.utils.CurrencyCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "deals")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "from_currency",
            nullable = false
    )
    private CurrencyCode fromCurrency;

    @Column(
            name = "to_currency",
            nullable = false
    )
    private CurrencyCode toCurrency;

    @Column(
            name = "deal_time_stamp",
            nullable = false
    )
    private LocalDateTime dealTimestamp;

    @Column(
            name = "deal_amount"
    )
    private Double dealAmount;
}
