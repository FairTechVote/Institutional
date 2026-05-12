package com.api.institutional_app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.institutional_app.dto.CoordinatorInstituteListResponse;
import com.api.institutional_app.dto.SummaryInstitute;
import com.api.institutional_app.entity.CoordinatorInstitute;
import com.api.institutional_app.exception.NoRecordsFoundException;
import com.api.institutional_app.mapper.InstituteMapper;
import com.api.institutional_app.repository.CoordinatorInstituteRepo;
import com.api.institutional_app.util.Status;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstituteServiceImpl implements InstituteService {

    private final CoordinatorInstituteRepo cirepository;
    private final InstituteMapper instituteMapper;
    
    @Override
    public CoordinatorInstituteListResponse getCoordinatorInstitute(Long request) {
        
        Optional<List<CoordinatorInstitute>> coordinatorInstitute =
            cirepository.findByCoordinatorIdAndStatus(request, Status.ACTIVE);
        if(coordinatorInstitute.isEmpty())
        {
            throw new NoRecordsFoundException("Coordenador não possui institutos associados");
        }

        List<SummaryInstitute> institutes = coordinatorInstitute.get()
                .stream()
                .map(instituteMapper::toSummaryInstitute)
                .collect(Collectors.toList());

        return new CoordinatorInstituteListResponse(institutes);
    }
}
