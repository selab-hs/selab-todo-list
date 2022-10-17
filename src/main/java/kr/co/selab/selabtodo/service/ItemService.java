package kr.co.selab.selabtodo.service;

import kr.co.selab.selabtodo.domain.Item;
import kr.co.selab.selabtodo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemSaveResponseDto save(ItemSaveRequestDto item) {
        Item savedItem = new Item(item.getTitle(), item.getOrder());
        itemRepository.save(savedItem);
        ItemSaveResponseDto savedDto = new ItemSaveResponseDto(savedItem.getId(), savedItem.getTitle(), savedItem.getOrder(), savedItem.getCompleted());
        return savedDto;
    }

    public ItemUpdateResponseDto update(Long itemId, ItemUpdateRequestDto updateParam) {
        Item updatedItem = itemRepository.findById(itemId).orElseThrow();

        if (updateParam.getTitle() != null) {
            updatedItem.setTitle(updateParam.getTitle());
        }

        if (updateParam.getOrder() != null) {
            updatedItem.setOrder(updateParam.getOrder());
        }

        if (updateParam.getCompleted() != null) {
            updatedItem.setCompleted(updateParam.getCompleted());
        }

        itemRepository.save(updatedItem);

        ItemUpdateResponseDto updatedDto = new ItemUpdateResponseDto(updatedItem.getId(), updatedItem.getTitle(), updatedItem.getOrder(), updatedItem.getCompleted());
        return updatedDto;
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }

    public void deleteAll() {
        itemRepository.deleteAllInBatch();
    }
}
