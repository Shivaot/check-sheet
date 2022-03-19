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
}
