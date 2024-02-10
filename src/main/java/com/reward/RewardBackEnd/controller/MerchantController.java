package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.model.AuthenticationResponse;
import com.reward.RewardBackEnd.model.Merchant;
import com.reward.RewardBackEnd.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/merchants")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    private static final Logger LOG = LoggerFactory.getLogger(MerchantController.class);

    private final AuthenticationManager authenticationManager;

    @PostMapping("/sign-up")
    public ResponseEntity<AuthenticationResponse> signUp(@RequestBody Merchant merchant) {
        return ResponseEntity.ok(merchantService.register(merchant));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Merchant merchant) {
        LOG.info(" ==== MERCHANT TRYING TO LOGIN WITH ==== ");
        LOG.info(" Email : " + merchant.getMerchantEmail() + " and Password : " + merchant.getPassword());
        LOG.info(" ======================================= ");
        return ResponseEntity.ok(merchantService.authenticate(merchant));
    }

    @PreAuthorize("hasRole('ROLE_MERCHANT')")
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Merchant Dashboard";
    }

//    @PreAuthorize("hasRole('ROLE_MERCHANT')")
//    @GetMapping("/{id}")
//    public ResponseEntity findById(@PathVariable("id") int id) {
//        Optional<Merchant> m = merchantService.findByUserId(id);
//        if(m.isPresent())
//            return new ResponseEntity(m.get(), HttpStatus.OK);
//        return new ResponseEntity("Merchant not found", HttpStatus.NOT_FOUND);
//    }
}
