package com.ibrahim.codisc.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name="content_data")
public class Content {
    

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long contentId;
    private String contentName;
    private String description;
    private String ratings;
    private String creater;

    @JsonIgnore
    @OneToMany(mappedBy = "content")
    private List<Tag> tag;


}
