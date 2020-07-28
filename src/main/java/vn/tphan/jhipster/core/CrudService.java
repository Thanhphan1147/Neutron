package vn.tphan.jhipster.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
public class CrudService<T extends AbstractEntity, ID extends Serializable> {
    private static Logger logger = LoggerFactory.getLogger(vn.tphan.jhipster.core.CrudService.class);
    protected CustomJpaRepository<T, ID> repository;

    public T get(ID id) {
        return repository.getOne(id);
    }


    public List<T> findAll() {
        return repository.findAll();
    }

    public T create(T entity) {
        beforeCreate(entity);
        repository.save(entity);
        afterCreate(entity);
        return entity;
    }

    protected void beforeCreate(T entity) {
        entity.setCreated(System.currentTimeMillis());
        entity.setUpdated(System.currentTimeMillis());
        if(entity.getCreatedBy() == null) {
            entity.setCreatedBy("admin");
        }
    }

    protected void afterCreate(T entity) {
        logger.info("Created {}", entity);
    }

    protected void afterUpdate(T old, T updated) {
        logger.info("Updated {}", old);
    }
}
