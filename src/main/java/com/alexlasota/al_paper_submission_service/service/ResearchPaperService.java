package com.alexlasota.al_paper_submission_service.service;


import com.alexlasota.al_paper_submission_service.mapper.ResearchPaperMapper;
import com.alexlasota.al_paper_submission_service.model.ResearchPaper;
import com.alexlasota.al_paper_submission_service.model.ResearchPaperDTO;
import com.alexlasota.al_paper_submission_service.repository.ResearchPaperRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class ResearchPaperService {

    private final ResearchPaperRepository repository;
    private final ResearchPaperMapper mapper;

    public ResearchPaperService(ResearchPaperRepository repository, ResearchPaperMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<ResearchPaperDTO> getAllConferences() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ResearchPaperDTO saveConference(ResearchPaperDTO researchPaperDTO) {
        ResearchPaper researchPaper = mapper.toEntity(researchPaperDTO);
        return mapper.toDto(repository.save(researchPaper));
    }

    @Transactional
    public ResearchPaperDTO updateResearchPaper(Long id, ResearchPaperDTO updatedPaper) {
        ResearchPaper researchPaper = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paper not found"));

        researchPaper.setAuthor(updatedPaper.getAuthor());
        researchPaper.setTitle(updatedPaper.getTitle());
        researchPaper.setTopic(updatedPaper.getTopic());
        researchPaper.setAbstractText(updatedPaper.getAbstractText());
        researchPaper.setStatus(updatedPaper.getStatus());
        researchPaper.setCoAuthors(updatedPaper.getCoAuthors());
        researchPaper.setConference(updatedPaper.getConference());
        return mapper.toDto(repository.save(researchPaper));
    }

    public void deletePaper (Long id){
        repository.deleteById(id);
    }
}