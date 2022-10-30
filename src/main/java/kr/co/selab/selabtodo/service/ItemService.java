package kr.co.selab.selabtodo.service;

import kr.co.selab.selabtodo.domain.Item;
import kr.co.selab.selabtodo.exception.CustomException;
import kr.co.selab.selabtodo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static kr.co.selab.selabtodo.exception.ErrorCode.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemSaveResponseDto save(ItemSaveRequestDto item) {
        Item savedItem = new Item(item.getTitle(), item.getOrder());
        itemRepository.save(savedItem);

        ItemSaveResponseDto savedDto = new ItemSaveResponseDto(
                savedItem.getId(),
                savedItem.getTitle(),
                savedItem.getOrder(),
                savedItem.getCompleted());
        return savedDto;
    }

    @Transactional
    public ItemUpdateResponseDto update(Long itemId, ItemUpdateRequestDto updateParam) {
        Item updatedItem = itemRepository.findById(itemId).orElseThrow(() -> new CustomException(ID_NOT_FOUND));

        updatedItem.setTitle(updateParam.getTitle());
        updatedItem.setOrder(updateParam.getOrder());
        updatedItem.setCompleted(updateParam.getCompleted());

        ItemUpdateResponseDto updatedDto = new ItemUpdateResponseDto(
                updatedItem.getId(),
                updatedItem.getTitle(),
                updatedItem.getOrder(),
                updatedItem.getCompleted());
        return updatedDto;
    }

    public Optional<ItemRepositoryDto> findById(Long id) {
        Optional<Item> findItem = itemRepository.findById(id);
        ItemRepositoryDto findItemDto = new ItemRepositoryDto(
                findItem.orElseThrow(() -> new CustomException(ID_NOT_FOUND))
        );
        return Optional.of(findItemDto);
    }

    public List<ItemRepositoryDto> findItems() {
        return itemRepository.findAll().stream()
                .map(ItemRepositoryDto::new)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        if (itemRepository.existsById(id) == false) {
            throw new CustomException(ID_NOT_FOUND);
        }
        itemRepository.deleteById(id);
    }

    public void deleteAll() {
        itemRepository.deleteAllInBatch();
    }
}
