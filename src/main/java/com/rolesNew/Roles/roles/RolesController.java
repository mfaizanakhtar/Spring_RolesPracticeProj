package com.rolesNew.Roles.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RolesController {
    @Autowired
    RolesRepository repository;

//    @Autowired
//    private ModelMapper modelMapper;

    @GetMapping("/getAll")
    public List<Roles> getAllRoles(){
        List<Roles> rolesList = repository.findAll();
        return rolesList;
    }

    @GetMapping("/getRole/{id}")
    public Roles getRoleById(@PathVariable int id){
        Optional<Roles> findRole = repository.findById(id);
        if(findRole.get()==null){
            throw new RolesNotFoundException("Not Found");
        }
        return findRole.get();
    }

    @PostMapping("/addRole")
    public Roles addRole(@RequestBody Roles role){
        Roles savedRole = repository.save(role);

        return savedRole;
    }

    @PutMapping("/updateRole/{id}")
    public Roles updateRole(@PathVariable int id,@RequestBody Roles role){
        Optional<Roles> FindroleObj = repository.findById(id);
        if(FindroleObj.get()==null){
            throw new RolesNotFoundException("Can not Update. Not Found");
        }
        role.setId(id);
        return repository.save(role);

    }

    @PutMapping("/updateRolePartial/{id}")
    public Roles updateRolePartial(@PathVariable int id,
                                   @Param("desc") String desc,@Param("status")Boolean status){

        Optional<Roles> FindroleObj = repository.findById(id);
        if(FindroleObj.get()==null){
            throw new RolesNotFoundException("Can not Update. Not Found");
        }

        if(desc!=null) FindroleObj.get().setDescription(desc);
        if(status!=null) FindroleObj.get().setStatus(status);

        return repository.save(FindroleObj.get());

    }

    @DeleteMapping("/deleteRole/{id}")
    public void deleteRole(@PathVariable int id){
        Optional<Roles> FindroleObj = repository.findById(id);
        if(FindroleObj.get()==null){
            throw new RolesNotFoundException("Can Not delete. Role not Found");
        }
        repository.deleteById(id);
    }
}
