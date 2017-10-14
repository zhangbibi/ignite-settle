package com.settle.server;

import com.settle.util.SpringContextUtil;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.stereotype.Service;

/**
 * Created by zhangyaping on 17/8/27.
 */

@Service("serverNode")
public class ServerNode {

    public void start(){
        IgniteConfiguration cfg = (IgniteConfiguration) SpringContextUtil.getBean("ignite.cluster.cfg");
        Ignite ignite = Ignition.start(cfg);
    }

}
