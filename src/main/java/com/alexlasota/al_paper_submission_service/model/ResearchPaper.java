package com.alexlasota.al_paper_submission_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "conferences")
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"id", "title", "author", "topic"})
public class ResearchPaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "abstract_text", nullable = false)
    private String abstractText;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String topic;

    @Column(nullable = false)
    private String conference;

    @Column(nullable = false)
    private String status;

    @ElementCollection
    @CollectionTable(name = "coauthors", joinColumns = @JoinColumn(name = "conference_id"))
    @Column(name = "coauthor_name")
    private Set<String> coAuthors = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResearchPaper that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}