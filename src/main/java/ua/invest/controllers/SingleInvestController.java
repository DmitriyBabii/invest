package ua.invest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.invest.models.entities.SingleInvest;
import ua.invest.repositories.SingleInvestRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SingleInvestController {
    @Autowired
    private final SingleInvestRepository singleInvestRepository;

    @GetMapping("/api/single-invests/{userId}")
    public ResponseEntity<List<SingleInvest>> getSingleInvests(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(singleInvestRepository.findAllByUserId(UUID.fromString(userId)), HttpStatus.OK);
    }
}
