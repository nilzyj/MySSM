package com.dim.beginspring;

import com.dim.beginspring.ao.UserAO;
import com.dim.beginspring.dal.domain.UserDto;
import com.dim.beginspring.dal.domain.UserPO;
import com.dim.beginspring.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*基于注解的控制器，可以同时处理多个请求动作，并且无须实现任何接口*/
@Controller
public class HelloReaderController {

    Logger log = Logger.getLogger("HelloReaderController.class");

    @Autowired
    private UserAO userAO;

    /*RequestMapping用来映射请求的URL和请求的方法等*/
    /*该方法返回一个包含视图名或视图名和模型的ModelAndView对象*/
    @RequestMapping("/hello")
    public ModelAndView sayHello(UserDto userDto) {
        Map<String, Object> map = new HashMap<>();
        String name = userDto.getName();
        int age = userDto.getAge();

        User user = new User();
        user.setName(name);
        user.setAge(age);
//        user.setName("one");
//        user.setAge(1);

        List<UserPO> sList = userAO.selectUserByNameAndAge(user);

        map.put("data", sList);
        ModelAndView mv = new ModelAndView("helloReader", map);
        return mv;
    }
}
