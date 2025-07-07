package com.lykke.service;

import com.lykke.model.TravelOption;
import com.lykke.repository.TravelOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelOptionService {

    @Autowired
    private TravelOptionRepository travelOptionRepository;

    public List<TravelOption> getAvailableOptions(String source, String destination, String type) {
        return travelOptionRepository.findAll().stream()
                .filter(opt -> (source == null || opt.getSource().equalsIgnoreCase(source))
                        && (destination == null || opt.getDestination().equalsIgnoreCase(destination))
                        && (type == null || opt.getType().equalsIgnoreCase(type)))
                .collect(Collectors.toList());
    }
}