package uz.muhammadtrying.tourfirmproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.muhammadtrying.tourfirmproject.entity.TourPackage;

import java.util.List;

@Repository
public interface TourPackageRepo extends JpaRepository<TourPackage, Integer> {
    List<TourPackage> findAllByOrderByIdAsc();
}
