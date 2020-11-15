package com.ucinae.root.dto.request;

import com.ucinae.root.movie.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FilmRequest {
    @NotBlank
    private String title;
    @NotNull
    private Date releaseDate;
    @Length(max = 100)
    private String overview;
    @NotNull
    private Long budget;
    private Genre genre;
}
