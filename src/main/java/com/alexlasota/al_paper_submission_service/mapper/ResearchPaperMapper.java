package com.alexlasota.al_paper_submission_service.mapper;

import com.alexlasota.al_paper_submission_service.model.ResearchPaper;
import com.alexlasota.al_paper_submission_service.model.ResearchPaperDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResearchPaperMapper {

    ResearchPaper toEntity(ResearchPaperDTO researchPaperDTO);

    ResearchPaperDTO toDto(ResearchPaper researchPaper);

}