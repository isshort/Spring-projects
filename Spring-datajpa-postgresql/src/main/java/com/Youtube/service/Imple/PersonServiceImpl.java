package com.Youtube.service.Imple;

import com.Youtube.Dto.PersonDto;
import com.Youtube.Entity.Address;
import com.Youtube.Entity.Person;
import com.Youtube.repo.AddressRepository;
import com.Youtube.repo.PersonRepository;
import com.Youtube.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // for PersonRepository
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    //bir kisi gelip kaydetigi anda address
    private final AddressRepository addressRepository;


    @Override
    @Transactional //that's automate save to database
    public PersonDto save(PersonDto personDto) {
        //save person to database
        Person person=new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());

        final Person personDB=personRepository.save(person);

        List<Address> liste=new ArrayList<>();
        //save the person address to database because one person has more then one address
        personDto.getAddress().forEach(item->{
            Address address=new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.Home_Address);
            address.setActive(true);
            address.setPerson(personDB);
            liste.add(address);

        });
        addressRepository.saveAll(liste);

        //Person'un id'isi gonder diye
        personDto.setId(personDto.getId());

        return personDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList= personRepository.findAll();
        List<PersonDto> personDtos=new ArrayList<>();
        personList.forEach(it ->{
            PersonDto personDto=new PersonDto();
            personDto.setId(it.getId());
            personDto.setName(it.getName());
            personDto.setSurname(it.getSurname());
            personDto.setAddress(it.getAddressList().
                    stream().map(Address::getAddress).collect(Collectors.toList()));// burada ki addresslerin isimleri alip listelere ekliyoruz bir list olrak personDto'ye doldur diye
            personDtos.add(personDto);
        });
        return personDtos;
    }

    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}
