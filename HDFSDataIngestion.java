import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.FileSystem;

import org.apache.hadoop.fs.Path;



import java.io.File;

import java.net.URI;



public class HDFSingestion {
        public static void main(String[] args) throws Exception {
                String localPath = "/home/hadoop";
                String hdfsDir = "/input";
                Configuration conf = new Configuration();
                FileSystem fs = FileSystem.get(new URI("hdfs://namenode:9870"), conf);
                File localDir = new File(localPath);
                File[] files = localDir.listFiles();
                if (files != null) {
                        for (File file : files) {
                                if (file.isFile()) {
                                        Path local = new Path(file.getAbsolutePath());
                                        Path hdfsPath = new Path(hdfsDir + "/" + file.getName());
                                        System.out.println("Uploading " + local + " to " + hdfsPath);
                                        fs.copyFromLocalFile(false, true, local, hdfsPath);
                                }                                                                                                                                                                                                              }                                                                                                                                                                                                   } else {
                                        System.out.println("Directory not found or empty: " + localPath);

             }
             fs.close();

             }                                                                                                                                                                                                           }
