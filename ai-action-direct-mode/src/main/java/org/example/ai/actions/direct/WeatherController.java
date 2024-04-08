package org.example.ai.actions.direct;

import jdk.internal.joptsimple.internal.Strings;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author feiyin
 * @date 2024/4/8
 */
@RestController
@RequestMapping("/v1/actions/example/weather")
public class WeatherController {
    @GetMapping("/get")
    @ResponseBody
    public Map<String, Object> get(@RequestParam(value = "input", required = false) String input,
                                   @RequestParam(value = "inputAttribute", required = false) String attribute,
                                   @RequestParam(value = "sender", required = false) String sender) {
        Map<String, Object> result = new HashMap<>();
        String location = "杭州";
        String dateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        result.put("location", location);
        result.put("dateStr", dateStr);
        result.put("text", "晴天");
        result.put("temperature", 22);
        result.put("humidity", 65);
        result.put("wind_direction", "东南风");
        return result;
    }
}
