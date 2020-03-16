package com.Alaket.service.imple;

import com.Alaket.Dto.ProfileDto;
import com.Alaket.Entity.Profile;
import com.Alaket.repo.ProfileRepository;
import com.Alaket.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    @Transactional
    public ProfileDto save(ProfileDto profileDto) {
        Profile profile = new Profile();
        profile.setName(profileDto.getName());
        profile.setLast_name(profileDto.getLast_name());
        profile.setEmail(profileDto.getEmail());
        profile.setContact(profileDto.getContact());
        profile.setBirth_date(profileDto.getBirth_date());
        profile.setLast_login(profileDto.getLast_login());
        profile.setData_join(profileDto.getData_join());
        profile.setInn(profileDto.getInn());
        profile.setPassport(profileDto.getPassport());
        profile.setIs_superuser(profileDto.getIs_superuser());
        profile.setIs_courier(profileDto.getIs_courier());
        profile.setIs_reciever(profileDto.getIs_reciever());
        profile.setIs_customer(profileDto.getIs_customer());
        profile.setIs_active(profileDto.getIs_active());

//        final Profile profile1=profileRepository.save(profile);
        profileRepository.save(profile);
        profileDto.setId(profileDto.getId());

        return profileDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ProfileDto> getAll() {
        List<Profile> profileList = profileRepository.findAll();
        List<ProfileDto> profileDtos = new ArrayList<>();

        profileList.forEach(it -> {
            ProfileDto profileDto = new ProfileDto();
            profileDto.setId(it.getId());
            profileDto.setName(it.getName());
            profileDto.setLast_name(it.getLast_name());
            profileDto.setEmail(it.getEmail());
            profileDto.setContact(it.getContact());
            profileDto.setBirth_date(it.getBirth_date());
            profileDto.setLast_login(it.getLast_login());
            profileDto.setData_join(it.getData_join());
            profileDto.setInn(it.getInn());
            profileDto.setPassport(it.getPassport());
            profileDto.setIs_superuser(it.getIs_superuser());
            profileDto.setIs_courier(it.getIs_courier());
            profileDto.setIs_reciever(it.getIs_reciever());
            profileDto.setIs_customer(it.getIs_customer());
            profileDto.setIs_active(it.getIs_active());
            profileDtos.add(profileDto);

        });
        return profileDtos;
    }

    @Override
    public Page<ProfileDto> getAll(Pageable pageable) {
        return null;
    }
}
