package kr.co.selab.selabtodo.web;

import kr.co.selab.selabtodo.domain.Item;
import kr.co.selab.selabtodo.repository.*;
import kr.co.selab.selabtodo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api/todo-list")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> items() {
        return ResponseEntity.ok(itemService.findItems());
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Item> item(@PathVariable Long itemId) {
        Item item = itemService.findById(itemId).get();
        return ResponseEntity.ok(item);
    }

    @PostMapping("/post/list")
    public ResponseEntity<ItemSaveResponseDto> addItem(@Valid @RequestBody ItemSaveRequestDto item) {
        ItemSaveResponseDto savedItem = itemService.save(item);
        return ResponseEntity.ok(savedItem);
    }

    @PatchMapping("/edit/{itemId}")
    public ResponseEntity<ItemUpdateResponseDto> edit(@PathVariable Long itemId, @RequestBody ItemUpdateRequestDto updateParam) {
        ItemUpdateResponseDto updatedItem = itemService.update(itemId, updateParam);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<List<Item>> deleteById(@PathVariable Long itemId) {
        itemService.deleteById(itemId);
        return ResponseEntity.ok(itemService.findItems());
    }

    @DeleteMapping("/delete/lists")
    public void deleteAll() {
        itemService.deleteAll();
    }
}
