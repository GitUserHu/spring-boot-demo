package com.example.Springbootdemo;

import com.example.Springbootdemo.bean.MyBean;
import com.example.Springbootdemo.config.ConfigDemo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@SpringBootApplication
@RestController
public class SpringBootDemoApplication {

    @Autowired
    private transient MyBean myBean;
    @Autowired
    private transient ConfigDemo configDemo;

    Logger log = LogManager.getLogger(SpringBootDemoApplication.class);

    public static void main(String[] args) {
		System.out.println("Call Main function. After then, start to configure Web Application.");
//		SpringApplication.
		SpringApplication.run(SpringBootDemoApplication.class, args);
        System.out.println("Configure Web Application successfully.");

	}
	@RequestMapping("/configuration")
	public List configurations() {
		return configDemo.getNames();
	}

	@RequestMapping("/configure")
	public String home() {
   		StringBuilder stringBuilder = new StringBuilder(" hello world,")
				.append(" server port : " + myBean.getServerPort())
				.append(" system int value : " + myBean.getSysIntVal())
				.append(" system secret : " + myBean.getSysSecret())
				.append(" system long value : " + myBean.getSysLongVal())
				.append(" system uuid : " + myBean.getSysUUID());

		return stringBuilder.toString();
	}
	/*@GetMapping("/")
	public String welcome() {
        return "welcome?????";
    }*/
    @GetMapping("/login")
    public ModelAndView login() {

        log.info("go to login page");
        return new ModelAndView("login");
    }
}
