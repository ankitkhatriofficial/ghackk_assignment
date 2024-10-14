package com.ghackk.assignment.service;

import com.ghackk.assignment.converter.WebtoonsConverter;
import com.ghackk.assignment.document.User;
import com.ghackk.assignment.document.Webtoons;
import com.ghackk.assignment.dto.WebtoonsDto;
import com.ghackk.assignment.repository.WebtoonsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Ankit Khatri
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class WebtoonServiceImpl implements WebtoonsService{

    private final WebtoonsRepository webtoonsRepository;

    private static String getLoggedInUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            User user = (User) authentication.getPrincipal();
            return user.getId().toHexString();
        }
        return null;
    }

    @Override
    public WebtoonsDto createNewWebtoons(WebtoonsDto webtoonsDto) {
        log.info("Request received to create new webtoons:{}", webtoonsDto);
        Webtoons webtoons = WebtoonsConverter.dtoToEntity(webtoonsDto);
        webtoons.setUserId(getLoggedInUserId());
        return WebtoonsConverter.entityToDto(this.webtoonsRepository.save(webtoons));
    }

    @Override
    public WebtoonsDto getWebtoonsById(final String id) {
        Optional<Webtoons> webtoonsOptional = this.webtoonsRepository.findById(new ObjectId(id));
        if(webtoonsOptional.isPresent()) {
            return WebtoonsConverter.entityToDto(webtoonsOptional.get());
        }
        return null;
    }

    @Override
    public WebtoonsDto updateWebtoons(final String id, WebtoonsDto webtoonsDto) {
        log.info("Request received to update webtoons for id:{}, data:{}", id, webtoonsDto);
        Optional<Webtoons> webtoonsOptional = this.webtoonsRepository.findById(new ObjectId(id));
        if(webtoonsOptional.isPresent()) {
            WebtoonsConverter.updateEntity(webtoonsOptional.get(), webtoonsDto);
            return WebtoonsConverter.entityToDto(this.webtoonsRepository.save(webtoonsOptional.get()));
        } else{
            throw new RuntimeException("No webtoons found for this given id");
        }
    }

    @Override
    public void deleteWebtoons(final String id) {
        log.info("Request received to delete webtoons for id:{}", id);
        Optional<Webtoons> webtoonsOptional = this.webtoonsRepository.findById(new ObjectId(id));
        if(webtoonsOptional.isPresent()) {
            if(getLoggedInUserId().equals(webtoonsOptional.get().getUserId())){
                this.webtoonsRepository.deleteById(new ObjectId(id));
            } else{
                throw new RuntimeException("Unauthorised to delete this webtoons");
            }
        }
    }
}
