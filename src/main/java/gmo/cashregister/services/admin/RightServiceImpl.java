package gmo.cashregister.services.admin;

import gmo.cashregister.entity.security.Right;
import gmo.cashregister.repositry.admin.RightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RightServiceImpl implements RightService {
    @Autowired
    private RightRepository rightRepository;

    @Override
    @Transactional
    public List<Right> getRights() {
        return rightRepository.getRights();
    }

    @Override
    @Transactional
    public Right getRight(long id) {
        return rightRepository.getRight(id);
    }

    @Override
    @Transactional
    public List<Right> save(Right right) {
        boolean hasSave = rightRepository.save(right);
        List<Right> list = rightRepository.getRights();
        return list;
    }

    @Override
    @Transactional
    public List<Right> update(Right right) {
        boolean hasUpdate = rightRepository.update(right);
        List<Right> list = rightRepository.getRights();
        return list;
    }

    @Override
    @Transactional
    public List<Right> delete(long id) {
        Right right = rightRepository.getRight(id);
        boolean hasDelete = rightRepository.delete(right);
        List<Right> list = rightRepository.getRights();
        return list;
    }

}
