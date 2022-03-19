package com.ultrasonic.checksheet.service;

import com.ultrasonic.checksheet.domain.CheckSheet;
import com.ultrasonic.checksheet.domain.Revision;
import com.ultrasonic.checksheet.repository.CheckSheetRepository;
import com.ultrasonic.checksheet.repository.RevisionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Shiva Created on 06/03/22
 */
@Service
public class CheckSheetService {

    private final RevisionRepository revisionRepository;
    private final CheckSheetRepository checkSheetRepository;

    public CheckSheetService(RevisionRepository revisionRepository, CheckSheetRepository checkSheetRepository) {
        this.revisionRepository = revisionRepository;
        this.checkSheetRepository = checkSheetRepository;
    }

    public Long getOriginalSheetId(Long checkSheetId) {
         Optional<Revision> revisionOptional = revisionRepository.findByRevisionCheckSheetId(checkSheetId);
         if (revisionOptional.isPresent()) {
             return revisionOptional.get().getOriginalCheckSheetId();
         } else {
             return checkSheetId;
         }
    }

    public List<Revision> getAllRevisions(Long checkSheetId) {
        Optional<Revision> revisionOptional = revisionRepository.findByRevisionCheckSheetId(checkSheetId);
        if (revisionOptional.isPresent()) {
            return revisionRepository.findAllByOriginalCheckSheetId(revisionOptional.get().getOriginalCheckSheetId());
        } else {
            return new ArrayList<>();
        }
    }

    public CheckSheet updateCheckSheet(CheckSheet checkSheet) {
        Optional<CheckSheet> savedCheckSheet = checkSheetRepository.findById(checkSheet.getId());
        savedCheckSheet.get().setIsCurrentRevision(false);

        Optional<Revision> revisionOptional = revisionRepository.findByRevisionCheckSheetId(checkSheet.getId());

        CheckSheet clonedCheckSheet = new CheckSheet();
        BeanUtils.copyProperties(checkSheet, clonedCheckSheet);
        clonedCheckSheet.setId(null);
        clonedCheckSheet.setIsCurrentRevision(true);
        CheckSheet currentCheckSheet = checkSheetRepository.save(clonedCheckSheet);


        if (revisionOptional.isPresent()) {
            Long originalCheckSheetId = revisionOptional.get().getOriginalCheckSheetId();
            createRevision(currentCheckSheet, originalCheckSheetId, revisionRepository.countAllByOriginalCheckSheetId(originalCheckSheetId) + 1);
        } else {
            createRevision(currentCheckSheet, savedCheckSheet.get().getId(), 1);
        }

        checkSheetRepository.save(savedCheckSheet.get());

        return currentCheckSheet;
    }

    private void createRevision(CheckSheet currentCheckSheet, Long originalCheckSheetId, int revisionCount) {
        Revision revision = new Revision();
        revision.setOriginalCheckSheetId(originalCheckSheetId);
        revision.setRevisionCheckSheetId(currentCheckSheet.getId());
        revision.setRevisionName(originalCheckSheetId+"_Revision_"+revisionCount);
        revisionRepository.save(revision);
    }

    public CheckSheet updateWeldorNames(CheckSheet checkSheet, Optional<CheckSheet> optionalCheckSheet) {
        CheckSheet savedCheckSheet = optionalCheckSheet.get();
        savedCheckSheet.setJ7R_Weldor(checkSheet.getJ7R_Weldor());
        savedCheckSheet.setJ12L_Weldor(checkSheet.getJ12L_Weldor());
        savedCheckSheet.setJ8R_Weldor(checkSheet.getJ8R_Weldor());
        savedCheckSheet.setJ13L_Weldor(checkSheet.getJ13L_Weldor());
        savedCheckSheet.setJ11R_Weldor(checkSheet.getJ11R_Weldor());
        savedCheckSheet.setJ16L_Weldor(checkSheet.getJ16L_Weldor());
        savedCheckSheet.setJ5_Weldor(checkSheet.getJ5_Weldor());
        savedCheckSheet.setJ9R_Weldor(checkSheet.getJ9R_Weldor());
        savedCheckSheet.setJ14L_Weldor(checkSheet.getJ14L_Weldor());
        savedCheckSheet.setJ6_Weldor(checkSheet.getJ6_Weldor());
        savedCheckSheet.setJ2_Weldor(checkSheet.getJ2_Weldor());
        savedCheckSheet.setJ10R_Weldor(checkSheet.getJ10R_Weldor());
        savedCheckSheet.setJ15L_Weldor(checkSheet.getJ15L_Weldor());
        savedCheckSheet.setJ3_Weldor(checkSheet.getJ3_Weldor());
        return savedCheckSheet;
    }
}
