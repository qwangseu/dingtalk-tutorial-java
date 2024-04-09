package org.example.ai.actions;

import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author feiyin
 * @date 2024/4/9
 */
@RestController
@RequestMapping("/v1/actions/example/weather")
public class WeatherController {
    @GetMapping("/get")
    @ResponseBody
    public Map<String, Object> get(@RequestParam(value = "location", required = false) String location,
                                   @RequestParam(value = "date", required = false) String date) {
        Map<String, Object> result = new HashMap<>();
        if (location == null || location.isEmpty()) {
            location = "杭州";
        }
        if (date == null || date.isEmpty()) {
            date = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        }
        result.put("location", location);
        result.put("dateStr", date);
        result.put("text", "晴天");
        result.put("temperature", 22);
        result.put("humidity", 65);
        result.put("wind_direction", "东南风");
        return result;
    }
}
