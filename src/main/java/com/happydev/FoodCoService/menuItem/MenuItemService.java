package com.happydev.FoodCoService.menuItem;

import com.happydev.FoodCoService.exception.CustomMessageException;
import com.happydev.FoodCoService.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MenuItemService {

    private final MenuItemRepository repository;

    @Autowired
    public MenuItemService(MenuItemRepository repository) {
        this.repository = repository;
    }

    public List<MenuItem> getMenuItems() {
        return repository.findAll();
    }

    public String saveMenuItem(MenuItem menuItem) {
        menuItem.setMenuItemId(UUID.randomUUID().toString());
        repository.save(menuItem);
        return menuItem.getMenuItemId();
    }

    public MenuItem getMenuItem(String menuItemId) throws CustomMessageException {
        if(repository.findById(menuItemId).isEmpty())
            throw new CustomMessageException(Constants.MENU_ITEM_NOT_FOUND_WITH_ID+menuItemId);
        return repository.findById(menuItemId).get();
    }

    public String updateMenuItem(MenuItem menuItem) throws CustomMessageException {
        if (repository.findById(menuItem.getMenuItemId()).isPresent()) {
            repository.save(menuItem);
            return Constants.ITEM_UPDATED_SUCCESSFULLY;
        }
        else throw new CustomMessageException(Constants.MENU_ITEM_NOT_FOUND_WITH_ID+menuItem.getMenuItemId());
    }

    public List<MenuItem> getMenuItemsByRestId(String restId) {
        return repository.findAll().stream()
                .filter(mi -> mi.getRestId().equals(restId))
                .toList();
    }

    public String removeMenuItem(String menuItemId) throws CustomMessageException {
        if (repository.findById(menuItemId).isPresent()) {
            repository.deleteById(menuItemId);
            return Constants.ITEM_REMOVED_SUCCESSFULLY;
        }
        else throw new CustomMessageException(Constants.MENU_ITEM_NOT_FOUND_WITH_ID+menuItemId);
    }
}
