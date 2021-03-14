
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import myProject.Model.Category;
import myProject.mainApp.Repos.CategoryRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

	 @Autowired private CategoryRepository categoryRepository;
	 
	   @Test
	    public void testSaveCategory() {

			Category category = new Category("Sport");
			categoryRepository.save(category);
			List<Category> categories = categoryRepository.findAll();
	        assertNotNull(categories);
	    }
}
