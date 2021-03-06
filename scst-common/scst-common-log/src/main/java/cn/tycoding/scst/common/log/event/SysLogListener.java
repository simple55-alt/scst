package cn.tycoding.scst.common.log.event;

import cn.tycoding.scst.system.api.entity.SysLog;
import cn.tycoding.scst.system.api.feign.RemoteLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * @author tycoding
 * @date 2019-06-09
 */
@Slf4j
@AllArgsConstructor
public class SysLogListener {
    private final RemoteLogService remoteLogService;

    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        SysLog sysLog = (SysLog) event.getSource();
        remoteLogService.saveLog(sysLog);
    }

}
