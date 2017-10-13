package com.settle.client;

import com.settle.util.ClientSpringContextUtil;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCompute;
import org.apache.ignite.Ignition;
import org.apache.ignite.cluster.ClusterGroup;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.lang.IgniteRunnable;
import org.springframework.stereotype.Service;

@Service("clientNode")
public class ClientNode {

    public void start() {

        IgniteConfiguration cfg = (IgniteConfiguration) ClientSpringContextUtil.getBean("ignite.client.cfg");
        Ignite ignite = Ignition.start(cfg);


        ClusterGroup remoteGroup = ignite.cluster().forRemotes();
        // Limit computations only to remote nodes (exclude local node).
        IgniteCompute compute = ignite.compute(remoteGroup);


        // Execute computation on the server nodes (default behavior).
        compute.broadcast(new IgniteRunnable() {
            @Override
            public void run() {
                // Print ID of remote node on remote node.
                System.out.println(">>> Hello Node: ");
            }
        });

    }
}