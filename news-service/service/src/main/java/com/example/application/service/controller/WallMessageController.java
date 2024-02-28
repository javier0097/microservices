package com.example.application.service.controller;


import com.example.application.api.input.WallMessageCreateInput;
import com.example.application.service.model.domain.Bulletin;
import com.example.application.service.service.IBulletinService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Api(
//        tags = "Wall message",
//        description = "Operation over wall messages"
//)
@RequestMapping(value = Constants.BasePath.SECURE_WALL_MESSAGES)
@RestController
//@RequestScope
public class WallMessageController {
//    @Qualifier("bulletinServiceFeign")
    @Autowired
    private IBulletinService service;

//    @Deprecated
    @Operation(summary = "Create a wall message, service")
    @PostMapping(value = "/create")
    public Bulletin createWallMessage(@RequestHeader("USER-ID") Long userId,
                                      @RequestHeader("ACCOUNT-ID") Long accountId,
                                      @RequestBody WallMessageCreateInput input){
        return service.save(userId, accountId, input);
    }
}
