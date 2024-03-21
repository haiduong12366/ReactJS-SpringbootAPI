package ReactJSSpringBoot.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ReactJSSpringBoot.Entity.Category;
import ReactJSSpringBoot.repository.CategoryRepository;



@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	// source -> Generate Constructor using Field, xóa super()
	@Override
	// hàm để lưu trữ hoặc cập nhật vào csdl
	public <S extends Category> S save(S entity) {
		// nếu id null có nghĩa là thêm mới
		if (entity.getCategoryId() == null) {
			return categoryRepository.save(entity);
		} else {
			// ngược lại là cập nhật
			// tìm đt để cập nhật dựa vào hàm 
			Optional<Category> opt =	 findById(entity.getCategoryId());
			// kt sự tồn tại trong csdl
			if (opt.isPresent()) {
				if (StringUtils.isEmpty(entity.getIcon())) {
					// nếu icon rỗng thì sd từ đt đã tồn tại từ csdl
					entity.setIcon(opt.get().getIcon());
				} else {
					// nếu ko rỗng thì lấy gtri mới
					// lấy lại images cũ
					entity.setIcon(entity.getIcon());
				}
			}
			// cập nhật
			return categoryRepository.save(entity);
		}
	}

	@Override
	public Optional<Category> findByCategoryName(String name) {
		return categoryRepository.findByCategoryName(name);
	}

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}

	@Override
	public List<Category> findAllById(Iterable<Long> ids) {
		return categoryRepository.findAllById(ids);
	}

	@Override
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public <S extends Category> Optional<S> findOne(Example<S> example) {
		return categoryRepository.findOne(example);
	}

	@Override
	public long count() {
		return categoryRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public void delete(Category entity) {
		categoryRepository.delete(entity);
	}

	@Override
	public List<Category> findByCategoryNameContaining(String name) {
		return categoryRepository.findByCategoryNameContaining(name);
	}

	@Override
	public Page<Category> findByCategoryNameContaining(String name, Pageable pageable) {
		return categoryRepository.findByCategoryNameContaining(name, pageable);
	}
}
