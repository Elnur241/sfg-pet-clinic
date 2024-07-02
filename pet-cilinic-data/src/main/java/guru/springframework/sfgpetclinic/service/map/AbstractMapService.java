package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {
    protected Map< Long,T>hashMap=new HashMap<>();
    Set<T> findAll(){
     return new HashSet<>(hashMap.values());
    }
    T findByLastName(String lastName){
       return hashMap.values().stream().filter(x->x.getId().equals(1L)).findFirst().orElse(null);
    }
    T findById(ID id){
        return hashMap.get(id);
    }
    T save(T object){
        if(object!=null){
            if(object.getId()==null){
                object.setId(getNextId());
            }
            hashMap.put(object.getId(),object);
        }else {
            throw new RuntimeException("object cannot be null");
        }

        return object;
    }
    void deleteById(ID id){
        hashMap.remove(id);
    }
    void delete(T object){
        hashMap.entrySet().removeIf(entry->entry.getValue().equals(object));
    }
    private Long getNextId(){
      Long nextId=null;
     try {
          nextId = Collections.max(hashMap.keySet()) + 1L;
      }catch (NoSuchElementException ex){
          nextId=1L;
      }
     return nextId;
    }
}
