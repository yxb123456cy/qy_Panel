package org.qy.panel.paneldocker.serivce;

import com.github.dockerjava.api.model.Info;
import org.qy.panel.paneldocker.entity.Response;

import java.util.Map;

public interface InfoService {

     Response<Map<String,Object>> getInfo();
}
