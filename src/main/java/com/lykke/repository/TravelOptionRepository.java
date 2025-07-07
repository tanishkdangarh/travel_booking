package com.lykke.repository;

import com.lykke.model.TravelOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelOptionRepository extends JpaRepository<TravelOption, Long> {
    // You can add custom query methods here if needed
}