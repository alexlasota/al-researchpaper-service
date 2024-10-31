package com.alexlasota.al_paper_submission_service.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.NotFound;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResearchPaperDTO {
    private Long id;

    @NotNull(message = "Abstract cannot be null")
    private String title;

    @NotNull(message = "Abstract cannot be null")
    private String abstractText;

    @NotNull(message = "Author cannot be null")
    private String author;

    @NotNull(message = "Topic cannot be null")
    private String topic;

    @NotNull(message = "Conference cannot be null")
    private String conference;

    @NotNull(message = "Status cannot be null")
    private String status;

    private Set<String> coAuthors;
}