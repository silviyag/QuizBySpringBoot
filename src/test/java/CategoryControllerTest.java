import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;

import myProject.Model.Category;
import myProject.mainApp.Repos.CategoryRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

	private Category createRandomCategory() {
		Category category = new Category();
		category.setCategoryTitle("Sport");
		return category;
	}
}
