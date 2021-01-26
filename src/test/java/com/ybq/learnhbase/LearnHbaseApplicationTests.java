package com.ybq.learnhbase;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class LearnHbaseApplicationTests {

    /**
     * 内部已实现线程安全的连接池
     */
    @Autowired
    private Connection hbaseConnection;

    @Test
    void contextLoads() {
    }

    @Test
    public void aaaa() throws IOException {
        try (Table table = hbaseConnection.getTable(TableName.valueOf("表名"))) {//获取表连接
            //配置一条数据
            // 行键
            Put put = new Put(Bytes.toBytes("key主键"));
            put.addColumn(Bytes.toBytes("列族"), Bytes.toBytes("列"), Bytes.toBytes("值"));
        //每个有数据的列都要一个addColumn
            //put插入数据
            table.put(put);
        }

    }

}
