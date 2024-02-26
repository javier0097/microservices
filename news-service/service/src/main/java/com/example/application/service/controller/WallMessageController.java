package com.example.application.service.controller;


import com.example.application.api.input.WallMessageCreateInput;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Api(
//        tags = "Wall message",
//        description = "Operation over wall messages"
//)
//@RequestMapping(value = Constants.BasePath.SECURE_WALL_MESSAGES)
@RestController
//@RequestScope
public class WallMessageController {
//    @Qualifier("bulletinServiceFeign")
//    @Autowired
//    private IBulletinService service;

//    @Deprecated
//    @ApiOperation(value = "Create a wall message, service")
//    @PostMapping(value = "/create")
    public void createWallMessage(@RequestBody WallMessageCreateInput input){
        throw new UnsupportedOperationException("implementation is pending");
    }
}
