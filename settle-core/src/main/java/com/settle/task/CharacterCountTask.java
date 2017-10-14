package com.settle.task;

import org.apache.ignite.cluster.ClusterNode;
import org.apache.ignite.compute.ComputeJob;
import org.apache.ignite.compute.ComputeJobAdapter;
import org.apache.ignite.compute.ComputeJobResult;
import org.apache.ignite.compute.ComputeTaskSplitAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyaping on 17/10/14.
 */
public class CharacterCountTask extends ComputeTaskSplitAdapter<String, Integer> {
    // 1. Splits the received string into to words
    // 2. Creates a child job for each word
    // 3. Sends created jobs to other nodes for processing.
    @Override
    public List<ComputeJob> split(int gridSize, String arg) {
        String[] words = arg.split(" ");
        List<ComputeJob> jobs = new ArrayList<>(words.length);
        for (final String word : arg.split(" ")) {
            jobs.add(new ComputeJobAdapter() {
                @Override
                public Object execute() {
                    System.out.println(">>> Printing '" + word + "' on from compute job.");
                    // Return number of letters in the word.
                    return word.length();
                }
            });
        }
        return jobs;
    }

    @Override
    public Integer reduce(List<ComputeJobResult> results) {
        int sum = 0;
        for (ComputeJobResult res : results)
            sum += res.<Integer>getData();
        return sum;
    }
}
