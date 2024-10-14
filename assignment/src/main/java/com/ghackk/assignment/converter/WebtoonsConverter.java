package com.ghackk.assignment.converter;

import com.ghackk.assignment.document.Webtoons;
import com.ghackk.assignment.dto.WebtoonsDto;

/**
 * @author Ankit Khatri
 */
public class WebtoonsConverter {

    public static WebtoonsDto entityToDto(final Webtoons webtoons){
        return WebtoonsDto.builder()
                .id(webtoons.getId().toHexString())
                .characters(webtoons.getCharacters())
                .descriptions(webtoons.getDescriptions())
                .title(webtoons.getTitle())
                .build();
    }

    public static Webtoons dtoToEntity(final WebtoonsDto webtoonsDto){
        return Webtoons.builder()
                .characters(webtoonsDto.getCharacters())
                .descriptions(webtoonsDto.getDescriptions())
                .title(webtoonsDto.getTitle())
                .build();
    }

    public static void updateEntity(Webtoons webtoons, WebtoonsDto webtoonsDto){
        webtoons.setTitle(webtoonsDto.getTitle());
        webtoons.setCharacters(webtoonsDto.getCharacters());
        webtoons.setDescriptions(webtoonsDto.getDescriptions());
    }
}
