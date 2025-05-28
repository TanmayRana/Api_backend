package com.example.demomyapp.models;

import com.example.demomyapp.utils.JsonToListConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    private Integer id;

    private String etag;
    private String title;
    private String subtitle;

    @Convert(converter = JsonToListConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> authors;

    @Column(name = "published_date")
    private String publishedDate;

    private String description;

    @Column(name = "isbn_10")
    private String isbn10;

    @Column(name = "isbn_13")
    private String isbn13;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "print_type")
    private String printType;

    @Convert(converter = JsonToListConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> categories;

    @Column(name = "maturity_rating")
    private String maturityRating;

    @Column(name = "allow_anon_logging")
    private Boolean allowAnonLogging;

    @Column(name = "content_version")
    private String contentVersion;

    @Column(name = "image_small_thumbnail")
    private String imageSmallThumbnail;

    @Column(name = "image_thumbnail")
    private String imageThumbnail;

    private String language;

    @Column(name = "preview_link")
    private String previewLink;

    @Column(name = "info_link")
    private String infoLink;

    @Column(name = "canonical_volume_link")
    private String canonicalVolumeLink;

    @Column(name = "sale_country")
    private String saleCountry;

    private String saleability;

    @Column(name = "is_ebook")
    private Boolean isEbook;

    private String viewability;
    private Boolean embeddable;

    @Column(name = "public_domain")
    private Boolean publicDomain;

    @Column(name = "text_to_speech_permission")
    private String textToSpeechPermission;

    @Column(name = "epub_available")
    private Boolean epubAvailable;

    @Column(name = "pdf_available")
    private Boolean pdfAvailable;

    @Column(name = "access_view_status")
    private String accessViewStatus;

    @Column(name = "quote_sharing_allowed")
    private Boolean quoteSharingAllowed;

    private String snippet;
}
