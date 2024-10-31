package com.alexlasota.al_paper_submission_service.controller;

import com.alexlasota.al_paper_submission_service.model.ResearchPaperDTO;
import com.alexlasota.al_paper_submission_service.service.ResearchPaperService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conference")
public class ResearchPaperController {

    private final ResearchPaperService researchPaperService;

    public ResearchPaperController(ResearchPaperService researchPaperService) {
        this.researchPaperService = researchPaperService;
    }

    @GetMapping
    public List<ResearchPaperDTO> getAllPapers(){
        return researchPaperService.getAllConferences();
    }

    @PostMapping
    public ResearchPaperDTO addPaper(@RequestBody ResearchPaperDTO researchPaperDTO){
        return researchPaperService.saveConference(researchPaperDTO);
    }

    @PutMapping("/{id}")
    public ResearchPaperDTO updatePaper(@PathVariable Long id, @RequestBody ResearchPaperDTO paperDTO){
        return researchPaperService.updateResearchPaper(id, paperDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePaper(@PathVariable Long id){
        researchPaperService.deletePaper(id);
    }
}