package com.dim.beginspring;

import com.dim.beginspring.ao.UserAO;
import com.dim.beginspring.dal.domain.UserPO;
import com.dim.beginspring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloReaderController {

    @Autowired
    private UserAO userAO;

    @RequestMapping("/hello")
    public ModelAndView sayHello(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = new User();
        user.setName(name);
        if (password != null)
        user.setAge(Integer.valueOf(password));

        List<UserPO> sList = userAO.selectUserByNameAndAge(user);

        Map<String, Object> map = new HashMap<>();
        List<UserPO> list = userAO.getUser();
        map.put("message", list);
        map.put("query", sList);
        ModelAndView mv = new ModelAndView("helloReader", map);
        return mv;
    }
}
