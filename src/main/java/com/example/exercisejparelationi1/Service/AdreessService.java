package com.example.exercisejparelationi1.Service;

import com.example.exercisejparelationi1.Api.ApiException;
import com.example.exercisejparelationi1.DTO.AddressDTO;
import com.example.exercisejparelationi1.Model.Addreess;
import com.example.exercisejparelationi1.Model.Teacher;
import com.example.exercisejparelationi1.Repository.AdreessRepository.AdreessRepository;
import com.example.exercisejparelationi1.Repository.TeacherRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdreessService {

    private final AdreessRepository adreessRepository;

private final TeacherRepository teacherRepository;
    public List<Addreess> getAllAddress() {
        return adreessRepository.findAll();
    }

    public void addAdreess(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacheer_id());
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        Addreess addreess=new Addreess(addressDTO.getTeacheer_id(),addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);

        adreessRepository.save(addreess);
    }

    public void updateAdreess(AddressDTO addressDTO) {
        Addreess addreess = adreessRepository.findAddreessById(addressDTO.getTeacheer_id());
        if (addreess == null) {
            throw new ApiException("Addreess not found");
        }
        addreess.setArea(addressDTO.getArea());
        addreess.setStreet(addressDTO.getStreet());
        addreess.setBuildingNumber(addressDTO.getBuildingNumber());
        adreessRepository.save(addreess);
    }

    public void deleteAdreess(Integer id) {

        if (adreessRepository.findAddreessById(id)==null){
            throw new ApiException("Addreess not found");

        }
        teacherRepository.deleteById(id);
    }


}
