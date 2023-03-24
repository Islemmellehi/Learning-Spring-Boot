package Demo.MainDemo.ServiceImp;

import Demo.MainDemo.Models.Hotel;
import Demo.MainDemo.Repositories.Hotelrepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HotelServiceImp {
    @Autowired

    private Hotelrepos repository;
    public List<Hotel> listAllHotels(){
        return repository.findAll();
    }
}
