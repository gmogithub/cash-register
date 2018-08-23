package gmo.cashregister.controller.admin;

import gmo.cashregister.entity.security.Right;
import gmo.cashregister.services.admin.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/rights")
//@CrossOrigin(origins = "*")
public class RightController {
    @Autowired
    private RightService rightService;

    @GetMapping("")
    public List<Right> getRights() {
        List<Right> rights = rightService.getRights();
        return rights;
    }

    @GetMapping("/{id}")
    public Right getRight(@PathVariable(name = "id") long id) {
        Right right = rightService.getRight(id);
        return right;
    }

    @PostMapping("")
    public List<Right> save(@RequestBody Right right) {
        // boolean valid = rightService.save(right);
        return rightService.save(right);
    }

    @PutMapping("")
    public List<Right> update(@RequestBody Right right) {
        // boolean valid = rightService.save(right);
        return rightService.update(right);
    }

    @DeleteMapping("/{id}")
    public List<Right> delete(@PathVariable(name = "id") long id) {
        return rightService.delete(id);
    }


}
