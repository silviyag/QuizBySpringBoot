package myProject.mainApp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myProject.Model.Category;
import myProject.mainApp.Interfaces.CategoryService;
import myProject.mainApp.Repos.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController implements CategoryService{

	private CategoryRepository categoryRepositoy;
	
	  @GetMapping
	    public List<Category> findAll() {
	        return categoryRepositoy.findAll();
	    }

	    @GetMapping(value = "/{id}")
	    public Optional<Category> findById(@PathVariable("id") Long id) {
	        return categoryRepositoy.findById(id);
	    }
	    @DeleteMapping(value = "/{id}")
	    public void delete(@PathVariable("id") Long id) {
	    	categoryRepositoy.deleteById(id);
	    }
}
