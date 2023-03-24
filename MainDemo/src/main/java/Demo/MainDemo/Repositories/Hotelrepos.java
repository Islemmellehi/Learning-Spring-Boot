package Demo.MainDemo.Repositories;
import Demo.MainDemo.Models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository est une interface (findAllById,delete,saveAll...)
public interface Hotelrepos  extends JpaRepository<Hotel,Long> {
}
