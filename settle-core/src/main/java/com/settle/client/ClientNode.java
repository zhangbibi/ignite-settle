package com.settle.client;

import com.settle.util.SpringContextUtil;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.cluster.ClusterGroup;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.lang.IgniteRunnable;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service("clientNode")
public class ClientNode {

    public void start() {

        IgniteConfiguration cfg = (IgniteConfiguration) SpringContextUtil.getBean("ignite.client.cfg");
        Ignite ignite = Ignition.start(cfg);

        ClusterGroup remoteGroup = ignite.cluster().forRemotes();

        ExecutorService exec = ignite.executorService(remoteGroup);
        for (final String word : "Print words using runnable".split(" ")) {
            // Execute runnable on some node.
            exec.submit(new IgniteRunnable() {
                @Override
                public void run() {
                    System.out.println(">>> Printing '" + word + "' on this node from grid job.");
                }
            });
        }

    }
}
