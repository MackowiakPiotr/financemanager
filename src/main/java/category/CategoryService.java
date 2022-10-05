package category;

public class CategoryService {
    private static CategoryRepository categoryRepository = new CategoryRepository();

    public void addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.add(category);

    }

    public void deleteCategory(String name) {
        Category category = categoryRepository.findByName(name);
        categoryRepository.delete(category);
    }
}
