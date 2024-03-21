package ReactJSSpringBoot.repository;



import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ReactJSSpringBoot.Entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
	List<Category> findByCategoryNameContaining(String name);
	//Tìm kiếm và Phân trang
	Page<Category> findByCategoryNameContaining(String name,Pageable pageable);
	Optional<Category> findByCategoryName(String name);


}
