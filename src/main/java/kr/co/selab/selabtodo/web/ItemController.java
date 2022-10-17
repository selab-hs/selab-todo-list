package kr.co.selab.selabtodo.web;

import kr.co.selab.selabtodo.domain.Item;
import kr.co.selab.selabtodo.repository.ItemSaveRequestDto;
import kr.co.selab.selabtodo.repository.ItemSaveResponseDto;
import kr.co.selab.selabtodo.repository.ItemUpdateRequestDto;
import kr.co.selab.selabtodo.repository.ItemUpdateResponseDto;
import kr.co.selab.selabtodo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public List<Item> items() {
        return itemService.findItems();
    }

    @GetMapping("/{itemId}")
    public Item item(@PathVariable Long itemId) {
        Item item = itemService.findById(itemId).get();
        return item;
    }

    @PostMapping("/add")
    public ItemSaveResponseDto addItem(@RequestBody ItemSaveRequestDto item) {
        ItemSaveResponseDto savedItem = itemService.save(item);
        return savedItem;
    }

    @PatchMapping("/{itemId}/edit")
    public ItemUpdateResponseDto edit(@PathVariable Long itemId, @RequestBody ItemUpdateRequestDto updateParam) {
        System.out.println("수정");
        ItemUpdateResponseDto updatedItem = itemService.update(itemId, updateParam);
        return updatedItem;
    }

    @DeleteMapping("/{itemId}/delete")
    public List<Item> deleteById(@PathVariable Long itemId) {
        itemService.deleteById(itemId);
        return itemService.findItems();
    }

    @DeleteMapping("/delete")
    public void deleteAll() {
        itemService.deleteAll();
    }
}
