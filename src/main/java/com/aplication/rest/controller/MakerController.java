package com.aplication.rest.controller;

import com.aplication.rest.controller.dto.MakerDTO;
import com.aplication.rest.entities.Maker;
import com.aplication.rest.repository.MakerRepository;
import com.aplication.rest.service.IMakerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maker")
public class MakerController {

    private final MakerRepository makerRepository;
    private IMakerService makerService;

    public MakerController(IMakerService MakerService, MakerRepository makerRepository) {
        this.makerService = MakerService;
        this.makerRepository = makerRepository;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Optional<Maker> optionalMaker = this.makerService.findById(id);

        if (optionalMaker.isPresent()) {
            Maker maker = optionalMaker.get();

            MakerDTO makerDTO = MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productList(maker.getProductList())
                    .build();
            return ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<MakerDTO> makerDTOList = this.makerService.findAll()
                .stream()
                .map(maker -> MakerDTO.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .productList(maker.getProductList())
                        .build())
                .toList();
        return ResponseEntity.ok(makerDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MakerDTO makerDTO) throws URISyntaxException {

        if (makerDTO.getName().isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        this.makerService.save(Maker.builder()
                .name(makerDTO.getName())
                .build());

        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMaker(@PathVariable Long id,@RequestBody MakerDTO makerDTO){
        Optional<Maker> makerOptional = this.makerService.findById(id);
        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            maker.setName(makerDTO.getName());
            this.makerService.save(maker);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        if (id != null){
            this.makerService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }
}