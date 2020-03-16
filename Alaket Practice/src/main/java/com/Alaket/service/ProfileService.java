package com.Alaket.service;

import com.Alaket.Dto.ProfileDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProfileService {
    ProfileDto save(ProfileDto profileDto);
    void delete(Long id);
    List<ProfileDto>getAll();
    Page<ProfileDto> getAll(Pageable pageable);
}
