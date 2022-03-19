package com.ultrasonic.checksheet.service;

import com.ultrasonic.checksheet.domain.CheckSheet;
import com.ultrasonic.checksheet.repository.CheckSheetRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Shiva Created on 05/03/22
 */
@Service
public class OperatorService {

    private final CheckSheetRepository checkSheetRepository;

    public OperatorService(CheckSheetRepository checkSheetRepository) {
        this.checkSheetRepository = checkSheetRepository;
    }

    public Page<CheckSheet> findPaginated(Pageable pageable) {
        List<CheckSheet> checkSheets = checkSheetRepository.findAllByIsCurrentRevisionOrderByIdDesc(true);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<CheckSheet> list;

        if (checkSheets.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, checkSheets.size());
            list = checkSheets.subList(startItem, toIndex);
        }

        Page<CheckSheet> checkSheetPage
                = new PageImpl<CheckSheet>(list, PageRequest.of(currentPage, pageSize), checkSheets.size());

        return checkSheetPage;
    }

}
