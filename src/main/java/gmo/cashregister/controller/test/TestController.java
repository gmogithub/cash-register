package gmo.cashregister.controller.test;

import gmo.cashregister.entity.market.Tax;
import gmo.cashregister.entity.test.Test;
import gmo.cashregister.entity.test.Test2;
import gmo.cashregister.entity.test.Test3;
import gmo.cashregister.repositry.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestRepository testRepository;

    @PostMapping("/save")
    public String save () {
        System.out.println("save");
        Test test = new Test();
        test.setCode("00001");
        Set<Test2> tests2 = new HashSet<>();
        Test2 test2 = new Test2();
        test2.setCode("0002");
        test2.setDate(LocalDate.now());
        tests2.add(test2);
        test.setTest2s(tests2);
        Test3 test3 = new Test3();
        test3.setCode("00003");
        test3.setDate(LocalDate.now());
        test.setTest3(test3);
        testRepository.save(test);

        return "test";
    }

    @GetMapping("/tax")
    public Tax tax () {
        Tax tax = new Tax();
        tax.setCode("0001");
        tax.setDescription("tva");
        tax.setName("TVA");
        tax.setRate(19.6);
//        ArrayList<String> strs = new ArrayList<>();
//        Integer.parseInt()
//        strs.forEach((String str) -> {
//
//        });

        return tax;
    }

    @PutMapping("/tax")
    public Tax tax (@RequestBody Tax tax) {
//        Tax tax = new Tax();
//        tax.setCode("0001");
//        tax.setDescription("tva");
//        tax.setName("TVA");
//        tax.setRate(19.6);
        return tax;
    }

}
