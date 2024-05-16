package hello.proxy.app.v1;

import org.springframework.web.bind.annotation.*;

@RequestMapping
@ResponseBody
public interface OrderControllerV1 {
    @GetMapping("/v1/request")
    String request(@RequestParam String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}