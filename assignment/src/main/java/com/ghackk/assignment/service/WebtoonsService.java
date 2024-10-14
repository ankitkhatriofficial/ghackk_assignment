package com.ghackk.assignment.service;

import com.ghackk.assignment.dto.WebtoonsDto;

/**
 * @author Ankit Khatri
 */
public interface WebtoonsService {

    WebtoonsDto createNewWebtoons(WebtoonsDto webtoonsDto);

    WebtoonsDto getWebtoonsById(final String id);

    WebtoonsDto updateWebtoons(final String id, WebtoonsDto webtoonsDto);

    void deleteWebtoons(final String id);
}
