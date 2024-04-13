package com.ibrahim.codisc.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="tag_data")
public class Tag {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long tagId;
    @Column(name = "tag")
    private String tagName;
    private float rating;

    
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ContentId")
    private Content content;

    @Transient
    private Long userId;

    @Transient
    private Long contentId;


}
