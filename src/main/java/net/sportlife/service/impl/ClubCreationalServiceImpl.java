package net.sportlife.service.impl;

import net.sportlife.dto.AddressDto;
import net.sportlife.dto.ClubDto;
import net.sportlife.dto.RestMessageDto;
import net.sportlife.model.Address;
import net.sportlife.model.Club;
import net.sportlife.repository.AddressRepository;
import net.sportlife.repository.ClubRepository;
import net.sportlife.service.ClubCreationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Service("clubCreationalService")
public class ClubCreationalServiceImpl implements ClubCreationalService {

    private final ClubRepository clubRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public ClubCreationalServiceImpl(ClubRepository clubRepository, AddressRepository addressRepository) {
        this.clubRepository = clubRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    @Override
    public RestMessageDto addClub(Club club) {
        clubRepository.save(club);
        return RestMessageDto.successMsg("Club created!");
    }

    @Transactional
    @Override
    public RestMessageDto getClubById(Long id) {
        System.out.println(clubRepository.getOne(id));
        return RestMessageDto.successMsg("Club by id is retrieved");
    }

    @Transactional
    @Override
    public RestMessageDto getClubs() {
        for(Club club : clubRepository.findAll()) {
            System.out.println(club);
        }
        List<Club> clubs = clubRepository.findAll();
        if(!clubs.isEmpty())
            return RestMessageDto.successMsg("All clubs are retrieved");
        return RestMessageDto.failureMsg("FUCK");
    }

    @Transactional
    @Override
    public RestMessageDto getClubsByCityName(String cityName) {

        List<Club> clubs = clubRepository.findByAddress_CityName(cityName);

        if(!clubs.isEmpty()) {
            for (Club club : clubs)
                System.out.println(club);
            return RestMessageDto.successMsg("Club by city name is retrieved");
        }

        return RestMessageDto.failureMsg("FUCK");
    }

    @Transactional
    @Override
    public RestMessageDto updateClubById(Long id, Club club) {
        Club model = clubRepository.getOne(id);
        if(model != null) {
            model.setClubName(club.getClubName());
            model.setAddress(club.getAddress());
            clubRepository.saveAndFlush(model);

            return RestMessageDto.successMsg("Club with id: " + id + " is updated");
        }

        return RestMessageDto.failureMsg("FUCK");
    }


    //getClubById - valid id ** DONE W/O VALIDATION
    //failure msg send 500 status

    //getClubsByCity ** DONE
    //getClubsAll ** DONE

    //deleteClub
    //updateClub ** DONE
}
