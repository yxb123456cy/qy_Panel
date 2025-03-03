package org.qy.panel.paneldocker.serivce;

import com.github.dockerjava.api.command.CreateNetworkResponse;
import com.github.dockerjava.api.model.Network;
import org.qy.panel.paneldocker.entity.Response;

import java.util.List;

/**
 * Docker 网络 服务类;
 */
public interface NetWorkService {

    /**
     * 获取Docker 网络列表;
     * @return Response<List < Network>>
     */
    Response<List<Network>> getNetworkList();

    Response<Network> getNetWorkById(String netWorkID);

    Response<CreateNetworkResponse> createNetWork(String netWorkName, boolean isIPV6, String driver);

    Response<Void> deleteNetWork(String netWorkID);
}
