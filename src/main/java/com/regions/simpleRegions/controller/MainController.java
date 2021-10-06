package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.entity.RussiaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    RussiaService russiaService;

    @Autowired
    UkraineService ukraineService;

    @Autowired
    BelarusService belarusService;

    @Autowired
    PolandService polandService;

    @Autowired
    CzechService czechService;

    @Autowired
    MoldovaService moldovaService;

    @Autowired
    LithuaniaService lithuaniaService;

    @Autowired
    TurkeyService turkeyService;

    @Autowired
    EstoniaService estoniaService;

    @Autowired
    GermanService germanService;

    @Autowired
    SlovakiaService slovakiaService;

    @Autowired
    BulgariaService bulgariaService;

    @Autowired
    AustriaService austriaService;

    @Autowired
    GreeceService greeceService;

    @Autowired
    IrelandService irelandService;

    @Autowired
    RomaniaService romaniaService;

    @Autowired
    SloveniaService sloveniaService;

    @Autowired
    FranceService franceService;

    @Autowired
    CroatiaService croatiaService;

    @Autowired
    MontenegroService montenegroService;

    @Autowired
    KosovoService kosovoService;

    @Autowired
    SwitzerlandService switzerlandService;

    @Autowired
    HungaryService hungaryService;

    @Autowired
    ItalianService italianService;


    public ResponseEntity createRegion(@RequestBody RussiaEntity russia) {
        try {
            russiaService.createRegion(russia);
            return ResponseEntity.ok("Region is saved.");
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/russia")
    public ResponseEntity getRussiaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(russiaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/ukraine")
    public ResponseEntity getUkraineRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(ukraineService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/belarus")
    public ResponseEntity getBelarusRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(belarusService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/poland")
    public ResponseEntity getPolandRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(polandService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/czech")
    public ResponseEntity getCzechRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(czechService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/moldova")
    public ResponseEntity getMoldovaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(moldovaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/lithuania")
    public ResponseEntity getLithuaniaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(lithuaniaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/turkey")
    public ResponseEntity getTurkeyRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(turkeyService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/estonia")
    public ResponseEntity getEstoniaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(estoniaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/german")
    public ResponseEntity getGermanRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(germanService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/slovakia")
    public ResponseEntity getSlovakiaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(slovakiaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/bulgaria")
    public ResponseEntity getBulgariaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(bulgariaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/austria")
    public ResponseEntity getAustriaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(austriaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/greece")
    public ResponseEntity getGreeceRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(greeceService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/ireland")
    public ResponseEntity getIrelandRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(irelandService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/romania")
    public ResponseEntity getRomaniaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(romaniaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/slovenia")
    public ResponseEntity getSloveniaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(sloveniaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/france")
    public ResponseEntity getFranceRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(franceService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/croatia")
    public ResponseEntity getCroatiaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(croatiaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/montenegro")
    public ResponseEntity getMontenegroRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(montenegroService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/kosovo")
    public ResponseEntity getKosovoRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(kosovoService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/switzerland")
    public ResponseEntity getSwitzerlandRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(switzerlandService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/hungary")
    public ResponseEntity getHungaryRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(hungaryService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/italian")
    public ResponseEntity getItalianRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(italianService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
