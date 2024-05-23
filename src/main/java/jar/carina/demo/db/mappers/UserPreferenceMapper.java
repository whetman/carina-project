package jar.carina.demo.db.mappers;

import jar.carina.demo.db.models.UserPreference;

public interface UserPreferenceMapper {

	void create(UserPreference userPreference);

	UserPreference findById(Long id);
}
